package com.eduardo.ecommerce_golosinas.domain.useCase.categories

import com.eduardo.ecommerce_golosinas.domain.repository.CategoriesRepository
import java.io.File

class DeleteCategoryUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke(id: String) = repository.delete(id)
}