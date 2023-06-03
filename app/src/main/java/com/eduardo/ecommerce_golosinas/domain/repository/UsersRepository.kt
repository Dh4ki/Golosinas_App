package com.eduardo.ecommerce_golosinas.domain.repository

import com.eduardo.ecommerce_golosinas.domain.model.User
import com.eduardo.ecommerce_golosinas.domain.util.Resource
import java.io.File

interface UsersRepository {
    suspend fun update(id: String, user: User): Resource<User>
    suspend fun updateWithImage(id: String, user: User, file: File): Resource<User>
}