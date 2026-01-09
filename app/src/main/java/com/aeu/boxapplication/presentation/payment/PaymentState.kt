package com.aeu.boxapplication.presentation.payment

import com.aeu.boxapplication.domain.model.Payment

data class PaymentState(
    val isLoading: Boolean = false,
    val paymentHistory: List<Payment> = emptyList(),
    val currentPayment: Payment? = null,
    val error: String? = null,
    val successMessage: String? = null
)

sealed class PaymentEvent {
    data class ProcessPayment(val subscriptionId: String, val paymentMethodId: String) : PaymentEvent()
    data class LoadPaymentHistory(val page: Int = 1) : PaymentEvent()
    data class SetupRecurringPayment(val subscriptionId: String, val paymentMethodId: String) : PaymentEvent()
    object ClearMessage : PaymentEvent()
}
