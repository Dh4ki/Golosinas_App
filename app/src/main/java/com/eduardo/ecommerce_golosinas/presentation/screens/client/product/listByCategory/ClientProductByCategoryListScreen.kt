package com.eduardo.ecommerce_golosinas.presentation.screens.client.product.listByCategory


import androidx.compose.material.Scaffold

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


import com.eduardo.ecommerce_golosinas.domain.model.Category
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultTopBar

import com.eduardo.ecommerce_golosinas.presentation.screens.client.product.listByCategory.components.GetProductsByCategory


@Composable
fun ClientProductByCategoryListScreen(navController: NavHostController, categoryParam: String) {
    val categoryParse = Category.fromJson(categoryParam).toJson()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Productos",
                navController = navController,
                upAvailable = true
            )
        },
    ) {paddingValues ->
        GetProductsByCategory(navController = navController, paddingValues = paddingValues)
    }
}