package com.eduardo.ecommerce_golosinas.data.data.store

import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.eduardo.ecommerce_golosinas.core.Config.AUTH_KEY
import com.eduardo.ecommerce_golosinas.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthDataStore constructor(private val dataStore: DataStore<Preferences>) {

    suspend fun save(authResponse: AuthResponse){
        dataStore.edit { pref ->
            val dataStoreKey = stringPreferencesKey(AUTH_KEY)
            pref[dataStoreKey] = authResponse.toJson()
        }
    }
    suspend fun delete(){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref ->
            pref.remove(dataStoreKey)
        }
    }

    fun getData(): Flow<AuthResponse> {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        return dataStore.data.map { pref ->
            if (pref[dataStoreKey] != null){
                AuthResponse.fromJson(pref[dataStoreKey] !!)
            }
            else{
                AuthResponse()
            }
        }
    }
}