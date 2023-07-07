package com.eduardo.ecommerce_golosinas.di

import com.eduardo.ecommerce_golosinas.domain.repository.AuthRepository
import com.eduardo.ecommerce_golosinas.domain.repository.CategoriesRepository
import com.eduardo.ecommerce_golosinas.domain.repository.ProductsRepository
import com.eduardo.ecommerce_golosinas.domain.repository.UsersRepository
import com.eduardo.ecommerce_golosinas.domain.useCase.auth.AuthUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.auth.GetSessionDataUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.auth.LoginUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.auth.LogoutUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.auth.RegisterUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.auth.SaveSessionUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.auth.UpdateSessionUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.categories.CategoriesUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.categories.CreateCategoryUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.categories.DeleteCategoryUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.categories.GetCategoriesUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.categories.UpdateCategoryUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.categories.UpdateCategoryWithImageUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.products.CreateProductUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.products.FindByCategoryUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.products.ProductsUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.products.UpdateProductUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.users.UpdateUserUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.users.UpdateUserWithImageUseCase
import com.eduardo.ecommerce_golosinas.domain.useCase.users.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository),
        updateSession = UpdateSessionUseCase(authRepository),
    )

    @Provides
    fun provideUsersUseCase(usersRepository: UsersRepository) = UsersUseCase(
        updateUser = UpdateUserUseCase(usersRepository),
        updateUserWithImage = UpdateUserWithImageUseCase(usersRepository)
    )

    @Provides
    fun provideCategoriesUseCase(categoriesRepository: CategoriesRepository) = CategoriesUseCase(
        createCategory = CreateCategoryUseCase(categoriesRepository),
        getCategories = GetCategoriesUseCase(categoriesRepository),
        updateCategory = UpdateCategoryUseCase(categoriesRepository),
        updateCategoryWithImage = UpdateCategoryWithImageUseCase(categoriesRepository),
        deleteCategory = DeleteCategoryUseCase(categoriesRepository)
    )

    @Provides
    fun provideProductsUseCase(productsRepository: ProductsRepository) = ProductsUseCase(
        createProduct = CreateProductUseCase(productsRepository),
        findByCategory = FindByCategoryUseCase(productsRepository),
        //findAll = FindAllUseCase(productsRepository),
        updateProduct = UpdateProductUseCase(productsRepository),
        //updateProductWithImage = UpdateProductWithImageUseCase(productsRepository),
        //deleteProduct = DeleteProductUseCase(productsRepository),
        //findByName = FindByNameUseCase(productsRepository)
    )
}