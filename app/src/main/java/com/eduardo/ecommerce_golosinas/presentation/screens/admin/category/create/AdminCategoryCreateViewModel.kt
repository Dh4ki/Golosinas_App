package com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.create

import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eduardo.ecommerce_golosinas.domain.model.Category
import com.eduardo.ecommerce_golosinas.domain.useCase.categories.CategoriesUseCase
import com.eduardo.ecommerce_golosinas.domain.util.Resource
import com.eduardo.ecommerce_golosinas.presentation.screens.admin.category.create.mapper.toCategory
import com.eduardo.ecommerce_golosinas.presentation.util.ComposeFileProvider
import com.eduardo.ecommerce_golosinas.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminCategoryCreateViewModel @Inject constructor(
        private val categoriesUseCase: CategoriesUseCase,
        @ApplicationContext val context: Context
    ) : ViewModel(){
    var state by mutableStateOf(AdminCategoryCreateState())
        private set

    var categoryResponse by mutableStateOf<Resource<Category>?>(null)
        private set

    // IMAGENES
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    fun createCategory() = viewModelScope.launch {
        if (file != null) {
            categoryResponse = Resource.Loading
            val result = categoriesUseCase.createCategory(state.toCategory(), file!!)
            categoryResponse = result
        }
    }

    fun clearForm() {
        state = state.copy(
            name = "",
            description = "",
            image = ""
        )
        categoryResponse = null
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*") // URI
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onDescriptionInput(input: String) {
        state = state.copy(description = input)
    }
}