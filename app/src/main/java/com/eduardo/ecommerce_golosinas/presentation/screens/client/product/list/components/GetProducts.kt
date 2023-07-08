package com.eduardo.ecommerce_golosinas.presentation.screens.client.product.list.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.eduardo.ecommerce_golosinas.domain.util.Resource
import com.eduardo.ecommerce_golosinas.presentation.components.ProgressBar
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.list.AdminCategoryListViewModel
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.product.list.AdminProductListViewModel
import com.eduardo.ecommerce_golosinas.presentation.screens.client.product.list.ClientProductListViewModel

@Composable
fun GetProducts(navController: NavHostController ,paddingValues: PaddingValues, vm: ClientProductListViewModel = hiltViewModel()) {
    when(val response = vm.productsResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            ClientProductListContent(navController= navController ,paddingValues = paddingValues, products = response.data)
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}