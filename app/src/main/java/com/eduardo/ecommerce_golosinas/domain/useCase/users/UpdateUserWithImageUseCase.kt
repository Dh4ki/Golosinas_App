package com.eduardo.ecommerce_golosinas.domain.useCase.users

import com.eduardo.ecommerce_golosinas.domain.model.User
import com.eduardo.ecommerce_golosinas.domain.repository.UsersRepository
import java.io.File

class UpdateUserWithImageUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User, file: File) = repository.updateWithImage(id, user, file)

}