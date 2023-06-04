package com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.list.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.eduardo.ecommerce_golosinas.domain.util.Resource
import com.eduardo.ecommerce_golosinas.presentation.components.ProgressBar
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.list.AdminCategoryListViewModel


@Composable
fun DeleteCategory(vm: AdminCategoryListViewModel = hiltViewModel()) {
    when(val response = vm.deleteCategoryResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            Toast.makeText(LocalContext.current, "La categoria se ha eliminado correctamente", Toast.LENGTH_LONG).show()
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