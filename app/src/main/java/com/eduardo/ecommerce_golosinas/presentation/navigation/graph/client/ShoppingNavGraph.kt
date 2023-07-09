package com.eduardo.ecommerce_golosinas.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.eduardo.ecommerce_golosinas.presentation.navigation.Graph

import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.client.ClientCategoryScreen
import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.client.ShoppingBagScreen

import com.eduardo.ecommerce_golosinas.presentation.screens.client.product.listByCategory.ClientProductByCategoryListScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.client.shopping_bag.ClientShoppingBagScreen


fun NavGraphBuilder.ShoppingNavGraph(navController: NavHostController){
    navigation(
        route = Graph.SHOPPING_BAG,
        startDestination = ShoppingBagScreen.ShoppingBag.route
    ){
        composable(
            route = ShoppingBagScreen.ShoppingBag.route,
        ){
            ClientShoppingBagScreen(navController)
        }
    }
}