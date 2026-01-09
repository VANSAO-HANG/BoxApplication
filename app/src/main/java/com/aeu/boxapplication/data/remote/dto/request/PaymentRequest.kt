package com.aeu.boxapplication.data.remote.dto.request

import com.google.gson.annotations.SerializedName

data class PaymentRequest(
    @SerializedName("subscription_id")
    val subscriptionId: String,
    
    @SerializedName("payment_method_id")
    val paymentMethodId: String,
    
    @SerializedName("amount")
    val amount: Double,
    
    @SerializedName("currency")
    val currency: String = "USD"
)
