package com.eduardo.ecommerce_golosinas.data.repository.dataSource

import com.eduardo.ecommerce_golosinas.domain.model.AuthResponse
import com.eduardo.ecommerce_golosinas.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {
    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>
}