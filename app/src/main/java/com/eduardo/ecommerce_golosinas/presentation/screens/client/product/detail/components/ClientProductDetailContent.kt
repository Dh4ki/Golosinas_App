package com.eduardo.ecommerce_golosinas.presentation.screens.client.product.detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultButton
import com.eduardo.ecommerce_golosinas.presentation.components.DotsIndicator
import com.eduardo.ecommerce_golosinas.presentation.components.SliderView
import com.eduardo.ecommerce_golosinas.presentation.screens.client.product.detail.ClientProductDetailViewModel
import com.eduardo.ecommerce_golosinas.presentation.ui.theme.Gray200
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ClientProductDetailContent(paddingValues: PaddingValues, vm: ClientProductDetailViewModel = hiltViewModel()) {
    val state = rememberPagerState()
    Box(
        modifier = Modifier.padding(paddingValues).fillMaxSize()
    ) {
        Column(

        ) {
            SliderView(state = state , images = vm.productImages)
            Spacer(modifier = Modifier.padding(4.dp))
            DotsIndicator(totalDots = vm.productImages.size, selectedIndex = state.currentPage)
        }
        Card(
            modifier = Modifier.padding(top = 310.dp),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp
            )
        ){
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 7.dp),
                    text = vm.product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                )
                Divider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Gray200
                )
                Text(
                    modifier = Modifier.padding(bottom = 7.dp),
                    text = "Descripcion",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = vm.product.description,
                    fontSize = 15.sp
                )
                Divider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Gray200
                )
                Text(
                    modifier = Modifier.padding(bottom = 7.dp),
                    text = "Precio",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = vm.product.price.toString(),
                    fontSize = 15.sp
                )
                Divider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Gray200
                )
                Text(
                    modifier = Modifier.padding(bottom = 7.dp),
                    text = "Tu orden",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Cantidad: 0",
                    fontSize = 15.sp
                )
                Text(
                    text = "Precio C/U: 0",
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier.width(100.dp).height(35.dp),
                        shape = RoundedCornerShape(10.dp),
                        backgroundColor = Gray200
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        )   {
                            Text(
                                modifier = Modifier.clickable { vm.remove() },
                                text = "-",
                                fontSize = 18.sp,
                                color = Color.White
                            )
                            Text(
                                text = vm.quantity.toString(),
                                fontSize = 19.sp,
                                color = Color.White
                            )
                            Text(
                                modifier = Modifier.clickable { vm.add() },
                                text = "+",
                                fontSize = 19.sp,
                                color = Color.White
                            )
                        }
                    }

                    DefaultButton(
                        modifier = Modifier.width(200.dp),
                        text = "AGREGAR",
                        onClick = { vm.saveItem() }
                    )
                }

            }
        }
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