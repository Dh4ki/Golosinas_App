package com.eduardo.ecommerce_golosinas.domain.useCase.products

import com.eduardo.ecommerce_golosinas.domain.model.Product
import com.eduardo.ecommerce_golosinas.domain.repository.ProductsRepository
import java.io.File

class FindAllUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke() = repository.findAll()

}