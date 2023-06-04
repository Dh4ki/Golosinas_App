package com.eduardo.ecommerce_golosinas.presentation.screens.client.product.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.eduardo.ecommerce_golosinas.presentation.screens.client.product.list.components.ClientProductListContent

@Composable
fun ClientProductListScreen(){
    Scaffold() {paddingValues ->
        ClientProductListContent(paddingValues = paddingValues)
    }

}