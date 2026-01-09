package com.aeu.boxapplication.data.remote.dto.response

import com.google.gson.annotations.SerializedName

data class SubscriptionResponse(
    @SerializedName("id")
    val id: String,
    
    @SerializedName("user_id")
    val userId: String,
    
    @SerializedName("plan_id")
    val planId: String,
    
    @SerializedName("plan")
    val plan: SubscriptionPlanResponse?,
    
    @SerializedName("status")
    val status: String,
    
    @SerializedName("start_date")
    val startDate: String,
    
    @SerializedName("end_date")
    val endDate: String?,
    
    @SerializedName("next_billing_date")
    val nextBillingDate: String?,
    
    @SerializedName("auto_renew")
    val autoRenew: Boolean,
    
    @SerializedName("created_at")
    val createdAt: String,
    
    @SerializedName("updated_at")
    val updatedAt: String
)

data class SubscriptionPlanResponse(
    @SerializedName("id")
    val id: String,
    
    @SerializedName("name")
    val name: String,
    
    @SerializedName("description")
    val description: String,
    
    @SerializedName("tier")
    val tier: String,
    
    @SerializedName("price")
    val price: Double,
    
    @SerializedName("frequency")
    val frequency: String,
    
    @SerializedName("features")
    val features: List<String>,
    
    @SerializedName("product_count")
    val productCount: Int,
    
    @SerializedName("is_active")
    val isActive: Boolean,
    
    @SerializedName("image_url")
    val imageUrl: String?
)
