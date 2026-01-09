package com.aeu.boxapplication.domain.repository

import com.aeu.boxapplication.core.network.NetworkResult
import com.aeu.boxapplication.domain.model.Payment
import kotlinx.coroutines.flow.Flow

interface PaymentRepository {
    suspend fun processPayment(subscriptionId: String, paymentMethodId: String): NetworkResult<Payment>
    suspend fun getPaymentHistory(page: Int): NetworkResult<List<Payment>>
    suspend fun setupRecurringPayment(subscriptionId: String, paymentMethodId: String): NetworkResult<Payment>
    suspend fun refundPayment(paymentId: String): NetworkResult<Payment>
    suspend fun updatePaymentMethod(paymentMethodId: String): NetworkResult<Unit>
    fun getPaymentHistoryFromLocal(): Flow<List<Payment>>
    suspend fun clearCache()
}
