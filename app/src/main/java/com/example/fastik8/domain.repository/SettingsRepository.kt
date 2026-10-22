package com.example.fastik8.domain.repository

import com.example.fastik8.core.model.ThemeMode
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    val themeMode: Flow<ThemeMode>

    suspend fun setThemeMode(mode: ThemeMode)
}