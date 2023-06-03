package com.eduardo.ecommerce_golosinas.domain.useCase.auth

import com.eduardo.ecommerce_golosinas.domain.model.AuthResponse
import com.eduardo.ecommerce_golosinas.domain.model.User
import com.eduardo.ecommerce_golosinas.domain.repository.AuthRepository

class UpdateSessionUseCase constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.updateSession(user)
}