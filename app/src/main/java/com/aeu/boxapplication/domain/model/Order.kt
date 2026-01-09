package com.aeu.boxapplication.domain.model

import java.util.Date

data class Order(
    val id: String,
    val userId: String,
    val subscriptionId: String?,
    val status: String,
    val items: List<OrderItem>,
    val subtotal: Double,
    val tax: Double,
    val discount: Double,
    val total: Double,
    val shippingAddress: Address,
    val createdAt: Date,
    val updatedAt: Date
)

data class OrderItem(
    val productId: String,
    val product: Product?,
    val quantity: Int,
    val price: Double,
    val total: Double
)
