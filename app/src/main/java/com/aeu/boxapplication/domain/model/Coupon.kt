package com.aeu.boxapplication.domain.model

import java.util.Date

data class Coupon(
    val id: String,
    val code: String,
    val description: String,
    val discountType: String, // percentage, fixed
    val discountValue: Double,
    val minPurchaseAmount: Double?,
    val maxDiscountAmount: Double?,
    val validFrom: Date,
    val validUntil: Date,
    val usageLimit: Int?,
    val usageCount: Int,
    val isActive: Boolean,
    val applicablePlans: List<String>?
)
