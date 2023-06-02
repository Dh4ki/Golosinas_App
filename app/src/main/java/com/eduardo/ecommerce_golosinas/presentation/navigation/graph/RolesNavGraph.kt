package com.eduardo.ecommerce_golosinas.presentation.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.eduardo.ecommerce_golosinas.presentation.navigation.Graph
import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.AuthScreen
import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.RolesScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.home.AdminHomeScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.auth.login.LoginScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.auth.register.RegisterScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.client.home.ClientHomeScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.RolesNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ){
        composable(route = RolesScreen.Roles.route){
            RolesScreen(navController)
        }
        composable(route = Graph.CLIENT){
            ClientHomeScreen()
        }
        composable(route = Graph.ADMIN){
            AdminHomeScreen()
        }
    }
}