package com.aeu.boxapplication.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: String,
    val email: String,
    val name: String,
    val phone: String?,
    val role: String,
    val createdAt: Date,
    val updatedAt: Date,
    val profileImageUrl: String?,
    val isActive: Boolean
)
