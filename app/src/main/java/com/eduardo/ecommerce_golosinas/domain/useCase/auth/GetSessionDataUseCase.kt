package com.eduardo.ecommerce_golosinas.domain.useCase.auth

import com.eduardo.ecommerce_golosinas.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.getSessionData()
}