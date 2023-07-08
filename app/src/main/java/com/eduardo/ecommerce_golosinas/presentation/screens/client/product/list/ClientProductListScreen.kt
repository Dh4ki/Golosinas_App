package com.eduardo.ecommerce_golosinas.presentation.screens.client.product.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.presentation.screens.client.product.list.components.ClientProductListContent
import com.eduardo.ecommerce_golosinas.presentation.screens.client.product.list.components.GetProducts

@Composable
fun ClientProductListScreen(navController: NavHostController){
    Scaffold() {paddingValues ->
        GetProducts(navController = navController, paddingValues = paddingValues )
    }

}