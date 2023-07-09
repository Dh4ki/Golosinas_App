package com.eduardo.ecommerce_golosinas.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.eduardo.ecommerce_golosinas.presentation.navigation.Graph

import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.client.ClientCategoryScreen
import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.client.ClientProductScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.client.product.detail.ClientProductDetailScreen

import com.eduardo.ecommerce_golosinas.presentation.screens.client.product.listByCategory.ClientProductByCategoryListScreen


fun NavGraphBuilder.ClientProductNavGraph(navController: NavHostController){
    navigation(
        route = Graph.CLIENT_PRODUCT,
        startDestination = ClientProductScreen.ProductDetail.route
    ){

        composable(
            route = ClientProductScreen.ProductDetail.route,
            arguments = listOf(navArgument("product"){
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("product")?.let{
                ClientProductDetailScreen(navController, it)
            }
        }

        composable(
            route = ClientCategoryScreen.ProductDetail.route,
            arguments = listOf(navArgument("product"){
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("product")?.let{
                ClientProductDetailScreen(navController, it)
            }
        }

    }
}