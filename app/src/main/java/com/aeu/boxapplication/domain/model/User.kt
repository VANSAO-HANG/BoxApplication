package com.aeu.boxapplication.domain.model

import java.util.Date

data class User(
    val id: String,
    val email: String,
    val name: String,
    val phone: String?,
    val role: String,
    val createdAt: Date,
    val updatedAt: Date,
    val profileImageUrl: String? = null,
    val isActive: Boolean = true
)
