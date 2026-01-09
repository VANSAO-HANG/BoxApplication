package com.aeu.boxapplication.data.remote.dto.response

import com.google.gson.annotations.SerializedName

data class ShipmentResponse(
    @SerializedName("id")
    val id: String,
    
    @SerializedName("order_id")
    val orderId: String,
    
    @SerializedName("user_id")
    val userId: String,
    
    @SerializedName("tracking_number")
    val trackingNumber: String?,
    
    @SerializedName("carrier")
    val carrier: String,
    
    @SerializedName("status")
    val status: String,
    
    @SerializedName("shipping_address")
    val shippingAddress: AddressResponse,
    
    @SerializedName("estimated_delivery")
    val estimatedDelivery: String?,
    
    @SerializedName("actual_delivery")
    val actualDelivery: String?,
    
    @SerializedName("manifest_data")
    val manifestData: String?,
    
    @SerializedName("created_at")
    val createdAt: String,
    
    @SerializedName("updated_at")
    val updatedAt: String
)

data class AddressResponse(
    @SerializedName("street")
    val street: String,
    
    @SerializedName("city")
    val city: String,
    
    @SerializedName("state")
    val state: String,
    
    @SerializedName("zip_code")
    val zipCode: String,
    
    @SerializedName("country")
    val country: String
)
