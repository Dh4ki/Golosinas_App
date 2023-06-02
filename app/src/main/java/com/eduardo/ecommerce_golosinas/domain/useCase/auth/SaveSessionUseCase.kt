package com.eduardo.ecommerce_golosinas.domain.useCase.auth

import com.eduardo.ecommerce_golosinas.domain.model.AuthResponse
import com.eduardo.ecommerce_golosinas.domain.repository.AuthRepository

class SaveSessionUseCase constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
}