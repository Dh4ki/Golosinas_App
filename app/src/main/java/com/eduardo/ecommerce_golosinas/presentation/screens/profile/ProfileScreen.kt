package com.eduardo.ecommerce_golosinas.presentation.screens.profile

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.components.ProfileContent

@Composable
fun ProfileScreen(){
    Scaffold() {paddingValues ->
        ProfileContent(paddingValues = paddingValues)
    }

}