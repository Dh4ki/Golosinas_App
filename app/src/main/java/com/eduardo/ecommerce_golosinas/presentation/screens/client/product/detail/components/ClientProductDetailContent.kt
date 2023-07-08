package com.eduardo.ecommerce_golosinas.presentation.screens.client.product.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.eduardo.ecommerce_golosinas.presentation.components.DotsIndicator
import com.eduardo.ecommerce_golosinas.presentation.components.SliderView
import com.eduardo.ecommerce_golosinas.presentation.screens.client.product.detail.ClientProductDetailViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ClientProductDetailContent(paddingValues: PaddingValues, vm: ClientProductDetailViewModel = hiltViewModel()) {
    val state = rememberPagerState()
    Column(Modifier.padding(paddingValues)) {
        SliderView(state = state , images = vm.productImages)
        Spacer(modifier = Modifier.padding(4.dp))
        DotsIndicator(totalDots = vm.productImages.size, selectedIndex = state.currentPage)
    }
    LaunchedEffect(key1 = state.currentPage){
        delay(10000)
        var newPosition = state.currentPage + 1
        if (newPosition > vm.productImages.size - 1){
            newPosition = 0
        }
        state.animateScrollToPage(newPosition)
    }
}