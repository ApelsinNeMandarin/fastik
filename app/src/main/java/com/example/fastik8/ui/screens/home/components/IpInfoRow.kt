package com.example.fastik8.ui.screens.home.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.fastik8.R
import com.example.fastik8.core.constants.AnimationConstants
import com.example.fastik8.core.constants.Dimens
import com.example.fastik8.core.theme.FastikTheme
import java.util.Locale

@Composable
fun IpInfoRow(
    ipAddress: String?,
    isIpLoading: Boolean,
    pingMs: Int?,
    isPingLoading: Boolean,
    canRefreshPing: Boolean,
    connectedSeconds: Long,
    onRefreshPingClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.width(Dimens.BottomBarWidth),
        verticalArrangement = Arrangement.spacedBy(Dimens.IpPingGap)
    ) {
        IpCard(
            ipAddress = ipAddress,
            isLoading = isIpLoading
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PingBadge(
                pingMs = pingMs,
                isLoading = isPingLoading,
                canRefresh = canRefreshPing,
                onRefreshClick = onRefreshPingClick
            )

            TimerBadge(seconds = connectedSeconds)
        }
    }
}

@Composable
private fun IpCard(
    ipAddress: String?,
    isLoading: Boolean,
    modifier: Modifier = Modifier
) {
    val ipText = when {
        isLoading -> stringResource(R.string.ip_loading)
        ipAddress != null -> ipAddress
        else -> stringResource(R.string.ip_error)
    }

    Surface(
        modifier = modifier
            .width(Dimens.IpCardWidth)
            .height(Dimens.IpCardHeight),
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Dimens.SpacingS),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ip),
                contentDescription = null,
                tint = FastikTheme.colors.accentIcon,
                modifier = Modifier.size(
                    width = Dimens.IpIconWidth,
                    height = Dimens.IpIconHeight
                )
            )

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(Dimens.SpacingS)
            ) {
                Text(
                    text = stringResource(R.string.ip_label),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.65f),
                    modifier = Modifier.alignByBaseline()
                )
                Text(
                    text = ipText,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .weight(1f, fill = false)
                        .alignByBaseline()
                )
            }
        }
    }
}

@Composable
private fun PingBadge(
    pingMs: Int?,
    isLoading: Boolean,
    canRefresh: Boolean,
    onRefreshClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .width(Dimens.PingBadgeWidth)
            .height(Dimens.IpCardHeight),
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Crossfade(
                targetState = isLoading,
                animationSpec = tween(durationMillis = AnimationConstants.FADE_MS),
                modifier = Modifier.weight(1f),
                label = "pingText"
            ) { loading ->
                Text(
                    text = when {
                        loading -> stringResource(R.string.ping_loading)
                        pingMs != null -> stringResource(R.string.ping_value, pingMs)
                        else -> stringResource(R.string.ping_unknown)
                    },
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    softWrap = false
                )
            }

            val spin = if (isLoading) rememberSpin() else 0f

            IconButton(
                onClick = onRefreshClick,
                enabled = canRefresh && !isLoading,
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = stringResource(R.string.cd_refresh_ping),
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .size(Dimens.ActionIconSize)
                        .graphicsLayer { rotationZ = spin }
                )
            }
        }
    }
}

@Composable
private fun TimerBadge(
    seconds: Long,
    modifier: Modifier = Modifier
) {
    val shape = MaterialTheme.shapes.small

    Box(
        modifier = modifier
            .width(Dimens.TimerWidth)
            .height(Dimens.IpCardHeight)
            .border(
                width = Dimens.TimerBorder,
                color = FastikTheme.colors.accentIcon,
                shape = shape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = formatTime(seconds),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 1,
            softWrap = false
        )
    }
}

private fun formatTime(totalSeconds: Long): String {
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    val seconds = totalSeconds % 60
    return String.format(Locale.ROOT, "%02d:%02d:%02d", hours, minutes, seconds)
}

@Composable
private fun rememberSpin(): Float {
    val transition = rememberInfiniteTransition(label = "spinTransition")

    val angle by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = AnimationConstants.SPIN_MS,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "spin"
    )
    return angle
}