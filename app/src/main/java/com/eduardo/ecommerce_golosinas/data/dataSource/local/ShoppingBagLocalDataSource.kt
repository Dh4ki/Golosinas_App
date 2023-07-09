package com.eduardo.ecommerce_golosinas.data.dataSource.local

import com.eduardo.ecommerce_golosinas.data.dataSource.local.entity.ProductEntity
import com.eduardo.ecommerce_golosinas.data.dataSource.local.entity.ShoppingBagProductEntity
import com.eduardo.ecommerce_golosinas.domain.model.ShoppingBagProduct
import kotlinx.coroutines.flow.Flow

interface ShoppingBagLocalDataSource {

    suspend fun insert(product: ShoppingBagProductEntity)
    suspend fun insertAll(products: List<ShoppingBagProductEntity>)
    fun findAll(): Flow<List<ShoppingBagProductEntity>>
    fun findById(id: String): ShoppingBagProductEntity
    suspend fun update(id: String, quantity: Int)
    suspend fun delete(id: String)

}