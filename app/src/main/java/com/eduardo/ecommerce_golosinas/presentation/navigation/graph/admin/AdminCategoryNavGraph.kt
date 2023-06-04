package com.eduardo.ecommerce_golosinas.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.eduardo.ecommerce_golosinas.presentation.navigation.Graph
import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.admin.AdminCategoryScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.create.AdminCategoryCreateScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.update.AdminCategoryUpdateScreen


fun NavGraphBuilder.AdminCategoryNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ADMIN_CATEGORY,
        startDestination = AdminCategoryScreen.CategoryCreate.route
    ){
        composable(route = AdminCategoryScreen.CategoryCreate.route){
            AdminCategoryCreateScreen(navController)
        }

        composable(
            route = AdminCategoryScreen.CategoryUpdate.route,
            arguments = listOf(navArgument( "category"){
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("category")?.let {
                AdminCategoryUpdateScreen(navController, it)
            }
        }
    }
}