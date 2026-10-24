package com.example.fastik8.core.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ExtendedColors(
    // Круг кнопки подключения: градиент от start к end
    val connectGradientStart: Color,
    val connectGradientEnd: Color,
    // Внешние круги свечения вокруг кнопки
    val connectRingSecond: Color,
    val connectRingThird: Color,
    // Цвет заголовков и названия приложения
    val title: Color,
    // Акцентная кнопка («Войти») и текст на ней
    val accentButton: Color,
    val onAccentButton: Color,
    // Неактивная кнопка (пользователь не авторизован)
    val disabledContainer: Color,
    val disabledContent: Color,
    // Иконки нижнего меню
    val navIconActive: Color,
    val navIconInactive: Color,
    // Оранжевые иконки внутри карточек (например, иконка IP) и обводка таймера
    val accentIcon: Color,
    // Цвет ошибок
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