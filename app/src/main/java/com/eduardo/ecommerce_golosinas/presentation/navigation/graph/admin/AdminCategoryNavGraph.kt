package com.eduardo.ecommerce_golosinas.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.eduardo.ecommerce_golosinas.presentation.navigation.Graph
import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.admin.AdminCategoryScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.create.AdminCategoryCreateScreen


fun NavGraphBuilder.AdminCategoryNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ADMIN_CATEGORY,
        startDestination = AdminCategoryScreen.CategoryCreate.route
    ){
        composable(route = AdminCategoryScreen.CategoryCreate.route){
            AdminCategoryCreateScreen(navController)
        }
    }
}