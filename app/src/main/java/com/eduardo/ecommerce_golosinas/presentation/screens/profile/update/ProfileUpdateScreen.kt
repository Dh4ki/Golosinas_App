package com.eduardo.ecommerce_golosinas.presentation.screens.profile.update

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultTopBar
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.info.components.ProfileContent
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.update.components.ProfileUpdateContent

@Composable
fun ProfileUpdateScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            DefaultTopBar(title = "Actualizar Perfil",
                navController = navController,
                upAvailable = true
            )}
    ) {paddingValues ->
        ProfileUpdateContent(paddingValues = paddingValues)
    }

}