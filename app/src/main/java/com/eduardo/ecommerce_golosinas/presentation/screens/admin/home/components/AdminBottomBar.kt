package com.eduardo.ecommerce_golosinas.presentation.screens.admin.home.components

import androidx.compose.material.BottomNavigation
import androidx.navigation.NavHostController
import androidx.compose.runtime.*
import androidx.navigation.compose.currentBackStackEntryAsState
import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.AdminScreen

@Composable
fun AdminBottomBar(navController: NavHostController){
    val screens = listOf(
        AdminScreen.ProductList,
        AdminScreen.CategoryList,
        AdminScreen.Profile,
    )
    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any{ it.route == currentDestination?.route}

    if (bottomBarDestination){
        BottomNavigation(){
            screens.forEach { screen->
                AdminBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}