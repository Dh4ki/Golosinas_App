package com.eduardo.ecommerce_golosinas.presentation.screens.roles

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultTopBar
import com.eduardo.ecommerce_golosinas.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController){
    Scaffold(
        topBar = { DefaultTopBar(title = "Selecciona un rol") }
    ) {paddingValues ->
        RolesContent(paddingValues, navController)
    }
}