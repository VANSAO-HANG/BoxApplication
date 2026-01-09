package com.aeu.boxapplication.domain.model

import java.util.Date

data class Notification(
    val id: String,
    val userId: String,
    val title: String,
    val message: String,
    val type: String, // renewal, shipment, payment, general
    val isRead: Boolean,
    val createdAt: Date,
    val data: Map<String, String>?
)
