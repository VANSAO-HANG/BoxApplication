package com.aeu.boxapplication.core.utils

object ValidationUtils {
    
    fun isValidEmail(email: String): Boolean {
        if (email.isBlank()) return false
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        // At least 8 characters, 1 uppercase, 1 lowercase, 1 number
        if (password.length < 8) return false
        
        val hasUppercase = password.any { it.isUpperCase() }
        val hasLowercase = password.any { it.isLowerCase() }
        val hasDigit = password.any { it.isDigit() }
        
        return hasUppercase && hasLowercase && hasDigit
    }

    fun isValidPhone(phone: String): Boolean {
        if (phone.isBlank()) return false
        val cleanPhone = phone.replace(Regex("[^0-9+]"), "")
        return cleanPhone.matches(Regex("^[+]?[0-9]{10,13}$"))
    }

    fun isValidZipCode(zipCode: String): Boolean {
        if (zipCode.isBlank()) return false
        return zipCode.matches(Regex("^[0-9]{5}(-[0-9]{4})?$"))
    }

    fun isValidCreditCard(cardNumber: String): Boolean {
        val cleanNumber = cardNumber.replace(Regex("[^0-9]"), "")
        if (cleanNumber.length !in 13..19) return false
        
        // Luhn algorithm
        var sum = 0
        var isEven = false
        
        for (i in cleanNumber.length - 1 downTo 0) {
            var digit = cleanNumber[i].toString().toInt()
            
            if (isEven) {
                digit *= 2
                if (digit > 9) digit -= 9
            }
            
            sum += digit
            isEven = !isEven
        }
        
        return sum % 10 == 0
    }

    fun isValidCVV(cvv: String): Boolean {
        return cvv.matches(Regex("^[0-9]{3,4}$"))
    }

    fun isValidCouponCode(code: String): Boolean {
        if (code.isBlank()) return false
        return code.matches(Regex("^[A-Z0-9]{4,20}$"))
    }

    fun isValidPrice(price: String): Boolean {
        if (price.isBlank()) return false
        return try {
            val value = price.toDouble()
            value >= 0
        } catch (e: NumberFormatException) {
            false
        }
    }

    fun isValidQuantity(quantity: String): Boolean {
        if (quantity.isBlank()) return false
        return try {
            val value = quantity.toInt()
            value > 0
        } catch (e: NumberFormatException) {
            false
        }
    }

    data class ValidationResult(
        val isValid: Boolean,
        val errorMessage: String? = null
    )

    fun validateRegistration(
        email: String,
        password: String,
        confirmPassword: String,
        name: String
    ): ValidationResult {
        return when {
            name.isBlank() -> ValidationResult(false, "Name is required")
            !isValidEmail(email) -> ValidationResult(false, "Invalid email address")
            !isValidPassword(password) -> ValidationResult(
                false,
                "Password must be at least 8 characters with uppercase, lowercase, and number"
            )
            password != confirmPassword -> ValidationResult(false, "Passwords do not match")
            else -> ValidationResult(true)
        }
    }

    fun validateLogin(email: String, password: String): ValidationResult {
        return when {
            !isValidEmail(email) -> ValidationResult(false, "Invalid email address")
            password.isBlank() -> ValidationResult(false, "Password is required")
            else -> ValidationResult(true)
        }
    }
}
