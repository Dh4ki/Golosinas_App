package com.eduardo.ecommerce_golosinas.data.dataSource.remote

import com.eduardo.ecommerce_golosinas.data.dataSource.remote.AuthRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.service.AuthService
import com.eduardo.ecommerce_golosinas.domain.model.AuthResponse
import com.eduardo.ecommerce_golosinas.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val  authService: AuthService): AuthRemoteDataSource {

    override suspend fun login(email: String, password: String) = authService.login(email, password)
    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)
}