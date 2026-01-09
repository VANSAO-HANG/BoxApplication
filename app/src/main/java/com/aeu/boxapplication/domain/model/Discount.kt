package com.aeu.boxapplication.domain.model

data class Discount(
    val id: String,
    val name: String,
    val type: String,
    val value: Double,
    val appliedTo: String,
    val conditions: Map<String, String>?
)
