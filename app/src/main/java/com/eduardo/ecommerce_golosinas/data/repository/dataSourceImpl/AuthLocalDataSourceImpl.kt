package com.eduardo.ecommerce_golosinas.data.repository.dataSourceImpl

import com.eduardo.ecommerce_golosinas.data.data.store.AuthDataStore
import com.eduardo.ecommerce_golosinas.data.repository.dataSource.AuthLocalDataSource
import com.eduardo.ecommerce_golosinas.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDataStore): AuthLocalDataSource {

    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.save(authResponse)
    override suspend fun logout() = authDatastore.delete()

    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()

}