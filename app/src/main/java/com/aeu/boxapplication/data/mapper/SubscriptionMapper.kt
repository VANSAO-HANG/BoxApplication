package com.aeu.boxapplication.data.mapper

import com.aeu.boxapplication.data.remote.dto.response.SubscriptionPlanResponse
import com.aeu.boxapplication.data.remote.dto.response.SubscriptionResponse
import com.aeu.boxapplication.domain.model.Subscription
import com.aeu.boxapplication.domain.model.SubscriptionPlan
import com.aeu.boxapplication.domain.model.SubscriptionTier
import java.text.SimpleDateFormat
import java.util.*

object SubscriptionMapper {

    fun toDomain(response: SubscriptionResponse): Subscription {
        return Subscription(
            id = response.id,
            userId = response.userId,
            planId = response.planId,
            plan = response.plan?.let { planToDomain(it) },
            status = response.status,
            startDate = parseDate(response.startDate),
            endDate = response.endDate?.let { parseDate(it) },
            nextBillingDate = response.nextBillingDate?.let { parseDate(it) },
            autoRenew = response.autoRenew,
            createdAt = parseDate(response.createdAt),
            updatedAt = parseDate(response.updatedAt)
        )
    }

    fun planToDomain(response: SubscriptionPlanResponse): SubscriptionPlan {
        return SubscriptionPlan(
            id = response.id,
            name = response.name,
            description = response.description,
            tier = SubscriptionTier.valueOf(response.tier.uppercase()),
            price = response.price,
            frequency = response.frequency,
            features = response.features,
            productCount = response.productCount,
            isActive = response.isActive,
            imageUrl = response.imageUrl
        )
    }

    private fun parseDate(dateString: String): Date {
        return try {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(dateString) ?: Date()
        } catch (e: Exception) {
            Date()
        }
    }
}
