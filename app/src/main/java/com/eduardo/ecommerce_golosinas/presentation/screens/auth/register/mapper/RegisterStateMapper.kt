package com.eduardo.ecommerce_golosinas.presentation.screens.auth.register.mapper

import com.eduardo.ecommerce_golosinas.domain.model.User
import com.eduardo.ecommerce_golosinas.presentation.screens.auth.register.RegisterState

fun RegisterState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        password = password
    )
}