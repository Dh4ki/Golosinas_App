package com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.list.components.AdminCategoryListContent
import com.eduardo.ecommerce_golosinas.presentation.screens.client.category.list.components.ClientCategoryListContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminCategoryListScreen(){
    Scaffold() {paddingValues ->
        AdminCategoryListContent(paddingValues = paddingValues)
    }

}