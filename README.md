# Box Subscription Management System

A comprehensive Android application for managing subscription box services with cloud backend integration.

## 📱 Features

### User Management (Module 1)

- Admin and Subscriber role management
- User authentication and authorization
- Profile management

### Subscription Plans (Module 2)

- Multiple tier plans (Basic, Standard, Premium, VIP)
- Flexible billing frequencies (Weekly, Bi-weekly, Monthly, Quarterly)
- Plan comparison and selection

### Billing & Payment Integration (Module 3)

- Stripe payment processing
- Recurring payment setup
- Payment history tracking
- Refund management

### Inventory Management (Module 4)

- Real-time inventory tracking
- Automated allocation
- Low stock alerts

### Shipment Management (Module 5)

- Automated manifest generation
- Shipment tracking
- Delivery status updates

### Customer Profile & Preferences (Module 6)

- Personalized preferences
- Dietary restrictions and allergies
- Delivery preferences

### Subscription Lifecycle (Module 7)

- Pause/Resume subscriptions
- Upgrade/Downgrade plans
- Cancellation management

### Email Notifications (Module 8)

- Renewal reminders
- Shipment notifications
- Payment confirmations

### Coupon & Discount System (Module 9)

- Coupon code validation
- Percentage and fixed discounts
- Usage limits and expiration

### Analytics & Reports (Module 10)

- Churn rate analysis
- Revenue reports
- Active subscriber metrics
- Custom analytics dashboard

## 🏗️ Architecture

### Clean Architecture

- **Presentation Layer**: Jetpack Compose UI, ViewModels
- **Domain Layer**: Use Cases, Business Logic, Domain Models
- **Data Layer**: Repositories, API Services, Local Database

### Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose
- **DI**: Hilt/Dagger
- **Database**: Room
- **Networking**: Retrofit + OkHttp
- **Async**: Kotlin Coroutines + Flow
- **Architecture**: MVVM + Clean Architecture
- **Cloud**: Firebase/Firestore
- **Payment**: Stripe API
- **Background Tasks**: WorkManager

## 📦 Project Structure

```
app/
├── core/                          # Core utilities
│   ├── base/                      # Base classes
│   ├── database/                  # Room database
│   ├── di/                        # Dependency injection
│   ├── network/                   # Network layer
│   └── utils/                     # Utilities
├── domain/                        # Business logic
│   ├── model/                     # Domain models
│   ├── repository/                # Repository interfaces
│   └── usecase/                   # Use cases
├── data/                          # Data layer
│   ├── local/                     # Local data sources
│   ├── remote/                    # Remote data sources
│   ├── mapper/                    # Data mappers
│   └── repository/                # Repository implementations
├── presentation/                  # UI layer
│   ├── auth/                      # Authentication screens
│   ├── subscription/              # Subscription management
│   ├── payment/                   # Payment screens
│   ├── inventory/                 # Inventory management
│   ├── shipment/                  # Shipment tracking
│   ├── customer/                  # Customer profile
│   ├── coupon/                    # Coupon management
│   ├── reports/                   # Analytics & reports
│   ├── navigation/                # Navigation
│   └── components/                # Reusable components
└── workers/                       # Background workers
```

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog or newer
- JDK 11 or higher
- Android SDK 24 or higher
- Google Cloud account
- Stripe account

### Setup

1. **Clone the repository**

```bash
git clone https://github.com/your-repo/box-application.git
cd box-application
```

1. **Configure API Keys**

Create a `local.properties` file:

```properties
STRIPE_PUBLISHABLE_KEY=your_stripe_publishable_key
GOOGLE_CLOUD_API_KEY=your_google_cloud_api_key
```

1. **Firebase Setup**

- Download `google-services.json` from Firebase Console
- Place it in the `app/` directory

1. **Update Constants**

Update [`core/utils/Constants.kt`](app/src/main/java/com/aeu/boxapplication/core/utils/Constants.kt):

```kotlin
const val BASE_URL = "your-cloud-function-url"
const val STRIPE_PUBLISHABLE_KEY = "your_stripe_key"
```

1. **Build the project**

```bash
./gradlew build
```

1. **Run the app**

```bash
./gradlew installDebug
```

## 🔧 Configuration

### Build Variants

- **Debug**: Development build with logging enabled
- **Release**: Production build with ProGuard enabled

### Environment Variables

Set in `build.gradle.kts`:

```kotlin
buildConfigField("String", "BASE_URL", "\"${project.property("BASE_URL")}\"")
```

## 🧪 Testing

Run unit tests:

```bash
./gradlew test
```

Run instrumentation tests:

```bash
./gradlew connectedAndroidTest
```

## 📚 Documentation

- [API Documentation](docs/API.md)
- [Architecture Guide](docs/ARCHITECTURE.md)
- [Database Schema](docs/DATABASE_SCHEMA.md)
- [Deployment Guide](docs/DEPLOYMENT.md)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Authors

- Your Team Name

## 🙏 Acknowledgments

- Stripe for payment processing
- Google Cloud Platform for backend infrastructure
- Jetpack Compose for modern UI development
