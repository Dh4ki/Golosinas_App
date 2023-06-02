package com.eduardo.ecommerce_golosinas.presentation.screens.client.product.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.eduardo.ecommerce_golosinas.presentation.screens.client.category.list.components.ClientCategoryListContent
import com.eduardo.ecommerce_golosinas.presentation.screens.client.product.list.components.ClientProductListContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientProductListScreen(){
    Scaffold() {paddingValues ->
        ClientProductListContent(paddingValues = paddingValues)
    }

}