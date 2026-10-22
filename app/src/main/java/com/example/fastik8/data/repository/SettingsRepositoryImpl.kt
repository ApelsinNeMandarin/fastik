package com.example.fastik8.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.fastik8.core.model.ThemeMode
import com.example.fastik8.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : SettingsRepository {

    private val themeKey = stringPreferencesKey("theme_mode")

    override val themeMode: Flow<ThemeMode> = dataStore.data
        .catch { e ->
            if (e is IOException) emit(emptyPreferences()) else throw e
        }
        .map { prefs ->
            val saved = prefs[themeKey]
            ThemeMode.entries.firstOrNull { it.name == saved } ?: ThemeMode.SYSTEM
        }

    override suspend fun setThemeMode(mode: ThemeMode) {
        dataStore.edit { prefs -> prefs[themeKey] = mode.name }
    }
}