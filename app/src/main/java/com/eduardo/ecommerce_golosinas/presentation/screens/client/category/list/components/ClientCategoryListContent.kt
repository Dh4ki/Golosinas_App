package com.eduardo.ecommerce_golosinas.presentation.screens.client.category.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.domain.model.Category

@Composable
fun ClientCategoryListContent(
        paddingValues: PaddingValues,
        navController: NavHostController,
        categories : List<Category>
){
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 55.dp)
    ) {
        items(
            items = categories
        ) {category ->
            ClientCategoryListItem(
                navController = navController,
                category = category
            )
        }
    }
}