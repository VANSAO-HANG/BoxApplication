package com.aeu.boxapplication.data.remote.dto.request

import com.google.gson.annotations.SerializedName

data class InventoryRequest(
    @SerializedName("product_id")
    val productId: String,
    
    @SerializedName("quantity")
    val quantity: Int,
    
    @SerializedName("location")
    val location: String? = null
)
