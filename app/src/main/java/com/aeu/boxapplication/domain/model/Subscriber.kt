package com.aeu.boxapplication.domain.model

import java.util.Date

data class Subscriber(
    val user: User,
    val currentSubscription: Subscription?,
    val totalSpent: Double,
    val subscriptionStartDate: Date?,
    val preferences: Preference?
)
