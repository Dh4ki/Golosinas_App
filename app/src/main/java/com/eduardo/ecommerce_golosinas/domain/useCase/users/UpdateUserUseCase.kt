package com.eduardo.ecommerce_golosinas.domain.useCase.users

import com.eduardo.ecommerce_golosinas.domain.model.User
import com.eduardo.ecommerce_golosinas.domain.repository.UsersRepository

class UpdateUserUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User) = repository.update(id, user)

}