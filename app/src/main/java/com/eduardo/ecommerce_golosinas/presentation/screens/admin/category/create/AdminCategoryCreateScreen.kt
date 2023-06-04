package com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.create

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultTopBar
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.create.components.AdminCategoryCreateContent
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.create.components.CreateCategory
import com.eduardo.ecommerce_golosinas.presentation.ui.theme.Gray200

@Composable
fun AdminCategoryCreateScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nueva Categoría",
                upAvailable = true,
                navController = navController
            )
        },
        backgroundColor = Gray200
    ) { paddingValues ->
        AdminCategoryCreateContent(paddingValues = paddingValues)
    }
    CreateCategory()
}