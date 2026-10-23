package com.example.fastik8.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.fastik8.core.constants.Dimens
import com.example.fastik8.core.model.ConnectionState
import com.example.fastik8.ui.screens.home.components.ConnectionStatusText
import com.example.fastik8.ui.screens.home.components.IpInfoRow
import com.example.fastik8.ui.screens.home.components.VpnConnectButton

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    HomeContent(
        state = state,
        onConnectClick = viewModel::onConnectClick,
        onPingRefreshClick = viewModel::onPingRefreshClick,
        modifier = modifier
    )
}

@Composable
private fun HomeContent(
    state: HomeUiState,
    onConnectClick: () -> Unit,
    onPingRefreshClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VpnConnectButton(
                connectionState = state.connectionState,
                onClick = onConnectClick
            )

            Spacer(modifier = Modifier.height(Dimens.SpacingXs))

            ConnectionStatusText(connectionState = state.connectionState)
        }


        IpInfoRow(
            ipAddress = state.ipAddress,
            isIpLoading = state.isIpLoading,
            pingMs = state.pingMs,
            isPingLoading = state.isPingLoading,
            canRefreshPing = state.connectionState == ConnectionState.CONNECTED,
            connectedSeconds = state.connectedSeconds,
            onRefreshPingClick = onPingRefreshClick,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = Dimens.SpacingL)
        )
    }
}