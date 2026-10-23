package com.example.fastik8.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.fastik8.R

enum class AppTab(
    @DrawableRes val iconRes: Int,
    @StringRes val labelRes: Int
) {
    HOME(R.drawable.home, R.string.tab_home),
    LOGIN(R.drawable.user, R.string.tab_login),
    SETTINGS(R.drawable.settings, R.string.tab_settings)
}