package com.aeu.boxapplication.domain.model

data class Admin(
    val user: User,
    val permissions: List<String>,
    val department: String?
)
