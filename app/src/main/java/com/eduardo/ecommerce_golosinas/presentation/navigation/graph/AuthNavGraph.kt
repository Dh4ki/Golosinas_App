package com.eduardo.ecommerce_golosinas.presentation.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.eduardo.ecommerce_golosinas.presentation.navigation.Graph
import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.AuthScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.home.AdminHomeScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.auth.login.LoginScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.auth.register.RegisterScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.client.home.ClientHomeScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            LoginScreen(navController)
        }
        composable(route = AuthScreen.Register.route){
            RegisterScreen(navController)
        }
    }
}