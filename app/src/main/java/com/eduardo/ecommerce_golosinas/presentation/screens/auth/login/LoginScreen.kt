@file:OptIn(ExperimentalMaterial3Api::class)

package com.eduardo.ecommerce_golosinas.presentation.screens.auth.login

import androidx.compose.material3.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.presentation.screens.auth.login.components.Login
import com.eduardo.ecommerce_golosinas.presentation.screens.auth.login.components.LoginContent
import com.eduardo.ecommerce_golosinas.presentation.ui.theme.Ecommerce_GolosinasTheme

@Composable
fun LoginScreen(navController: NavHostController){
    Scaffold(

    ){ paddingValues ->
        LoginContent(navController = navController,  paddingValues)
    }
    Login(navController = navController )
}
