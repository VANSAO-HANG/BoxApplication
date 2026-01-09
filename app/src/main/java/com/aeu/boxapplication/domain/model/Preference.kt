package com.aeu.boxapplication.domain.model

data class Preference(
    val userId: String,
    val productCategories: List<String>,
    val dietaryRestrictions: List<String>?,
    val allergies: List<String>?,
    val preferredDeliveryDay: String?,
    val notificationPreferences: NotificationPreferences,
    val customNotes: String?
)

data class NotificationPreferences(
    val emailRenewal: Boolean = true,
    val emailShipment: Boolean = true,
    val emailPromotions: Boolean = false,
    val pushRenewal: Boolean = true,
    val pushShipment: Boolean = true,
    val pushPromotions: Boolean = false
)
