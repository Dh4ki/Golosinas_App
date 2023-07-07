package com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.update.mapper

import com.eduardo.ecommerce_golosinas.domain.model.Product
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.create.AdminProductCreateState
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.update.AdminProductUpdateState

fun AdminProductUpdateState.toProduct(): Product {
    return Product(
        id = id,
        name = name,
        description = description,
        idCategory = idCategory,
        price = price,
        imagesToUpdate = imagesToUpdate.toList(),
        image1 = image1,
        image2 = image2
    )
}