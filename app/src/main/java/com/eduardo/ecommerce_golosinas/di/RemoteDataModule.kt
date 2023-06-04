package com.eduardo.ecommerce_golosinas.di

import com.eduardo.ecommerce_golosinas.data.dataSource.remote.AuthRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.CategoriesRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.UsersRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.AuthRemoteDataSourceImpl
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.CategoriesRemoteDataSourceImpl
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.UsersRemoteDataSourceImpl
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.service.AuthService
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.service.CategoriesService
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.service.UsersService
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