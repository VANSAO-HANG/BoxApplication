package com.aeu.boxapplication.data.remote.dto.response

import com.google.gson.annotations.SerializedName

data class PaymentResponse(
    @SerializedName("id")
    val id: String,
    
    @SerializedName("user_id")
    val userId: String,
    
    @SerializedName("subscription_id")
    val subscriptionId: String,
    
    @SerializedName("amount")
    val amount: Double,
    
    @SerializedName("currency")
    val currency: String,
    
    @SerializedName("status")
    val status: String,
    
    @SerializedName("payment_method")
    val paymentMethod: String,
    
    @SerializedName("stripe_payment_id")
    val stripePaymentId: String?,
    
    @SerializedName("transaction_date")
    val transactionDate: String,
    
    @SerializedName("description")
    val description: String?
)
