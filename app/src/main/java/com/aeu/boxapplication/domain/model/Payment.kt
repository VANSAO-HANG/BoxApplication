package com.aeu.boxapplication.domain.model

import java.util.Date

data class Payment(
    val id: String,
    val userId: String,
    val subscriptionId: String,
    val amount: Double,
    val currency: String,
    val status: String, // pending, success, failed, refunded
    val paymentMethod: String,
    val stripePaymentId: String?,
    val transactionDate: Date,
    val description: String?,
    val metadata: Map<String, String>?
)
