package com.horizon.matemticascurso.data.Local

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.InetSocketAddress
import java.net.Socket
import androidx.compose.runtime.*

suspend fun hasInternetConnection(): Boolean {
    return withContext(Dispatchers.IO) {
        try {
            val timeoutMs = 1500
            val socket = Socket()
            val socketAddress = InetSocketAddress("8.8.8.8", 53)

            socket.connect(socketAddress, timeoutMs)
            socket.close()

            true
        } catch (e: Exception) {
            false
        }
    }
}

fun Context.observeConnectivityAsFlowWithRealCheck() = callbackFlow {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val callback = NetworkCallback { connectionState ->
        launch {
            val realStatus = if (connectionState is ConnectionStatus.Available && hasInternetConnection()) {
                ConnectionStatus.Available
            } else {
                ConnectionStatus.Unavailable
            }
            trySend(realStatus)
        }
    }

    val networkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .build()

    connectivityManager.registerNetworkCallback(networkRequest, callback)

    launch {
        val currentState = getCurrentConnectivityStatus(connectivityManager)
        val realStatus = if (currentState is ConnectionStatus.Available && hasInternetConnection()) {
            ConnectionStatus.Available
        } else {
            ConnectionStatus.Unavailable
        }
        trySend(realStatus)
    }

    awaitClose {
        connectivityManager.unregisterNetworkCallback(callback)
    }
}

private fun getCurrentConnectivityStatus(connectivityManager: ConnectivityManager): ConnectionStatus {
    val connected = connectivityManager.allNetworks.any { network ->
        connectivityManager.getNetworkCapabilities(network)
            ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            ?: false
    }
    return if (connected) {
        ConnectionStatus.Available
    } else {
        ConnectionStatus.Unavailable
    }
}

fun NetworkCallback(callback: (ConnectionStatus) -> Unit): ConnectivityManager.NetworkCallback {
    return object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            callback(ConnectionStatus.Available)
        }

        override fun onLost(network: Network) {
            callback(ConnectionStatus.Unavailable)
        }
    }
}

@Composable
fun connectivityStatus(): State<ConnectionStatus> {
    val context = LocalContext.current
    val status = remember { mutableStateOf<ConnectionStatus>(ConnectionStatus.Unavailable) }

    LaunchedEffect(context) {
        context.observeConnectivityAsFlowWithRealCheck().collect {
            status.value = it
        }
    }

    return status
}

