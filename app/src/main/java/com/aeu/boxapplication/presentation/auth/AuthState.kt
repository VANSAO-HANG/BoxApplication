package com.aeu.boxapplication.presentation.auth

import com.aeu.boxapplication.domain.model.User

data class AuthState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String? = null,
    val isAuthenticated: Boolean = false
)

sealed class AuthEvent {
    data class Login(val email: String, val password: String) : AuthEvent()
    data class Register(val email: String, val password: String, val name: String) : AuthEvent()
    object Logout : AuthEvent()
    object ClearError : AuthEvent()
}
