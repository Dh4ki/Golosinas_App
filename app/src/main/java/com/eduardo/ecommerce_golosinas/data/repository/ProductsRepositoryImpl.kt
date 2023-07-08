package com.eduardo.ecommerce_golosinas.data.repository

import com.eduardo.ecommerce_golosinas.data.dataSource.local.ProductsLocalDataSource
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.ProductsRemoteDataSource
import com.eduardo.ecommerce_golosinas.domain.model.Product
import com.eduardo.ecommerce_golosinas.domain.repository.ProductsRepository
import com.eduardo.ecommerce_golosinas.domain.util.Resource
import com.eduardo.ecommerce_golosinas.domain.util.ResponseToRequest
import com.eduardo.ecommerce_golosinas.domain.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import toProduct
import toProductEntity
import java.io.File

class ProductsRepositoryImpl(
    private val remoteDataSource: ProductsRemoteDataSource,
    private val localDataSource: ProductsLocalDataSource
): ProductsRepository {
    override fun findAll(): Flow<Resource<List<Product>>> {
        TODO("Not yet implemented")
    }

    override fun findByCategory(idCategory: String): Flow<Resource<List<Product>>> = flow{
        localDataSource.findByCategory(idCategory).collect(){
            it.run{
                val productsLocalMap = this.map { productEntity -> productEntity.toProduct() }
                try {
                    ResponseToRequest.send(remoteDataSource.findByCategory(idCategory)).run{
                        when(this){
                            is Resource.Success -> {
                                val productsRemote = this.data
                                if (!isListEqual(productsRemote, productsLocalMap)){
                                    localDataSource.insertAll(productsRemote.map {product -> product.toProductEntity()})
                                }
                                emit(Resource.Success(productsRemote))
                            }
                            else -> {
                                emit(Resource.Success(productsLocalMap))
                            }
                        }
                    }
                } catch (e: Exception){
                    emit(Resource.Success(productsLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun create(product: Product, files: List<File>): Resource<Product> {
        ResponseToRequest.send(remoteDataSource.create(product, files)).run{
            return when(this){
                is Resource.Success -> {
                    localDataSource.insert(this.data.toProductEntity())
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }

    override suspend fun updateWithImage(
        id: String,
        product: Product,
        files: List<File>?
    ): Resource<Product> {
        ResponseToRequest.send(remoteDataSource.updateWithImage(id, product, files)).run {
            return when(this){
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name ,
                        description = this.data.description,
                        image1 = this.data.image1 ?: "" ,
                        image2 = this.data.image2 ?: "" ,
                        price = this.data.price ,
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }

    override suspend fun update(id: String, product: Product): Resource<Product> {
        ResponseToRequest.send(remoteDataSource.update(id, product)).run {
            return when(this){
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name ,
                        description = this.data.description,
                        image1 = this.data.image1 ?: "" ,
                        image2 = this.data.image2 ?: "" ,
                        price = this.data.price ,
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }

    override suspend fun delete(id: String): Resource<Unit> {
        ResponseToRequest.send(remoteDataSource.delete(id)).run {
            return when(this){
                is Resource.Success -> {
                    localDataSource.delete(id)
                    Resource.Success(Unit)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }
}