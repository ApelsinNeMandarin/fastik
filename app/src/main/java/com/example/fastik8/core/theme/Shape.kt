package com.example.fastik8.core.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import com.example.fastik8.core.constants.Dimens

val AppShapes = Shapes(
    small = RoundedCornerShape(Dimens.IpCardRadius),
    medium = RoundedCornerShape(Dimens.EnterButtonRadius),
    large = RoundedCornerShape(Dimens.BottomBarRadius)
)