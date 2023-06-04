package com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.update

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultTopBar
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.update.components.AdminCategoryUpdateContent
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.update.components.UpdateCategory

@Composable
fun AdminCategoryUpdateScreen(navController: NavHostController, categoryParam: String) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar Categoria",
                upAvailable = true,
                navController = navController
            )
        },
        backgroundColor = Color.LightGray
    ) { paddingValues ->
        AdminCategoryUpdateContent(paddingValues = paddingValues)
    }
    UpdateCategory()

}