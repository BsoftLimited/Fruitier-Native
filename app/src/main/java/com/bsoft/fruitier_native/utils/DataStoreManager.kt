package com.bsoft.fruitier_native.utils

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "settings")

class DataStoreManager(private val context: Context) {
    private val onboardingCompletedKey = booleanPreferencesKey("isOnboardingCompleted")
    private val themeModeKey = stringPreferencesKey("themeMode")

    val isOnboardingCompleted: Flow<Boolean?> = context.dataStore.data.map {
        it[onboardingCompletedKey] ?: false
    }

    val themeMode: Flow<String> = context.dataStore.data.map {
        it[themeModeKey] ?: "auto"
    }

    suspend fun saveOnboardingCompleted(completed: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[onboardingCompletedKey] = completed
        }
    }

    suspend fun changeThemeMode(themeMode: String) {
        context.dataStore.edit { preferences ->
            preferences[themeModeKey] = themeMode
        }
    }
}