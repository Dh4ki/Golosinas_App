package com.eduardo.ecommerce_golosinas.data.repository

import com.eduardo.ecommerce_golosinas.data.dataSource.local.CategoriesLocalDataSource
import com.eduardo.ecommerce_golosinas.data.dataSource.local.entity.CategoryEntity
import com.eduardo.ecommerce_golosinas.data.dataSource.remote.CategoriesRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.mapper.toCategory
import com.eduardo.ecommerce_golosinas.data.mapper.toCategoryEntity
import com.eduardo.ecommerce_golosinas.domain.model.Category
import com.eduardo.ecommerce_golosinas.domain.repository.CategoriesRepository
import com.eduardo.ecommerce_golosinas.domain.util.Resource
import com.eduardo.ecommerce_golosinas.domain.util.ResponseToRequest
import com.eduardo.ecommerce_golosinas.domain.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import java.io.File

class CategoriesRepositoryImpl(
        private val remoteDataSource: CategoriesRemoteDataSource,
        private val localDataSource: CategoriesLocalDataSource
    ): CategoriesRepository {

    override suspend fun create(category: Category, file: File): Resource<Category> = ResponseToRequest.send(
        remoteDataSource.create(category, file)
    )

    override fun getCategories(): Flow<Resource<List<Category>>> = flow {
        localDataSource.getCategories().collect() {
            it.run {
                val categoriesLocalMap = this.map { categoryEntity -> categoryEntity.toCategory()  }
                try {
                    ResponseToRequest.send(remoteDataSource.getCategories()).run {
                        when(this) {
                            is Resource.Success -> {
                                val categoriesRemote = this.data
                                if (!isListEqual(categoriesRemote, categoriesLocalMap)) {
                                    localDataSource.insertAll(categoriesRemote.map { category -> category.toCategoryEntity() })
                                }
                                emit(Resource.Success(categoriesRemote))
                            }
                            is Resource.Failure -> {
                                emit(Resource.Success(categoriesLocalMap))
                            }
                            else -> {
                                emit(Resource.Success(categoriesLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(categoriesLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun update(id: String, category: Category): Resource<Category> {
        ResponseToRequest.send(remoteDataSource.update(id, category)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?: ""
                    )
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
        category: Category,
        file: File
    ): Resource<Category> {
        ResponseToRequest.send(remoteDataSource.updateWithImage(id, category, file)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?: ""
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
        TODO("Not yet implemented")
    }

}