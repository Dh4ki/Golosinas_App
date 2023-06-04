package com.eduardo.ecommerce_golosinas.di

import com.eduardo.ecommerce_golosinas.data.repository.dataSource.AuthRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.repository.dataSource.CategoriesRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.repository.dataSource.UsersRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.eduardo.ecommerce_golosinas.data.repository.dataSourceImpl.CategoriesRemoteDataSourceImpl
import com.eduardo.ecommerce_golosinas.data.repository.dataSourceImpl.UsersRemoteDataSourceImpl
import com.eduardo.ecommerce_golosinas.data.service.AuthService
import com.eduardo.ecommerce_golosinas.data.service.CategoriesService
import com.eduardo.ecommerce_golosinas.data.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)

    @Provides
    fun provideUsersRemoteDataSource(usersService: UsersService): UsersRemoteDataSource = UsersRemoteDataSourceImpl(usersService)

    @Provides
    fun provideCategoriesRemoteDataSource(categoriesService: CategoriesService): CategoriesRemoteDataSource = CategoriesRemoteDataSourceImpl(categoriesService)
}