package com.win95.recyclerview.networkcheckerpg

import android.content.Context
import android.net.ConnectivityManager


class NetworkConnection() {
    companion object {
        fun getConnectivityStatus(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            if (activeNetwork != null) {
                if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
                    return true
                } else if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                    return true
                }
            } else {
                return false
            }
            return false
        }
    }
}