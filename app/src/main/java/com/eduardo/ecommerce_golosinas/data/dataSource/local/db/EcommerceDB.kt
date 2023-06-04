package com.eduardo.ecommerce_golosinas.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eduardo.ecommerce_golosinas.data.dataSource.local.dao.CategoriesDao
import com.eduardo.ecommerce_golosinas.data.dataSource.local.entity.CategoryEntity

@Database(
    entities = [CategoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class EcommerceDB: RoomDatabase() {
    abstract fun categoriesDao(): CategoriesDao // DATA ACCESS OBJECT
//    abstract fun productsDao(): ProductsDao
//    abstract fun shoppingBagDao(): ShoppingBagDao
//    abstract fun addressDao(): AddressDao
}