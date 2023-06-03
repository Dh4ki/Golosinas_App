package com.eduardo.ecommerce_golosinas.presentation.screens.profile.update

import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eduardo.ecommerce_golosinas.domain.model.User
import com.eduardo.ecommerce_golosinas.domain.useCase.auth.AuthUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.users.UsersUseCase
import com.eduardo.ecommerce_golosinas.domain.util.Resource
import com.eduardo.ecommerce_golosinas.presentation.screens.profile.update.mapper.toUser
import com.eduardo.ecommerce_golosinas.presentation.util.ComposeFileProvider
import com.eduardo.ecommerce_golosinas.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
        private val authUseCase: AuthUseCase,
        private val usersUseCase: UsersUseCase,
        private val savedStateHandle: SavedStateHandle,
        @ApplicationContext private val context: Context
    ) : ViewModel(){

    var state by mutableStateOf(ProfileUpdateState())

    // argumentos
    val data = savedStateHandle.get<String>("user")
    var user = User.fromJson(data!!)

    // IMAGENES
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    var updateResponse by mutableStateOf<Resource<User>?>(null)
        private set
    init {
        state = state.copy(
            name = user.name,
            lastname = user.lastname,
            phone = user.phone,
            image = user.image ?: ""
        )
    }

    fun onUpdate() {
        if (file != null) { // SI SELECCIONO UNA IMAGEN
            updateWithImage()
        }
        else {
            update()
        }
    }
    fun updateWithImage() = viewModelScope.launch {
        updateResponse = Resource.Loading
        val result = usersUseCase.updateUserWithImage(user.id ?: "", state.toUser(), file!!)
        updateResponse = result
    }

    fun updateUserSession(userResponse: User) = viewModelScope.launch{
        authUseCase.updateSession(userResponse)
    }

    fun update() = viewModelScope.launch {
        updateResponse = Resource.Loading
        val result = usersUseCase.updateUser(user.id ?: "", state.toUser())
        updateResponse = result

    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null){
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null){
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }
    }

    fun onNameInput(input: String){
        state= state.copy(name = input)
    }
    fun onLastNameInput(input: String){
        state= state.copy(lastname = input)
    }
    fun onImageInput(input: String){
        state= state.copy(image = input)
    }
    fun onPhoneInput(input: String){
        state= state.copy(phone = input)
    }
}