package com.aeu.boxapplication.domain.repository

import com.aeu.boxapplication.core.network.NetworkResult
import com.aeu.boxapplication.domain.model.CustomerProfile
import com.aeu.boxapplication.domain.model.Preference
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    suspend fun getCustomerProfile(): NetworkResult<CustomerProfile>
    suspend fun updateCustomerProfile(profile: CustomerProfile): NetworkResult<CustomerProfile>
    suspend fun getPreferences(): NetworkResult<Preference>
    suspend fun updatePreferences(preferences: Preference): NetworkResult<Preference>
    fun getProfileFromLocal(): Flow<CustomerProfile?>
    suspend fun clearCache()
}
