package com.eduardo.ecommerce_golosinas.domain.useCase.shopping_bag

data class ShoppingBagUseCase(
    val add: AddUseCase,
    val delete: DeleteUseCase,
    val findAll: FindAllShoppingBagUseCase,
    val findById: FindByIdShoppingBagUseCase
)
