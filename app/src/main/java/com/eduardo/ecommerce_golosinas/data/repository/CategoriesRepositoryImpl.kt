package com.eduardo.ecommerce_golosinas.data.repository

import com.eduardo.ecommerce_golosinas.data.repository.dataSource.CategoriesRemoteDataSource
import com.eduardo.ecommerce_golosinas.domain.model.Category
import com.eduardo.ecommerce_golosinas.domain.repository.CategoriesRepository
import com.eduardo.ecommerce_golosinas.domain.util.Resource
import com.eduardo.ecommerce_golosinas.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import java.io.File

class CategoriesRepositoryImpl(private val categoriesRemoteDataSource: CategoriesRemoteDataSource): CategoriesRepository {

    override suspend fun create(category: Category, file: File): Resource<Category> = ResponseToRequest.send(
        categoriesRemoteDataSource.create(category, file)
    )

    override fun getCategories(): Flow<Resource<List<Category>>> {
        TODO("Not yet implemented")
    }

    override suspend fun update(id: String, category: Category): Resource<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Resource<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Resource<Unit> {
        TODO("Not yet implemented")
    }

}