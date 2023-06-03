package com.eduardo.ecommerce_golosinas.data.repository

import com.eduardo.ecommerce_golosinas.data.repository.dataSource.AuthLocalDataSource
import com.eduardo.ecommerce_golosinas.data.repository.dataSource.AuthRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.repository.dataSource.UsersRemoteDataSource
import com.eduardo.ecommerce_golosinas.domain.model.AuthResponse
import com.eduardo.ecommerce_golosinas.domain.model.ErrorResponse
import com.eduardo.ecommerce_golosinas.domain.model.User
import com.eduardo.ecommerce_golosinas.domain.repository.AuthRepository
import com.eduardo.ecommerce_golosinas.domain.repository.UsersRepository
import com.eduardo.ecommerce_golosinas.domain.util.ConvertErrorBody
import com.eduardo.ecommerce_golosinas.domain.util.Resource
import com.eduardo.ecommerce_golosinas.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.File
import java.io.IOException
import java.lang.Exception

class UsersRepositoryImpl(
    private val usersRemoteDataSource: UsersRemoteDataSource,
): UsersRepository {

    override suspend fun update(id:String, user: User): Resource<User> = ResponseToRequest.send(
        usersRemoteDataSource.update(id, user)
    )

    override suspend fun updateWithImage(id: String, user: User, file: File): Resource<User> = ResponseToRequest.send(
        usersRemoteDataSource.updateWithImage(id, user, file)
    )


}