package com.aeu.boxapplication.data.remote.dto.response

import com.google.gson.annotations.SerializedName

data class InventoryResponse(
    @SerializedName("id")
    val id: String,
    
    @SerializedName("product_id")
    val productId: String,
    
    @SerializedName("quantity")
    val quantity: Int,
    
    @SerializedName("allocated_quantity")
    val allocatedQuantity: Int,
    
    @SerializedName("available_quantity")
    val availableQuantity: Int,
    
    @SerializedName("reorder_level")
    val reorderLevel: Int,
    
    @SerializedName("last_restocked")
    val lastRestocked: String?,
    
    @SerializedName("location")
    val location: String?
)
