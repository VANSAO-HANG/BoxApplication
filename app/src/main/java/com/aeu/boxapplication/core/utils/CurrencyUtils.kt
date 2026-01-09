package com.aeu.boxapplication.core.utils

import java.text.NumberFormat
import java.util.*

object CurrencyUtils {
    private val usCurrency = NumberFormat.getCurrencyInstance(Locale.US)

    fun formatCurrency(amount: Double, currencyCode: String = "USD"): String {
        return try {
            val currency = Currency.getInstance(currencyCode)
            val format = NumberFormat.getCurrencyInstance()
            format.currency = currency
            format.format(amount)
        } catch (e: Exception) {
            usCurrency.format(amount)
        }
    }

    fun formatPrice(amount: Double): String {
        return usCurrency.format(amount)
    }

    fun parseCurrency(currencyString: String): Double? {
        return try {
            val cleanString = currencyString.replace(Regex("[^0-9.]"), "")
            cleanString.toDoubleOrNull()
        } catch (e: Exception) {
            null
        }
    }

    fun calculateDiscount(originalPrice: Double, discountPercent: Double): Double {
        return originalPrice * (discountPercent / 100.0)
    }

    fun applyDiscount(originalPrice: Double, discountPercent: Double): Double {
        val discount = calculateDiscount(originalPrice, discountPercent)
        return originalPrice - discount
    }

    fun calculateTax(amount: Double, taxRate: Double): Double {
        return amount * (taxRate / 100.0)
    }

    fun calculateTotal(subtotal: Double, taxRate: Double = 0.0, discount: Double = 0.0): Double {
        val afterDiscount = subtotal - discount
        val tax = calculateTax(afterDiscount, taxRate)
        return afterDiscount + tax
    }

    fun formatPercentage(value: Double): String {
        return String.format("%.2f%%", value)
    }
}
