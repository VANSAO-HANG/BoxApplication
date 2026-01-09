package com.aeu.boxapplication.domain.model

data class CustomerProfile(
    val userId: String,
    val fullName: String,
    val email: String,
    val phone: String?,
    val billingAddress: Address?,
    val shippingAddress: Address?,
    val preferences: Preference?,
    val paymentMethods: List<PaymentMethod>
)

data class PaymentMethod(
    val id: String,
    val type: String,
    val last4: String,
    val expiryMonth: Int?,
    val expiryYear: Int?,
    val isDefault: Boolean
)
