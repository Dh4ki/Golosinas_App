package com.eduardo.ecommerce_golosinas.data.dataSource.local

import  com.eduardo.ecommerce_golosinas.data.dataSource.local.entity.ProductEntity
import  com.eduardo.ecommerce_golosinas.data.dataSource.local.dao.ProductsDao
import kotlinx.coroutines.flow.Flow

class ProductsLocalDataSourceImpl(private val productsDao: ProductsDao): ProductsLocalDataSource {

    override suspend fun insert(product: ProductEntity) = productsDao.insert(product)

    override suspend fun insertAll(products: List<ProductEntity>) = productsDao.insertAll(products)

    override fun findAll(): Flow<List<ProductEntity>> = productsDao.findAll()

    override fun findByCategory(idCategory: String): Flow<List<ProductEntity>> = productsDao.findByCategory(idCategory)

    override suspend fun update(
        id: String,
        name: String,
        description: String,
        image1: String,
        image2: String,
        price: Double
    ) = productsDao.update(id, name, description, image1, image2, price)

    override suspend fun delete(id: String) = productsDao.delete(id)
}