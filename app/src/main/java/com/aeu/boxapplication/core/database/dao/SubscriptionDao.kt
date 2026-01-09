package com.aeu.boxapplication.core.database.dao

import androidx.room.*
import com.aeu.boxapplication.data.local.entity.SubscriptionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SubscriptionDao {

    @Query("SELECT * FROM subscriptions WHERE id = :subscriptionId")
    suspend fun getSubscriptionById(subscriptionId: String): SubscriptionEntity?

    @Query("SELECT * FROM subscriptions WHERE userId = :userId")
    fun getSubscriptionsByUser(userId: String): Flow<List<SubscriptionEntity>>

    @Query("SELECT * FROM subscriptions WHERE status = :status")
    fun getSubscriptionsByStatus(status: String): Flow<List<SubscriptionEntity>>

    @Query("SELECT * FROM subscriptions")
    fun getAllSubscriptions(): Flow<List<SubscriptionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubscription(subscription: SubscriptionEntity): Long

    @Update
    suspend fun updateSubscription(subscription: SubscriptionEntity)

    @Delete
    suspend fun deleteSubscription(subscription: SubscriptionEntity)

    @Query("DELETE FROM subscriptions WHERE userId = :userId")
    suspend fun deleteSubscriptionsByUser(userId: String)

    @Query("DELETE FROM subscriptions")
    suspend fun clearAll()
}
