package com.eduardo.ecommerce_golosinas.domain.useCase.shopping_bag

import com.eduardo.ecommerce_golosinas.domain.repository.ShoppingBagRepository

class FindAllShoppingBagUseCase(private val repository: ShoppingBagRepository) {
    operator fun invoke()= repository.findAll()

}