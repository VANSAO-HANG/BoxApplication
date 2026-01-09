package com.aeu.boxapplication.data.remote.dto.response

import com.google.gson.annotations.SerializedName

data class ReportResponse(
    @SerializedName("success")
    val success: Boolean,
    
    @SerializedName("data")
    val data: Map<String, Any>
)
