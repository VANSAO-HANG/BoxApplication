package com.aeu.boxapplication.data.mapper

import com.aeu.boxapplication.core.utils.DateUtils
import com.aeu.boxapplication.data.local.entity.UserEntity
import com.aeu.boxapplication.data.remote.dto.response.UserResponse
import com.aeu.boxapplication.domain.model.User
import java.text.SimpleDateFormat
import java.util.*

object UserMapper {

    fun toDomain(response: UserResponse): User {
        return User(
            id = response.id,
            email = response.email,
            name = response.name,
            phone = response.phone,
            role = response.role,
            createdAt = parseDate(response.createdAt),
            updatedAt = parseDate(response.updatedAt),
            profileImageUrl = response.profileImageUrl,
            isActive = response.isActive
        )
    }

    fun toDomain(entity: UserEntity): User {
        return User(
            id = entity.id,
            email = entity.email,
            name = entity.name,
            phone = entity.phone,
            role = entity.role,
            createdAt = entity.createdAt,
            updatedAt = entity.updatedAt,
            profileImageUrl = entity.profileImageUrl,
            isActive = entity.isActive
        )
    }

    fun toEntity(domain: User): UserEntity {
        return UserEntity(
            id = domain.id,
            email = domain.email,
            name = domain.name,
            phone = domain.phone,
            role = domain.role,
            createdAt = domain.createdAt,
            updatedAt = domain.updatedAt,
            profileImageUrl = domain.profileImageUrl,
            isActive = domain.isActive
        )
    }

    private fun parseDate(dateString: String): Date {
        return try {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(dateString) ?: Date()
        } catch (e: Exception) {
            Date()
        }
    }
}
