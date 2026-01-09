package com.aeu.boxapplication.domain.repository

import com.aeu.boxapplication.core.network.NetworkResult

interface ReportRepository {
    suspend fun getChurnRate(startDate: String, endDate: String): NetworkResult<Map<String, Any>>
    suspend fun getRevenueReport(startDate: String, endDate: String): NetworkResult<Map<String, Any>>
    suspend fun getActiveSubscribers(): NetworkResult<Map<String, Any>>
    suspend fun getAnalytics(startDate: String, endDate: String): NetworkResult<Map<String, Any>>
    suspend fun clearCache()
}
