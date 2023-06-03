package com.eduardo.ecommerce_golosinas.domain.repository

import com.eduardo.ecommerce_golosinas.domain.model.AuthResponse
import com.eduardo.ecommerce_golosinas.domain.model.User
import com.eduardo.ecommerce_golosinas.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<AuthResponse>
    suspend fun register(user: User): Resource<AuthResponse>
    suspend fun logout()
    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    fun getSessionData(): Flow<AuthResponse>
}