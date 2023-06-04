package com.eduardo.ecommerce_golosinas.di

import android.app.Application
import androidx.room.Room
import com.eduardo.ecommerce_golosinas.data.dataSource.local.dao.CategoriesDao
import com.eduardo.ecommerce_golosinas.data.dataSource.local.db.EcommerceDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): EcommerceDB =
        Room.databaseBuilder(app, EcommerceDB::class.java, "ecommerce_db").fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideCategoriesDao(db: EcommerceDB): CategoriesDao = db.categoriesDao()

//    @Provides
//    @Singleton
//    fun provideProductsDao(db: EcommerceDB): ProductsDao = db.productsDao()

//    @Provides
//    @Singleton
//    fun provideShoppingBagDao(db: EcommerceDB): ShoppingBagDao = db.shoppingBagDao()

//    @Provides
//    @Singleton
//    fun provideAddressDao(db: EcommerceDB): AddressDao = db.addressDao()

}