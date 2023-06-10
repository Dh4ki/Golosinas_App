package com.eduardo.ecommerce_golosinas.di

import com.eduardo.ecommerce_golosinas.data.repository.AuthRepositoryImpl
import com.eduardo.ecommerce_golosinas.data.repository.UsersRepositoryImpl
import com.eduardo.ecommerce_golosinas.data.dataSource.local.AuthLocalDataSource
import com.eduardo.ecommerce_golosinas.data.dataSource.local.CategoriesLocalDataSource
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.AuthRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.CategoriesRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.ProductsRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.UsersRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.repository.CategoriesRepositoryImpl
import com.eduardo.ecommerce_golosinas.data.repository.ProductsRepositoryImpl
import com.eduardo.ecommerce_golosinas.domain.repository.AuthRepository
import com.eduardo.ecommerce_golosinas.domain.repository.CategoriesRepository
import com.eduardo.ecommerce_golosinas.domain.repository.ProductsRepository
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
        categoriesLocalDataSource: CategoriesLocalDataSource
    ): CategoriesRepository = CategoriesRepositoryImpl(categoriesRemoteDataSource, categoriesLocalDataSource)

    @Provides
    fun provideProductsRepository(
        productsRemoteDataSource: ProductsRemoteDataSource,
    ): ProductsRepository = ProductsRepositoryImpl(productsRemoteDataSource)

}