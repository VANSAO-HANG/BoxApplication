package com.aeu.boxapplication.domain.repository

import com.aeu.boxapplication.core.network.NetworkResult
import com.aeu.boxapplication.domain.model.Notification
import kotlinx.coroutines.flow.Flow

interface NotificationRepository {
    suspend fun sendRenewalNotification(userId: String): NetworkResult<Unit>
    suspend fun sendShipmentNotification(userId: String, shipmentId: String): NetworkResult<Unit>
    suspend fun getNotificationHistory(page: Int): NetworkResult<List<Notification>>
    suspend fun markAsRead(notificationId: String): NetworkResult<Unit>
    fun getNotificationsFromLocal(): Flow<List<Notification>>
    suspend fun clearCache()
}
