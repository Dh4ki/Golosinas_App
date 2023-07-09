package com.eduardo.ecommerce_golosinas.data.repository

import com.eduardo.ecommerce_golosinas.data.dataSource.local.ShoppingBagLocalDataSource
import com.eduardo.ecommerce_golosinas.data.dataSource.local.ShoppingBagLocalDataSourceImpl
import com.eduardo.ecommerce_golosinas.data.mapper.toEntity
import com.eduardo.ecommerce_golosinas.data.mapper.toShoppingBagProduct
import com.eduardo.ecommerce_golosinas.domain.model.ShoppingBagProduct
import com.eduardo.ecommerce_golosinas.domain.repository.ShoppingBagRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ShoppingBagRepositoryImpl(private val localDataSource: ShoppingBagLocalDataSource): ShoppingBagRepository {
    override suspend fun add(product: ShoppingBagProduct) {
        CoroutineScope(Dispatchers.IO).launch {
            val shoppingBag = localDataSource.findById(product.id)
            if (shoppingBag == null){
                localDataSource.insert(product.toEntity())
            }
            else{
                localDataSource.update(product.id, product.quantity)
            }
        }
    }

    override suspend fun delete(id: String) {
        localDataSource.delete(id)
    }

    override fun findAll(): Flow<List<ShoppingBagProduct>> = flow {
        localDataSource.findAll().collect(){
            emit(it.map { entity -> entity.toShoppingBagProduct() })
        }
    }

    override suspend fun findById(id: String): ShoppingBagProduct? {
        TODO("Not yet implemented")
    }
}