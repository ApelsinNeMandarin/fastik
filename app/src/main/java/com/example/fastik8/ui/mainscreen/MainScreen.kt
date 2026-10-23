package com.example.fastik8.ui.mainscreen

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.fastik8.core.constants.AnimationConstants
import com.example.fastik8.core.constants.Dimens
import com.example.fastik8.core.model.ThemeMode
import com.example.fastik8.ui.mainscreen.components.AppBottomBar
import com.example.fastik8.ui.mainscreen.components.AppTopBar
import com.example.fastik8.ui.navigation.AppTab
import com.example.fastik8.ui.screens.home.HomeScreen
import com.example.fastik8.ui.screens.login.LoginScreen
import com.example.fastik8.ui.screens.settings.SettingsScreen

@Composable
fun MainScreen(
    onThemeSelected: (ThemeMode) -> Unit,
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val selectedTab by viewModel.selectedTab.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        AppTopBar()

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Crossfade(
                targetState = selectedTab,
                animationSpec = tween(durationMillis = AnimationConstants.FADE_MS),
                label = "screenSwitch"
            ) { tab ->
                when (tab) {
                    AppTab.HOME -> HomeScreen()
                    AppTab.LOGIN -> LoginScreen()
                    AppTab.SETTINGS -> SettingsScreen(onThemeSelected = onThemeSelected)
                }
            }
        }

        AppBottomBar(
            selectedTab = selectedTab,
            onTabSelected = viewModel::onTabSelected,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = Dimens.SpacingM)
        )
    }
}