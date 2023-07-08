package com.eduardo.ecommerce_golosinas.data.repository

import com.eduardo.ecommerce_golosinas.data.dataSource.remote.ProductsRemoteDataSource
import com.eduardo.ecommerce_golosinas.domain.model.Product
import com.eduardo.ecommerce_golosinas.domain.repository.ProductsRepository
import com.eduardo.ecommerce_golosinas.domain.util.Resource
import com.eduardo.ecommerce_golosinas.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.File

class ProductsRepositoryImpl(private val remoteDataSource: ProductsRemoteDataSource): ProductsRepository {
    override fun findAll(): Flow<Resource<List<Product>>> {
        TODO("Not yet implemented")
    }

    override fun findByCategory(idCategory: String): Flow<Resource<List<Product>>> = flow{
       emit(ResponseToRequest.send(remoteDataSource.findByCategory(idCategory)))
    }

    override suspend fun create(product: Product, files: List<File>): Resource<Product> =ResponseToRequest.send(
        remoteDataSource.create(product, files)
    )

    override suspend fun updateWithImage(
        id: String,
        product: Product,
        files: List<File>?
    ): Resource<Product> = ResponseToRequest.send(
        remoteDataSource.updateWithImage(id, product, files)
    )

    override suspend fun update(id: String, product: Product): Resource<Product> = ResponseToRequest.send(
        remoteDataSource.update(id, product)
    )

    override suspend fun delete(id: String): Resource<Unit> = ResponseToRequest.send(
        remoteDataSource.delete(id)
    )
}