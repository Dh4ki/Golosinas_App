package com.eduardo.ecommerce_golosinas.domain.useCase.products

import com.eduardo.ecommerce_golosinas.domain.model.Product
import com.eduardo.ecommerce_golosinas.domain.repository.ProductsRepository
import java.io.File

class UpdateProductWithImageUseCase(private val repository: ProductsRepository) {
    suspend operator fun invoke(id: String, product: Product, files: List<File>) = repository.updateWithImage(id, product, files)

}