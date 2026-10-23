package com.example.fastik8.core.constants

import androidx.compose.ui.unit.dp

object Dimens {

    private const val DESIGN_WIDTH_PX = 1440f
    private const val TARGET_WIDTH_DP = 390f
    private const val FIGMA_SCALE = TARGET_WIDTH_DP / DESIGN_WIDTH_PX

    private fun fromDesign(px: Int) = (px * FIGMA_SCALE).dp

    val FirstCircle = fromDesign(742)
    val SecondCircle = fromDesign(928)
    val ThirdCircle = fromDesign(1100)

    val WifiIconWidth = fromDesign(437)
    val WifiIconHeight = fromDesign(350)

    val TangerineWidth = fromDesign(542)
    val TangerineHeight = fromDesign(536)
    val TangerineOffsetX = fromDesign(22)

    val BottomBarWidth = fromDesign(1240)
    val BottomBarHeight = fromDesign(242)
    val BottomBarRadius = fromDesign(26)
    val NavIconSize = fromDesign(100)

    val EnterButtonWidth = fromDesign(835)
    val EnterButtonHeight = fromDesign(130)
    val EnterButtonRadius = fromDesign(40)

    val IpCardHeight = fromDesign(243)
    val IpCardRadius = fromDesign(26)
    val IpIconWidth = fromDesign(188)
    val IpIconHeight = fromDesign(123)

    val SpacingXs = 4.dp
    val SpacingS = 8.dp
    val SpacingM = 16.dp
    val SpacingL = 24.dp
    val SpacingXl = 32.dp
    val ScreenPadding = fromDesign(100)

    val IpPingGap = SpacingS

    val IpCardWidth = BottomBarWidth

    val TimerGap = SpacingL

    val PingBadgeWidth = (BottomBarWidth - TimerGap) / 2
    val TimerWidth = PingBadgeWidth

    val TimerBorder = fromDesign(17)

    val ActionIconSize = 20.dp
}