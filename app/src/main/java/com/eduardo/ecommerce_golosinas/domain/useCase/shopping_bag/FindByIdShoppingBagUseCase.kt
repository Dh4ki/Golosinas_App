package com.eduardo.ecommerce_golosinas.domain.useCase.shopping_bag

import com.eduardo.ecommerce_golosinas.domain.repository.ShoppingBagRepository

class FindByIdShoppingBagUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(id: String)= repository.findById(id)

}