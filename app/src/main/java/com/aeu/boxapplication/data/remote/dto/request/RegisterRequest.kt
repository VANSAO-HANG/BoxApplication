package com.aeu.boxapplication.data.remote.dto.request

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("email")
    val email: String,
    
    @SerializedName("password")
    val password: String,
    
    @SerializedName("name")
    val name: String,
    
    @SerializedName("phone")
    val phone: String? = null
)
