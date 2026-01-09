package com.aeu.boxapplication.data.remote.dto.response

import com.google.gson.annotations.SerializedName

data class CouponResponse(
    @SerializedName("id")
    val id: String,
    
    @SerializedName("code")
    val code: String,
    
    @SerializedName("description")
    val description: String,
    
    @SerializedName("discount_type")
    val discountType: String,
    
    @SerializedName("discount_value")
    val discountValue: Double,
    
    @SerializedName("valid_from")
    val validFrom: String,
    
    @SerializedName("valid_until")
    val validUntil: String,
    
    @SerializedName("usage_limit")
    val usageLimit: Int?,
    
    @SerializedName("usage_count")
    val usageCount: Int,
    
    @SerializedName("is_active")
    val isActive: Boolean
)
