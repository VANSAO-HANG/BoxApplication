package com.aeu.boxapplication.presentation.subscription

import com.aeu.boxapplication.domain.model.Subscription
import com.aeu.boxapplication.domain.model.SubscriptionPlan

data class SubscriptionState(
    val isLoading: Boolean = false,
    val plans: List<SubscriptionPlan> = emptyList(),
    val selectedPlan: SubscriptionPlan? = null,
    val currentSubscription: Subscription? = null,
    val error: String? = null,
    val successMessage: String? = null
)

sealed class SubscriptionEvent {
    object LoadPlans : SubscriptionEvent()
    object LoadMySubscription : SubscriptionEvent()
    data class SelectPlan(val plan: SubscriptionPlan) : SubscriptionEvent()
    data class Subscribe(val planId: String) : SubscriptionEvent()
    data class PauseSubscription(val subscriptionId: String) : SubscriptionEvent()
    data class CancelSubscription(val subscriptionId: String) : SubscriptionEvent()
    data class UpgradeSubscription(val subscriptionId: String, val newPlanId: String) : SubscriptionEvent()
    object ClearMessage : SubscriptionEvent()
}
