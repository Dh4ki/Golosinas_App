package com.eduardo.ecommerce_golosinas.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eduardo.ecommerce_golosinas.presentation.navigation.Graph
import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.AdminScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.list.AdminProductListScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.ProductList.route
    ){
        composable(route= AdminScreen.ProductList.route){
            AdminProductListScreen()
        }
        composable(route= AdminScreen.CategoryList.route){
            AdminCategoryListScreen()
        }
        composable(route= AdminScreen.Profile.route){
            ProfileScreen()
        }
    }

}