package com.eduardo.ecommerce_golosinas.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.eduardo.ecommerce_golosinas.core.Config.AUTH_PREFERENCE
import com.eduardo.ecommerce_golosinas.data.datastore.AuthDatastore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun providePreferenceDataStore(@ApplicationContext context: Context) : DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            produceFile =  {
                context.preferencesDataStoreFile( AUTH_PREFERENCE)
            }
        )

    @Provides
    @Singleton
    fun provideAuthDataStore(dataStore: DataStore<Preferences>) = AuthDatastore(dataStore)

}