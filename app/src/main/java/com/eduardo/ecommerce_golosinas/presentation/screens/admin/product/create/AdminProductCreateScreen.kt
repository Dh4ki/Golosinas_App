package com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.create

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultTopBar
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.create.components.AdminProductCreateContent
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.create.components.CreateProduct
import com.eduardo.ecommerce_golosinas.presentation.ui.theme.Gray200

@Composable
fun AdminProductCreateScreen(navController: NavHostController, categoryParam: String){
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nuevo Producto",
                upAvailable = true,
                navController = navController
            )
        },
        backgroundColor = Gray200
    ) {paddingValues ->
        AdminProductCreateContent(paddingValues = paddingValues)
    }
    CreateProduct()
}