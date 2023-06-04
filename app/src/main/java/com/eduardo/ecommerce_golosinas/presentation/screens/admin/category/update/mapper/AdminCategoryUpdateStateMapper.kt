package com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.update.mapper

import com.eduardo.ecommerce_golosinas.domain.model.Category
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.update.AdminCategoryUpdateState


fun AdminCategoryUpdateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}