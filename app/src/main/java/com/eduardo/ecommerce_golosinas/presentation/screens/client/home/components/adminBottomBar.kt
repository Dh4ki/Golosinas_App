package com.eduardo.ecommerce_golosinas.presentation.screens.client.home.components

import androidx.compose.material.BottomNavigation
import androidx.navigation.NavHostController
import androidx.compose.runtime.*
import androidx.navigation.compose.currentBackStackEntryAsState
import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.ClientScreen

@Composable
fun ClientBottomBar(navController: NavHostController){
    val screens = listOf(
        ClientScreen.ProductList,
        ClientScreen.CategoryList,
        ClientScreen.Profile,
    )
    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any{ it.route == currentDestination?.route}

    if (bottomBarDestination){
        BottomNavigation(){
            screens.forEach { screen->
                ClientBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}