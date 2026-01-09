package com.aeu.boxapplication

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager
// import dagger.hilt.android.HiltAndroidApp

// @HiltAndroidApp  // Temporarily disabled
class BoxApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Initialize application-level components
        initializeWorkManager()
    }

    private fun initializeWorkManager() {
        val config = Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.INFO)
            .build()
        WorkManager.initialize(this, config)
    }
}
