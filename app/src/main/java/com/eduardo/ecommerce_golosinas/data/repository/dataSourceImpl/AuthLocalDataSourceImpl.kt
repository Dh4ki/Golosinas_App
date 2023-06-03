package com.eduardo.ecommerce_golosinas.data.repository.dataSourceImpl

import com.eduardo.ecommerce_golosinas.data.datastore.AuthDatastore
import com.eduardo.ecommerce_golosinas.data.repository.dataSource.AuthLocalDataSource
import com.eduardo.ecommerce_golosinas.domain.model.AuthResponse
import com.eduardo.ecommerce_golosinas.domain.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDatastore): AuthLocalDataSource {

    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.save(authResponse)
    override suspend fun updateSession(user: User) = authDatastore.update(user)
    override suspend fun logout() = authDatastore.delete()
    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()

}