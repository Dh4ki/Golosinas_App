package com.eduardo.ecommerce_golosinas.domain.useCase.auth

import com.eduardo.ecommerce_golosinas.domain.repository.AuthRepository

class LoginUseCase(private val  repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password )
}