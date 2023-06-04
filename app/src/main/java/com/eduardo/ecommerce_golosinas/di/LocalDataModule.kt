package com.eduardo.ecommerce_golosinas.di

import com.eduardo.ecommerce_golosinas.data.dataSource.local.datastore.AuthDatastore
import com.eduardo.ecommerce_golosinas.data.dataSource.local.AuthLocalDataSource
import com.eduardo.ecommerce_golosinas.data.dataSource.local.AuthLocalDataSourceImpl
import com.eduardo.ecommerce_golosinas.data.dataSource.local.CategoriesLocalDataSource
import com.eduardo.ecommerce_golosinas.data.dataSource.local.CategoriesLocalDataSourceImpl
import com.eduardo.ecommerce_golosinas.data.dataSource.local.dao.CategoriesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDatastore)

    @Provides
    fun provideCategoriesLocalDataSource(categoriesDao: CategoriesDao): CategoriesLocalDataSource = CategoriesLocalDataSourceImpl(categoriesDao)

//    @Provides
//    fun provideProductsLocalDataSource(productsDao: ProductsDao): ProductsLocalDataSource = ProductsLocalDataSourceImpl(productsDao)

//    @Provides
//    fun provideShoppingBagLocalDataSource(shoppingBagDao: ShoppingBagDao): ShoppingBagLocalDataSource = ShoppingBagLocalDataSourceImpl(shoppingBagDao)

//    @Provides
//    fun provideAddressLocalDataSource(addressDao: AddressDao): AddressLocalDataSource = AddressLocalDataSourceImpl(addressDao)
}