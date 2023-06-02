package com.eduardo.ecommerce_golosinas.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eduardo.ecommerce_golosinas.presentation.navigation.Graph
import com.eduardo.ecommerce_golosinas.presentation.navigation.graph.profile.ProfileNavGraph
import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.client.ClientScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.client.category.list.ClientCategoryListScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.client.product.list.ClientProductListScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.info.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    ){
        composable(route= ClientScreen.ProductList.route){
            ClientProductListScreen()
        }
        composable(route= ClientScreen.CategoryList.route){
            ClientCategoryListScreen()
        }
        composable(route= ClientScreen.Profile.route){
            ProfileScreen(navController)
        }
        ProfileNavGraph(navController)
    }

}