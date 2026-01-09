package com.aeu.boxapplication.domain.model

import java.util.Date

data class Subscription(
    val id: String,
    val userId: String,
    val planId: String,
    val plan: SubscriptionPlan?,
    val status: String, // active, paused, cancelled, expired
    val startDate: Date,
    val endDate: Date?,
    val nextBillingDate: Date?,
    val autoRenew: Boolean,
    val createdAt: Date,
    val updatedAt: Date
)
