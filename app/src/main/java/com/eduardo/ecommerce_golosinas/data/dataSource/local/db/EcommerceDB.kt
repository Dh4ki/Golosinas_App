package com.eduardo.ecommerce_golosinas.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eduardo.ecommerce_golosinas.data.dataSource.local.dao.CategoriesDao
import com.eduardo.ecommerce_golosinas.data.dataSource.local.dao.ProductsDao
import com.eduardo.ecommerce_golosinas.data.dataSource.local.dao.ShoppingBagDao

import com.eduardo.ecommerce_golosinas.data.dataSource.local.entity.CategoryEntity
import com.eduardo.ecommerce_golosinas.data.dataSource.local.entity.ProductEntity
import com.eduardo.ecommerce_golosinas.data.dataSource.local.entity.ShoppingBagProductEntity


@Database(
    entities = [CategoryEntity::class, ProductEntity::class, ShoppingBagProductEntity::class],
    version = 1,
    exportSchema = false
)
abstract class EcommerceDB: RoomDatabase() {
    abstract fun categoriesDao(): CategoriesDao // DATA ACCESS OBJECT
    abstract fun productsDao(): ProductsDao
    abstract fun shoppingBagDao(): ShoppingBagDao
//    abstract fun addressDao(): AddressDao
}