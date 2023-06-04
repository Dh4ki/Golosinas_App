package com.eduardo.ecommerce_golosinas.presentation.screens.profile.update.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.Card
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.eduardo.ecommerce_golosinas.R
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultButton
import com.eduardo.ecommerce_golosinas.presentation.components.DefaultTextField
import com.eduardo.ecommerce_golosinas.presentation.components.DialogCapturePicture
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.update.ProfileUpdateViewModel


@Composable
fun ProfileUpdateContent(paddingValues: PaddingValues, vm: ProfileUpdateViewModel = hiltViewModel()){

    val activity = LocalContext.current as? Activity
    val state = vm.state
    val stateDialog = remember { mutableStateOf(false) }
    vm.resultingActivityHandler.handle()

    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { vm.takePhoto() },
        pickImage = { vm.pickImage() }
    )

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
            if (!state.image.isNullOrBlank()){
                AsyncImage(
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                        .clickable { stateDialog.value = true },
                    model = state.image,
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
                        .clickable { stateDialog.value = true },
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
                    androidx.compose.material.Text(
                        modifier = Modifier.padding(vertical = 15.dp),
                        text = "ACTUALIZAR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.name,
                        onValueChange = { vm.onNameInput(it) },
                        label = "Nombre",
                        icon = Icons.Default.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.lastname,
                        onValueChange = { vm.onLastNameInput(it) },
                        label = "Apellido",
                        icon = Icons.Outlined.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.phone,
                        onValueChange = { vm.onPhoneInput(it) },
                        label = "Telefono",
                        icon = Icons.Default.Phone
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    DefaultButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Confirmar",
                        onClick = { vm.onUpdate() })
                }

            }
        }
    }
}