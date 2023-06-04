package com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.list.components.AdminProductListContent
import com.eduardo.ecommerce_golosinas.presentation.screens.client.product.list.components.ClientProductListContent

@Composable
fun AdminProductListScreen(){
    Scaffold() {paddingValues ->
        AdminProductListContent(paddingValues = paddingValues)
    }

}