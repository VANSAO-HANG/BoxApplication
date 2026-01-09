package com.aeu.boxapplication.data.remote.dto.request

import com.google.gson.annotations.SerializedName

data class UpdateProfileRequest(
    @SerializedName("name")
    val name: String,
    
    @SerializedName("phone")
    val phone: String?,
    
    @SerializedName("profile_image_url")
    val profileImageUrl: String?
)
