package com.eduardo.ecommerce_golosinas.domain.useCase.categories

import com.eduardo.ecommerce_golosinas.domain.repository.CategoriesRepository

class GetCategoriesUseCase(private val repository: CategoriesRepository) {
    suspend operator fun invoke() = repository.getCategories()
}