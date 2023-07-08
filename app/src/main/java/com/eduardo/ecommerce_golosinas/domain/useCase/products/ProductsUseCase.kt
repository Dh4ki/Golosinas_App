package com.eduardo.ecommerce_golosinas.domain.useCase.products

data class ProductsUseCase(
    val createProduct: CreateProductUseCase,
    val findByCategory: FindByCategoryUseCase,
//    val findAll: FindAllUseCase,
    val updateProduct: UpdateProductUseCase,
    val updateProductWithImage: UpdateProductWithImageUseCase,
    val deleteProduct: DeleteProductUseCase,
//    val findByName: FindByNameUseCase
)
