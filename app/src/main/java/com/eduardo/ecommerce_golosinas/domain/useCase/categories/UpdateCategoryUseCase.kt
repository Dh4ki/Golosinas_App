package com.eduardo.ecommerce_golosinas.domain.useCase.categories


import com.eduardo.ecommerce_golosinas.domain.model.Category
import com.eduardo.ecommerce_golosinas.domain.repository.CategoriesRepository
import java.io.File

class UpdateCategoryUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke(id: String, category: Category) = repository.update(id, category)
}