package com.aeu.boxapplication.data.remote.dto.response

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("success")
    val success: Boolean,
    
    @SerializedName("message")
    val message: String?,
    
    @SerializedName("data")
    val data: AuthData?
)

data class AuthData(
    @SerializedName("user")
    val user: UserResponse,
    
    @SerializedName("token")
    val token: String
)
