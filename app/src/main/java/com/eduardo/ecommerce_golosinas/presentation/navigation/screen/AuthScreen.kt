package com.eduardo.ecommerce_golosinas.presentation.navigation.screen



sealed class AuthScreen(val route: String){
    object Login: AuthScreen("login")
    object Register: AuthScreen( "register")
}
