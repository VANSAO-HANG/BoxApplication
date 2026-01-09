package com.aeu.boxapplication.domain.repository

import com.aeu.boxapplication.core.network.NetworkResult
import com.aeu.boxapplication.domain.model.Subscription
import com.aeu.boxapplication.domain.model.SubscriptionPlan
import kotlinx.coroutines.flow.Flow

interface SubscriptionRepository {
    suspend fun getSubscriptionPlans(): NetworkResult<List<SubscriptionPlan>>
    suspend fun getSubscriptionPlan(planId: String): NetworkResult<SubscriptionPlan>
    suspend fun createSubscriptionPlan(plan: SubscriptionPlan): NetworkResult<SubscriptionPlan>
    suspend fun updateSubscriptionPlan(plan: SubscriptionPlan): NetworkResult<SubscriptionPlan>
    suspend fun getMySubscription(): NetworkResult<Subscription>
    suspend fun createSubscription(planId: String): NetworkResult<Subscription>
    suspend fun pauseSubscription(subscriptionId: String): NetworkResult<Subscription>
    suspend fun resumeSubscription(subscriptionId: String): NetworkResult<Subscription>
    suspend fun cancelSubscription(subscriptionId: String): NetworkResult<Subscription>
    suspend fun upgradeSubscription(subscriptionId: String, newPlanId: String): NetworkResult<Subscription>
    fun getSubscriptionsFromLocal(): Flow<List<Subscription>>
    suspend fun clearCache()
}
