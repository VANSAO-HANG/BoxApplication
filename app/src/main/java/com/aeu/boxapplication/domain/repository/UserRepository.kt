package com.aeu.boxapplication.domain.repository

import com.aeu.boxapplication.core.network.NetworkResult
import com.aeu.boxapplication.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun login(email: String, password: String): NetworkResult<User>
    suspend fun register(email: String, password: String, name: String): NetworkResult<User>
    suspend fun logout(): NetworkResult<Unit>
    suspend fun getUserProfile(): NetworkResult<User>
    suspend fun updateUserProfile(user: User): NetworkResult<User>
    suspend fun getSubscribers(page: Int): NetworkResult<List<User>>
    fun getUserFromLocal(userId: String): Flow<User?>
    suspend fun saveUserToLocal(user: User)
    suspend fun clearCache()
}
