@file:OptIn(ExperimentalMaterial3Api::class)

package com.eduardo.ecommerce_golosinas.presentation.screens.auth.register

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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