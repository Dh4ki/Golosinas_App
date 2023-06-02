package com.eduardo.ecommerce_golosinas.domain.useCase.auth

import com.eduardo.ecommerce_golosinas.domain.model.User
import com.eduardo.ecommerce_golosinas.domain.repository.AuthRepository

data class RegisterUseCase(private val repository: AuthRepository){
    suspend operator fun invoke(user: User) =repository.register(user);
}
