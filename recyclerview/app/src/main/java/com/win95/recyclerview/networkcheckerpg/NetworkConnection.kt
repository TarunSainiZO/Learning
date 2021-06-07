package com.win95.recyclerview.networkcheckerpg

import android.annotation.TargetApi
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import androidx.lifecycle.LiveData


class NetworkConnection(private val context: Context) : LiveData<Boolean>() {
     var connectivityManager: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    private lateinit var networkCallback: ConnectivityManager.NetworkCallback

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun connectivityMangerCallback(): ConnectivityManager.NetworkCallback {
        networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                postValue(true)
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                postValue(false)
            }
        }
        return networkCallback
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager.registerDefaultNetworkCallback(connectivityMangerCallback())
    }

    override fun onActive() {
        super.onActive()
        connectivityManager.registerDefaultNetworkCallback(connectivityMangerCallback())
    }

}