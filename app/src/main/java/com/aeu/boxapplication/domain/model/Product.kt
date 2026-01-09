package com.aeu.boxapplication.domain.model

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val price: Double,
    val imageUrl: String?,
    val sku: String,
    val weight: Double?,
    val dimensions: String?
)
