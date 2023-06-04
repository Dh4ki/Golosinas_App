package com.eduardo.ecommerce_golosinas.data.mapper

import com.eduardo.ecommerce_golosinas.data.dataSource.local.entity.CategoryEntity
import com.eduardo.ecommerce_golosinas.domain.model.Category


fun CategoryEntity.toCategory(): Category {
    return Category(
        id = id,
        name = name,
        description = description,
        image = image
    )
}

fun Category.toCategoryEntity(): CategoryEntity {
    return CategoryEntity(
        id = id ?: "",
        name = name,
        description = description,
        image = image ?: ""
    )
}