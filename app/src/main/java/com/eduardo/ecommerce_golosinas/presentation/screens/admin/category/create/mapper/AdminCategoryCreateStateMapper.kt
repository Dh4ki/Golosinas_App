package com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.create.mapper

import com.eduardo.ecommerce_golosinas.domain.model.Category
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.create.AdminCategoryCreateState

fun AdminCategoryCreateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}