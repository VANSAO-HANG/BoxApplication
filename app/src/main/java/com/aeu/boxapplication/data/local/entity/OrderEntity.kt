package com.aeu.boxapplication.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "orders")
data class OrderEntity(
    @PrimaryKey
    val id: String,
    val userId: String,
    val subscriptionId: String?,
    val status: String,
    val subtotal: Double,
    val tax: Double,
    val discount: Double,
    val total: Double,
    val createdAt: Date,
    val updatedAt: Date
)
