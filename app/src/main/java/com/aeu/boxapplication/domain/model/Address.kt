package com.aeu.boxapplication.domain.model

data class Address(
    val id: String? = null,
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val country: String,
    val apartment: String? = null,
    val isDefault: Boolean = false
)
