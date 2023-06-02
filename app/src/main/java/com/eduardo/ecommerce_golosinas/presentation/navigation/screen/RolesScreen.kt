package com.eduardo.ecommerce_golosinas.presentation.navigation.screen



sealed class RolesScreen(val route: String){
    object Roles: RolesScreen( "roles")
}
