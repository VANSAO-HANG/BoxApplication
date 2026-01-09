package com.aeu.boxapplication.domain.model

import java.util.Date

data class Inventory(
    val id: String,
    val productId: String,
    val product: Product?,
    val quantity: Int,
    val allocatedQuantity: Int,
    val availableQuantity: Int,
    val reorderLevel: Int,
    val lastRestocked: Date?,
    val location: String?
)
