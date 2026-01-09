package com.aeu.boxapplication.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "subscriptions")
data class SubscriptionEntity(
    @PrimaryKey
    val id: String,
    val userId: String,
    val planId: String,
    val planName: String?,
    val status: String,
    val startDate: Date,
    val endDate: Date?,
    val nextBillingDate: Date?,
    val autoRenew: Boolean,
    val createdAt: Date,
    val updatedAt: Date
)
