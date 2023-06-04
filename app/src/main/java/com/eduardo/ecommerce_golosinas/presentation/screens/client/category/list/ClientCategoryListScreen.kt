package com.eduardo.ecommerce_golosinas.presentation.screens.client.category.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.presentation.screens.client.category.list.components.ClientCategoryListContent
import com.eduardo.ecommerce_golosinas.presentation.screens.client.category.list.components.GetCategories
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.info.components.ProfileContent

@Composable
fun ClientCategoryListScreen(navController: NavHostController){
    Scaffold() {paddingValues ->
        GetCategories(paddingValues, navController)
    }

}