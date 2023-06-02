package com.eduardo.ecommerce_golosinas.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eduardo.ecommerce_golosinas.presentation.navigation.Graph
import com.eduardo.ecommerce_golosinas.presentation.screens.client.home.ClientHomeScreen

@Composable
fun RootNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ){
        AuthNavGraph(navController = navController)
        RolesNavGraph(navController = navController)

    }
}