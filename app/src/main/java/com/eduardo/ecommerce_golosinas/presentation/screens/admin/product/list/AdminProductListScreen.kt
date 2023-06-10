package com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.domain.model.Category
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultTopBar
import com.eduardo.ecommerce_golosinas.presentation.navigation.screen.admin.AdminCategoryScreen
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.list.components.AdminProductListContent
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.list.components.GetProducts

@Composable
fun AdminProductListScreen(navController: NavHostController, categoryParam: String){
    val categoryParse =  Category.fromJson(categoryParam).toJson()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 25.dp),
                onClick = { navController.navigate(route = AdminCategoryScreen.ProductCreate.passCategory(categoryParse)) },
                backgroundColor = Color.DarkGray
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    ) {paddingValues ->
        GetProducts(navController = navController, paddingValues = paddingValues)
    }

}