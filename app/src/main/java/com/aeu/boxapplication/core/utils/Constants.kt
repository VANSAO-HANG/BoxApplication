package com.aeu.boxapplication.core.utils

object Constants {
    // API
    const val BASE_URL = "https://your-cloud-function-url.com/"
    const val API_TIMEOUT = 30L // seconds
    
    // Stripe
    const val STRIPE_PUBLISHABLE_KEY = "your_stripe_publishable_key"
    
    // Database
    const val DATABASE_NAME = "box_subscription_db"
    const val DATABASE_VERSION = 1
    
    // Preferences
    const val PREF_NAME = "box_subscription_prefs"
    const val PREF_USER_TOKEN = "user_token"
    const val PREF_USER_ID = "user_id"
    const val PREF_USER_ROLE = "user_role"
    const val PREF_IS_LOGGED_IN = "is_logged_in"
    
    // User Roles
    const val ROLE_ADMIN = "admin"
    const val ROLE_SUBSCRIBER = "subscriber"
    
    // Subscription Status
    const val STATUS_ACTIVE = "active"
    const val STATUS_PAUSED = "paused"
    const val STATUS_CANCELLED = "cancelled"
    const val STATUS_EXPIRED = "expired"
    
    // Payment Status
    const val PAYMENT_PENDING = "pending"
    const val PAYMENT_SUCCESS = "success"
    const val PAYMENT_FAILED = "failed"
    const val PAYMENT_REFUNDED = "refunded"
    
    // Shipment Status
    const val SHIPMENT_PENDING = "pending"
    const val SHIPMENT_PROCESSING = "processing"
    const val SHIPMENT_SHIPPED = "shipped"
    const val SHIPMENT_DELIVERED = "delivered"
    
    // Subscription Frequency
    const val FREQUENCY_WEEKLY = "weekly"
    const val FREQUENCY_BIWEEKLY = "biweekly"
    const val FREQUENCY_MONTHLY = "monthly"
    const val FREQUENCY_QUARTERLY = "quarterly"
    
    // WorkManager Tags
    const val WORK_RENEWAL_NOTIFICATION = "renewal_notification"
    const val WORK_SHIPMENT_NOTIFICATION = "shipment_notification"
    const val WORK_SUBSCRIPTION_RENEWAL = "subscription_renewal"
    const val WORK_INVENTORY_SYNC = "inventory_sync"
    
    // Notification Channels
    const val CHANNEL_RENEWAL = "renewal_channel"
    const val CHANNEL_SHIPMENT = "shipment_channel"
    const val CHANNEL_PAYMENT = "payment_channel"
    const val CHANNEL_GENERAL = "general_channel"
}
