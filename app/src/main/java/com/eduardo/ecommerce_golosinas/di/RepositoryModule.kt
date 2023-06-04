package com.eduardo.ecommerce_golosinas.di

import com.eduardo.ecommerce_golosinas.data.repository.AuthRepositoryImpl
import com.eduardo.ecommerce_golosinas.data.repository.UsersRepositoryImpl
import com.eduardo.ecommerce_golosinas.data.repository.dataSource.AuthLocalDataSource
import com.eduardo.ecommerce_golosinas.data.repository.dataSource.AuthRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.repository.dataSource.CategoriesRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.repository.dataSource.UsersRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.repository.CategoriesRepositoryImpl
import com.eduardo.ecommerce_golosinas.domain.repository.AuthRepository
import com.eduardo.ecommerce_golosinas.domain.repository.CategoriesRepository
import com.eduardo.ecommerce_golosinas.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

    @Provides
    fun provideUsersRepository(
        usersRemoteDataSource: UsersRemoteDataSource,
    ): UsersRepository = UsersRepositoryImpl(usersRemoteDataSource)

    @Provides
    fun provideCategoriesRepository(
        categoriesRemoteDataSource: CategoriesRemoteDataSource,
    ): CategoriesRepository = CategoriesRepositoryImpl(categoriesRemoteDataSource)
}