package com.eduardo.ecommerce_golosinas.presentation.navigation.screen.profile



sealed class ProfileScreen(val route: String){
    object ProfileUpdate: ProfileScreen( "profile/update")
}
