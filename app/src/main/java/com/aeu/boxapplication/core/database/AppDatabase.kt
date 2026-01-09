package com.aeu.boxapplication.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aeu.boxapplication.core.database.converter.TypeConverters as AppTypeConverters
import com.aeu.boxapplication.core.database.dao.*
import com.aeu.boxapplication.data.local.entity.*

@Database(
    entities = [
        UserEntity::class,
        SubscriptionEntity::class,
        OrderEntity::class,
        ProductEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(AppTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun subscriptionDao(): SubscriptionDao
    abstract fun orderDao(): OrderDao
    abstract fun productDao(): ProductDao
}
