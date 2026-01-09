package com.aeu.boxapplication.core.base

data class BaseResponse<T>(
    val success: Boolean,
    val message: String?,
    val data: T?,
    val error: ErrorResponse? = null
)

data class ErrorResponse(
    val code: Int,
    val message: String,
    val details: Map<String, String>? = null
)
