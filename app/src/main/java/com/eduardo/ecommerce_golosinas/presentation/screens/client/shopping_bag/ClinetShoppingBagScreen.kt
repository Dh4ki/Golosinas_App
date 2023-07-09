package com.eduardo.ecommerce_golosinas.presentation.screens.client.shopping_bag

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.presentation.screens.client.shopping_bag.components.ClientShoppingBagContent

@Composable
fun ClientShoppingBagScreen(navController: NavHostController){
    Scaffold() {paddingValues ->
        ClientShoppingBagContent(paddingValues)
    }
}