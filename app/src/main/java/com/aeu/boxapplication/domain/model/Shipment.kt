package com.aeu.boxapplication.domain.model

import java.util.Date

data class Shipment(
    val id: String,
    val orderId: String,
    val userId: String,
    val trackingNumber: String?,
    val carrier: String,
    val status: String, // pending, processing, shipped, delivered
    val shippingAddress: Address,
    val estimatedDelivery: Date?,
    val actualDelivery: Date?,
    val manifestData: String?,
    val createdAt: Date,
    val updatedAt: Date
)
