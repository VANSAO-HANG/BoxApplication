package com.aeu.boxapplication.data.remote.dto.request

import com.google.gson.annotations.SerializedName

data class SubscriptionRequest(
    @SerializedName("plan_id")
    val planId: String,
    
    @SerializedName("auto_renew")
    val autoRenew: Boolean = true,
    
    @SerializedName("coupon_code")
    val couponCode: String? = null
)
