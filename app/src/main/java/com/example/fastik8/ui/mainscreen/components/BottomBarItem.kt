package com.example.fastik8.ui.mainscreen.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.fastik8.core.constants.AnimationConstants
import com.example.fastik8.core.constants.Dimens
import com.example.fastik8.core.theme.FastikTheme
import com.example.fastik8.ui.navigation.AppTab


@Composable
fun BottomBarItem(
    tab: AppTab,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val iconColor by animateColorAsState(
        targetValue = if (selected) {
            FastikTheme.colors.navIconActive
        } else {
            FastikTheme.colors.navIconInactive
        },
        animationSpec = tween(durationMillis = AnimationConstants.FADE_MS),
        label = "navIconColor"
    )

    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            painter = painterResource(tab.iconRes),
            contentDescription = stringResource(tab.labelRes),
            tint = iconColor,
            modifier = Modifier.size(Dimens.NavIconSize)
        )
    }
}