package com.win95.recyclerview.networkcheckerpg

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.win95.recyclerview.activities.ShowDialog

class MyBroadcastReceiver : BroadcastReceiver() {
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context?, intent: Intent?) {
        val status = context?.let { NetworkConnection.getConnectivityStatus(it) }
        if(status == false){
            (context as Activity).finish()
            val i = Intent(context, ShowDialog::class.java);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}