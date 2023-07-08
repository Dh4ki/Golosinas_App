package com.eduardo.ecommerce_golosinas.presentation.screens.client.product.list

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import com.eduardo.ecommerce_golosinas.domain.model.Product
import com.eduardo.ecommerce_golosinas.domain.useCase.products.ProductsUseCase
import com.eduardo.ecommerce_golosinas.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductListViewModel @Inject constructor(private val productsUseCase: ProductsUseCase): ViewModel() {

    var productsResponse by mutableStateOf<Resource<List<Product>>?>(null)
        private set

    init {
        getProducts()
    }

    fun getProducts() = viewModelScope.launch {
        productsResponse = Resource.Loading
        productsUseCase.findAll().collect() {
            productsResponse = it
        }
    }

}