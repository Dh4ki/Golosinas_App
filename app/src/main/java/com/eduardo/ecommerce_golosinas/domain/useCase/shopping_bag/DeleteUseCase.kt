package com.eduardo.ecommerce_golosinas.domain.useCase.shopping_bag

import com.eduardo.ecommerce_golosinas.domain.model.ShoppingBagProduct
import com.eduardo.ecommerce_golosinas.domain.repository.ShoppingBagRepository

class DeleteUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke(id: String){
        repository.delete(id)
    }

}