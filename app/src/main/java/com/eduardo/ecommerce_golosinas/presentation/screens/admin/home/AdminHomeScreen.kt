package com.eduardo.ecommerce_golosinas.presentation.screens.admin.home

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.eduardo.ecommerce_golosinas.presentation.navigation.graph.admin.AdminNavGraph
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.home.components.AdminBottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AdminHomeScreen(navController: NavHostController = rememberNavController()){
    Scaffold(
        bottomBar = { AdminBottomBar(navController = navController) }
    ) { paddingValues ->
       AdminNavGraph(navController = navController)
    }
}
