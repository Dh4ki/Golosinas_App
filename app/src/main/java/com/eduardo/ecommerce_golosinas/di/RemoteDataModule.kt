package com.eduardo.ecommerce_golosinas.di

import com.eduardo.ecommerce_golosinas.data.repository.dataSource.AuthRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.eduardo.ecommerce_golosinas.data.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)
}