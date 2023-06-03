package com.eduardo.ecommerce_golosinas.presentation.screens.profile.update

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.domain.model.User
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultTopBar
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.info.components.ProfileContent
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.update.components.ProfileUpdateContent
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.update.components.UpdateUser

@Composable
fun ProfileUpdateScreen(navController: NavHostController, userParam: String){

    Log.d( "ProfileUpdateScreen", "Data: $userParam")

    Scaffold(
        topBar = {
            DefaultTopBar(title = "Actualizar Perfil",
                navController = navController,
                upAvailable = true
            )}
    ) {paddingValues ->
        ProfileUpdateContent(paddingValues = paddingValues)
    }
    UpdateUser()
}