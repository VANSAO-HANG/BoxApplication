package com.aeu.boxapplication.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val price: Double,
    val imageUrl: String?,
    val sku: String,
    val quantity: Int,
    val inStock: Boolean
)
