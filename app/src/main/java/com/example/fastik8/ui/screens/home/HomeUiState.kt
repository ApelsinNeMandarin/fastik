package com.example.fastik8.ui.screens.home

import com.example.fastik8.core.model.ConnectionState

data class HomeUiState(
    val connectionState: ConnectionState = ConnectionState.DISCONNECTED,

    val ipAddress: String? = null,

    val isIpLoading: Boolean = true,

    val pingMs: Int? = null,

    val isPingLoading: Boolean = false,

    val isPingVisible: Boolean = false,

    val connectedSeconds: Long = 0
)