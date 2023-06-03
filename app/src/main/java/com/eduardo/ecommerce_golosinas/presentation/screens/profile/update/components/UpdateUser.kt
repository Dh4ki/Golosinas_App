package com.eduardo.ecommerce_golosinas.presentation.screens.profile.update.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.domain.util.Resource
import com.eduardo.ecommerce_golosinas.presentation.components.ProgressBar
import com.eduardo.ecommerce_golosinas.presentation.navigation.Graph
import com.eduardo.ecommerce_golosinas.presentation.screens.auth.login.LoginViewModel
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun UpdateUser( vm: ProfileUpdateViewModel = hiltViewModel()){

    when(val response= vm.updateResponse){
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            vm.updateUserSession(response.data)
            Toast.makeText(LocalContext.current, "Los datos se han actualizado correctamente", Toast.LENGTH_LONG).show()
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }
        else    -> {
            if (response != null){
                Toast.makeText(LocalContext.current, "Hubo un error desconodido", Toast.LENGTH_SHORT).show()
            }

        }
    }
}