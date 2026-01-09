# Architecture Documentation

## Overview

The Box Subscription Management System follows **Clean Architecture** principles with **MVVM** pattern for a scalable, testable, and maintainable codebase.

## Architecture Layers

### 1. Presentation Layer (UI)

**Responsibility**: Handle UI rendering and user interactions

**Components**:

- **Composables**: Jetpack Compose UI screens
- **ViewModels**: Manage UI state and business logic coordination
- **State Classes**: Represent UI states
- **Event Classes**: Represent user actions

**Example Flow**:

```
User Action → Event → ViewModel → Use Case → Repository → Network/Database
                         ↓
                   State Update → UI Recomposition
```

### 2. Domain Layer (Business Logic)

**Responsibility**: Core business logic and rules

**Components**:

- **Models**: Pure Kotlin data classes representing business entities
- **Use Cases**: Single-responsibility business operations
- **Repository Interfaces**: Contracts for data operations

**Principles**:

- No Android dependencies
- Framework-independent
- Testable without Android framework

### 3. Data Layer

**Responsibility**: Data management and persistence

**Components**:

- **Repository Implementations**: Coordinate data from multiple sources
- **Data Sources**:
  - **Remote**: API services (Retrofit)
  - **Local**: Room database
- **DTOs**: Data Transfer Objects for API responses
- **Entities**: Room database entities
- **Mappers**: Convert between layers

## Module Structure

### Module 1: User Management

```
domain/
  ├── model/
  │   ├── User.kt
  │   ├── Admin.kt
  │   └── Subscriber.kt
  ├── repository/
  │   └── UserRepository.kt
  └── usecase/
      └── auth/
          ├── LoginUseCase.kt
          ├── RegisterUseCase.kt
          └── LogoutUseCase.kt

data/
  ├── remote/
  │   └── api/
  │       └── UserApi.kt
  ├── local/
  │   └── entity/
  │       └── UserEntity.kt
  └── repository/
      └── UserRepositoryImpl.kt

presentation/
  ├── auth/
  │   ├── LoginViewModel.kt
  │   ├── LoginScreen.kt
  │   └── AuthState.kt
  └── admin/
      └── dashboard/
```

### Module 2-10: Similar Structure

Each module follows the same layered approach:

- Domain models and use cases
- Data repositories and API services
- Presentation ViewModels and Screens

## Design Patterns

### 1. Repository Pattern

Abstracts data sources from business logic:

```kotlin
interface UserRepository {
    suspend fun login(email: String, password: String): NetworkResult<User>
}

class UserRepositoryImpl(
    private val api: ApiService,
    private val dao: UserDao
) : UserRepository {
    override suspend fun login(...) = // Implementation
}
```

### 2. Use Case Pattern

Single responsibility for business operations:

```kotlin
class LoginUseCase(
    private val repository: UserRepository
) : BaseUseCase<Params, NetworkResult<User>>() {
    override suspend fun execute(params: Params) = 
        repository.login(params.email, params.password)
}
```

### 3. State Management

Unidirectional data flow with StateFlow:

```kotlin
sealed class AuthEvent {
    data class Login(val email: String, val password: String) : AuthEvent()
}

data class AuthState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String? = null
)

class LoginViewModel : BaseViewModel<AuthState, AuthEvent>() {
    val state: StateFlow<AuthState>
}
```

## Dependency Injection

### Hilt Modules

**AppModule**: Application-level dependencies

```kotlin
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context) = context
}
```

**NetworkModule**: Network dependencies

```kotlin
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideApiService(retrofit: RetrofitClient) = retrofit.createService<ApiService>()
}
```

**DatabaseModule**: Database dependencies

```kotlin
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = 
        Room.databaseBuilder(context, AppDatabase::class.java, "db").build()
}
```

**RepositoryModule**: Repository bindings

```kotlin
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}
```

## Data Flow

### Read Operation

```
UI (Composable)
    ↓
ViewModel
    ↓
Use Case
    ↓
Repository
    ↓
Data Source (API/DB)
    ↓
Mapper
    ↓
Domain Model
    ↓
StateFlow
    ↓
UI Update (Recomposition)
```

### Write Operation

```
User Input
    ↓
Event
    ↓
ViewModel.handleEvent()
    ↓
Use Case
    ↓
Repository
    ↓
Data Source (API/DB)
    ↓
State Update
    ↓
UI Feedback
```

## Error Handling

### NetworkResult Wrapper

```kotlin
sealed class NetworkResult<T> {
    class Success<T>(data: T) : NetworkResult<T>()
    class Error<T>(message: String) : NetworkResult<T>()
    class Loading<T> : NetworkResult<T>()
}
```

### Usage in Repository

```kotlin
override suspend fun login(...): NetworkResult<User> {
    return try {
        val response = apiService.login(...)
        if (response.isSuccessful) {
            NetworkResult.Success(response.body()!!)
        } else {
            NetworkResult.Error("Login failed")
        }
    } catch (e: Exception) {
        NetworkResult.Error(e.message ?: "Unknown error")
    }
}
```

## Background Processing

### WorkManager for Scheduled Tasks

```kotlin
@HiltWorker
class RenewalNotificationWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val repository: SubscriptionRepository
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        // Check renewals and send notifications
        return Result.success()
    }
}
```

## Cloud Integration

### Firebase/Firestore

- **Authentication**: Firebase Auth
- **Database**: Firestore
- **Storage**: Cloud Storage
- **Functions**: Cloud Functions
- **Messaging**: FCM

### Stripe Integration

- **Payments**: Stripe SDK
- **Webhooks**: Cloud Functions
- **Recurring Billing**: Stripe Subscriptions

## Security

### Authentication

- JWT tokens stored securely
- Token refresh mechanism
- Interceptor adds auth headers

### Data Protection

- Sensitive data encrypted
- Firestore security rules
- API authentication required

### Payment Security

- Stripe PCI compliance
- No card data stored locally
- Webhook signature verification

## Testing Strategy

### Unit Tests

```kotlin
class LoginUseCaseTest {
    @Test
    fun `login with valid credentials returns success`() = runTest {
        // Arrange
        val mockRepository = mockk<UserRepository>()
        coEvery { mockRepository.login(any(), any()) } returns 
            NetworkResult.Success(mockUser)
        
        // Act
        val result = loginUseCase(params)
        
        // Assert
        assertTrue(result is NetworkResult.Success)
    }
}
```

### Integration Tests

- Test Repository implementations
- Test API integration
- Test Database operations

### UI Tests

- Compose UI tests
- Screen navigation tests
- User flow tests

## Performance Optimization

### Caching Strategy

- Local database for offline support
- API response caching
- Image caching with Coil

### Pagination

- Paging 3 library for lists
- Lazy loading
- Load more on scroll

### Background Sync

- WorkManager for periodic sync
- Retry policies
- Battery optimization

## Scalability

### Modular Architecture

- Feature modules
- Reusable components
- Dependency isolation

### Cloud Scalability

- Auto-scaling Cloud Functions
- Firestore horizontal scaling
- CDN for static assets

## Future Enhancements

1. **Multi-language Support**: i18n implementation
2. **Offline-First**: Enhanced offline capabilities
3. **Analytics**: Advanced user behavior tracking
4. **A/B Testing**: Feature experimentation
5. **Push Notifications**: Real-time updates
6. **Widgets**: Home screen widgets
7. **Wear OS**: Smartwatch companion app
8. **Tablet Optimization**: Adaptive layouts
