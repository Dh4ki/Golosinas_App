package com.eduardo.ecommerce_golosinas.presentation.screens.profile.update

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eduardo.ecommerce_golosinas.domain.model.User
import com.eduardo.ecommerce_golosinas.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel(){

    var user by mutableStateOf<User?>(null)
        private set

}