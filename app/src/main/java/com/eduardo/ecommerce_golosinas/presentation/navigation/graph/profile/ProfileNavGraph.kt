package com.eduardo.ecommerce_golosinas.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.eduardo.ecommerce_golosinas.presentation.navigation.Graph
import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.profile.ProfileScreen
import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.roles.RolesScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.home.AdminHomeScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.client.home.ClientHomeScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.update.ProfileUpdateScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController){
    navigation(
        route = Graph.PROFILE + "/{user}",
        startDestination = ProfileScreen.ProfileUpdate.route
    ){
        composable(
            route = ProfileScreen.ProfileUpdate.route,
            arguments = listOf(navArgument( "user"){
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("user")?.let {
                ProfileUpdateScreen(navController, userParam = it)
            }

        }
    }
}