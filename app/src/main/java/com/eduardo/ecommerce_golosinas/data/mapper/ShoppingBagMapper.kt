package com.eduardo.ecommerce_golosinas.data.mapper

import com.eduardo.ecommerce_golosinas.data.dataSource.local.entity.ShoppingBagProductEntity
import com.eduardo.ecommerce_golosinas.domain.model.ShoppingBagProduct

fun ShoppingBagProduct.toEntity(): ShoppingBagProductEntity{
    return ShoppingBagProductEntity(
        id= id,
        name = name,
        idCategory = idCategory,
        image1 = image1,
        price = price,
        quantity = quantity
    )
}

fun ShoppingBagProductEntity.toShoppingBagProduct(): ShoppingBagProduct{
    return ShoppingBagProduct(
        id= id,
        name = name,
        idCategory = idCategory,
        image1 = image1,
        price = price,
        quantity = quantity
    )
}