package com.aeu.boxapplication.data.remote.dto.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id")
    val id: String,
    
    @SerializedName("email")
    val email: String,
    
    @SerializedName("name")
    val name: String,
    
    @SerializedName("phone")
    val phone: String?,
    
    @SerializedName("role")
    val role: String,
    
    @SerializedName("created_at")
    val createdAt: String,
    
    @SerializedName("updated_at")
    val updatedAt: String,
    
    @SerializedName("profile_image_url")
    val profileImageUrl: String?,
    
    @SerializedName("is_active")
    val isActive: Boolean = true
)
