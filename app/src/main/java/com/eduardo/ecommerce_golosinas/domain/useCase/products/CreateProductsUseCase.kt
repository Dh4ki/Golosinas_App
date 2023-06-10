package com.eduardo.ecommerce_golosinas.domain.useCase.products

import com.eduardo.ecommerce_golosinas.domain.model.Product
import com.eduardo.ecommerce_golosinas.domain.repository.ProductsRepository
import java.io.File

class CreateProductUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(product: Product, files: List<File>) = repository.create(product, files)

}