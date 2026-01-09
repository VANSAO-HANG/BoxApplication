package com.aeu.boxapplication.domain.repository

import com.aeu.boxapplication.core.network.NetworkResult
import com.aeu.boxapplication.domain.model.Coupon
import kotlinx.coroutines.flow.Flow

interface CouponRepository {
    suspend fun getCoupons(): NetworkResult<List<Coupon>>
    suspend fun validateCoupon(code: String): NetworkResult<Coupon>
    suspend fun applyCoupon(code: String, subscriptionId: String): NetworkResult<Coupon>
    suspend fun createCoupon(coupon: Coupon): NetworkResult<Coupon>
    fun getCouponsFromLocal(): Flow<List<Coupon>>
    suspend fun clearCache()
}
