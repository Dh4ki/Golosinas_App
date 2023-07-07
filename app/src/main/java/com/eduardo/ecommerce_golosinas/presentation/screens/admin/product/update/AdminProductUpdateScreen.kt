package com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.update

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultTopBar
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.create.components.AdminProductCreateContent
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.create.components.CreateProduct
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.update.components.AdminProductUpdateContent
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.update.components.UpdateProduct
import com.eduardo.ecommerce_golosinas.presentation.ui.theme.Gray200

@Composable
fun AdminProductUpdateScreen(navController: NavHostController, productParam: String){
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar Producto",
                upAvailable = true,
                navController = navController
            )
        },
        backgroundColor = Gray200
    ) {paddingValues ->
        AdminProductUpdateContent(paddingValues = paddingValues)
    }
    UpdateProduct()
}