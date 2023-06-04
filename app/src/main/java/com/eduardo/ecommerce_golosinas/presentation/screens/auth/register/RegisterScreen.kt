
package com.eduardo.ecommerce_golosinas.presentation.screens.auth.register

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultTopBar
import com.eduardo.ecommerce_golosinas.presentation.screens.auth.register.components.Register
import com.eduardo.ecommerce_golosinas.presentation.screens.auth.register.components.RegisterContent
import com.eduardo.ecommerce_golosinas.presentation.ui.theme.Orange500

@Composable
fun RegisterScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            DefaultTopBar(
                title =  "Registro",
                upAvailable = true,
                navController = navController
            )
        },
    ) {paddingValues ->
        RegisterContent(paddingValues = paddingValues)
    }
    Register(navController)
}