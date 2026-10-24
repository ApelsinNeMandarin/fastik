package com.example.fastik8.core.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ExtendedColors(
    val connectGradientStart: Color,
    val connectGradientEnd: Color,
    val connectRingSecond: Color,
    val connectRingThird: Color,
    val title: Color,
    val accentButton: Color,
    val onAccentButton: Color,
    val disabledContainer: Color,
    val disabledContent: Color,
    val navIconActive: Color,
    val navIconInactive: Color,
    val accentIcon: Color,
    val error: Color
)

/** Набор для тёмной темы. */
val DarkExtendedColors = ExtendedColors(
    connectGradientStart = CircleGradientStart,
    connectGradientEnd = CircleGradientEnd,
    connectRingSecond = CircleSecond,
    connectRingThird = CircleThird,
    title = TextWhite,
    accentButton = BgButton,
    onAccentButton = TextWhite,
    disabledContainer = DisabledDark,
    disabledContent = InactiveIconDark,
    navIconActive = NavIconActiveDark,
    navIconInactive = InactiveIconDark,
    accentIcon = CircleGradientStart,
    error = ErrorRed
)

/** Набор для светлой темы. */
val LightExtendedColors = ExtendedColors(
    connectGradientStart = CircleGradientStart,
    connectGradientEnd = CircleGradientEnd,
    connectRingSecond = CircleSecond,
    connectRingThird = CircleThird,
    title = TextBlack,
    accentButton = BgButton,
    onAccentButton = TextWhite,
    disabledContainer = DisabledLight,
    disabledContent = InactiveIconLight,
    navIconActive = BgButton,
    navIconInactive = InactiveIconLight,
    accentIcon = BgButton,
    error = ErrorRed
)

val LocalExtendedColors = staticCompositionLocalOf { DarkExtendedColors }