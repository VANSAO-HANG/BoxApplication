package com.aeu.boxapplication.core.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    private const val DATE_FORMAT_DEFAULT = "yyyy-MM-dd"
    private const val DATE_FORMAT_DISPLAY = "MMM dd, yyyy"
    private const val DATE_FORMAT_FULL = "EEEE, MMMM dd, yyyy"
    private const val DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"
    private const val TIME_FORMAT = "HH:mm a"

    fun getCurrentDate(): Date = Date()

    fun getCurrentTimestamp(): Long = System.currentTimeMillis()

    fun formatDate(date: Date, pattern: String = DATE_FORMAT_DISPLAY): String {
        return SimpleDateFormat(pattern, Locale.getDefault()).format(date)
    }

    fun parseDate(dateString: String, pattern: String = DATE_FORMAT_DEFAULT): Date? {
        return try {
            SimpleDateFormat(pattern, Locale.getDefault()).parse(dateString)
        } catch (e: Exception) {
            null
        }
    }

    fun getNextRenewalDate(currentDate: Date, frequency: String): Date {
        val calendar = Calendar.getInstance()
        calendar.time = currentDate
        
        when (frequency) {
            Constants.FREQUENCY_WEEKLY -> calendar.add(Calendar.WEEK_OF_YEAR, 1)
            Constants.FREQUENCY_BIWEEKLY -> calendar.add(Calendar.WEEK_OF_YEAR, 2)
            Constants.FREQUENCY_MONTHLY -> calendar.add(Calendar.MONTH, 1)
            Constants.FREQUENCY_QUARTERLY -> calendar.add(Calendar.MONTH, 3)
        }
        
        return calendar.time
    }

    fun getDaysBetween(startDate: Date, endDate: Date): Long {
        val diff = endDate.time - startDate.time
        return diff / (24 * 60 * 60 * 1000)
    }

    fun isDateInPast(date: Date): Boolean {
        return date.before(getCurrentDate())
    }

    fun isDateInFuture(date: Date): Boolean {
        return date.after(getCurrentDate())
    }

    fun getStartOfDay(date: Date): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.time
    }

    fun getEndOfDay(date: Date): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        calendar.set(Calendar.MILLISECOND, 999)
        return calendar.time
    }
}
