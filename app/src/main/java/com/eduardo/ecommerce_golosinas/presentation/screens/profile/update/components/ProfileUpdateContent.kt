package com.eduardo.ecommerce_golosinas.presentation.screens.profile.update.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material3.Text
import coil.compose.AsyncImage
import com.eduardo.ecommerce_golosinas.R
import com.eduardo.ecommerce_golosinas.presentation.MainActivity
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultButton
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultTextField
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.info.ProfileViewModel
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.update.ProfileUpdateViewModel


@Composable
fun ProfileUpdateContent(paddingValues: PaddingValues, vm: ProfileUpdateViewModel = hiltViewModel()){
    val activity = LocalContext.current as? Activity
    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.profile_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(redScale = 0.7f, greenScale = 0.7f, blueScale = 0.7f, alphaScale = 0.8f)
                }
            )
        )
        Column(modifier = Modifier.fillMaxWidth()) {
            if (!vm.user?.image.isNullOrBlank()){
                AsyncImage(
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    model = vm.user?.image,
                    contentDescription ="",
                    contentScale = ContentScale.Crop
                )
            }else{
                Spacer(modifier = Modifier.padding(top = 80.dp))
                Image(
                    modifier = Modifier
                        .size(160.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                    ,
                    painter = painterResource(id = R.drawable.user_image),
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                backgroundColor = Color.White.copy(alpha = 0.75f)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Nombre",
                        icon = Icons.Default.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Apellido",
                        icon = Icons.Outlined.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Telefono",
                        icon = Icons.Default.Phone
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    DefaultButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Confirmar",
                        onClick = { /*TODO*/ })
                }

            }
        }
    }
}