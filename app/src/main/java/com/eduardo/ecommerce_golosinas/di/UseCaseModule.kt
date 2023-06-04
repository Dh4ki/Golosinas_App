package com.eduardo.ecommerce_golosinas.di

import com.eduardo.ecommerce_golosinas.data.repository.dataSource.AuthRemoteDataSource
import com.eduardo.ecommerce_golosinas.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.eduardo.ecommerce_golosinas.data.service.AuthService
import com.eduardo.ecommerce_golosinas.domain.repository.AuthRepository
import com.eduardo.ecommerce_golosinas.domain.repository.CategoriesRepository
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
//        getCategories = GetCategoriesUseCase(categoriesRepository),
//        updateCategory = UpdateCategoryUseCase(categoriesRepository),
//        updateCategoryWithImage = UpdateCategoryWithImageUseCase(categoriesRepository),
//        deleteCategory = DeleteCategoryUseCase(categoriesRepository)
    )
}