package com.eduardo.ecommerce_golosinas.data.dataSource.local

import com.eduardo.ecommerce_golosinas.data.dataSource.local.datastore.AuthDatastore
import com.eduardo.ecommerce_golosinas.data.dataSource.local.AuthLocalDataSource
import com.eduardo.ecommerce_golosinas.domain.model.AuthResponse
import com.eduardo.ecommerce_golosinas.domain.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDatastore):
    AuthLocalDataSource {

    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.save(authResponse)
    override suspend fun updateSession(user: User) = authDatastore.update(user)
    override suspend fun logout() = authDatastore.delete()
    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()

}