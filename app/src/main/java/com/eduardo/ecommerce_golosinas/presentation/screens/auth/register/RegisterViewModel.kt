package com.eduardo.ecommerce_golosinas.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eduardo.ecommerce_golosinas.domain.model.AuthResponse
import com.eduardo.ecommerce_golosinas.domain.model.User
import com.eduardo.ecommerce_golosinas.domain.useCase.auth.AuthUseCase
import com.eduardo.ecommerce_golosinas.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")

    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun register() = viewModelScope.launch {
        if (isValidForm()){
            val user = User(
                name = state.name,
                lastname = state.lastname,
                phone = state.phone,
                email = state.email,
                password = state.password,
            )
            registerResponse = Resource.Loading
            val result = authUseCase.register(user)
            registerResponse = result //DATA / ERROR
        }
    }
    fun onNameInput(input: String){
        state= state.copy(name = input)
    }
    fun onLastNameInput(input: String){
        state= state.copy(lastname = input)
    }
    fun onEmailInput(input: String){
        state= state.copy(email = input)
    }
    fun onPhoneInput(input: String){
        state= state.copy(phone = input)
    }
    fun onPasswordInput(input: String){
        state= state.copy(password = input)
    }
    fun onConfirmPasswordInput(input: String){
        state= state.copy(confirmPassword = input)
    }

    fun isValidForm(): Boolean{
        if (state.name == ""){
            errorMessage = "Ingresa tú nombre"
            return false
        }
        else if (state.lastname == ""){
            errorMessage = "Ingresa tú apellido"
            return false
        }
        else if (state.email == ""){
            errorMessage = "Ingresa tú correo electrónico"
            return false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El correo electrónico no es válido"
            return false
        }
        else if (state.phone == ""){
            errorMessage = "Ingresa tú teléfono"
            return false
        }
        else if (state.password == ""){
            errorMessage = "Ingresa tú contraseña"
            return false
        }
        else if (state.password.length < 6 ){
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        else if (state.confirmPassword == ""){
            errorMessage = "Confirma tu contraseña"
            return false
        }
        else if (state.password != state.confirmPassword){
            errorMessage = "Las contraseñas no coindiden"
            return false
        }
        return true
    }

}