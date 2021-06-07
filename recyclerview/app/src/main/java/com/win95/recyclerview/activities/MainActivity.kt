package com.win95.recyclerview.activities

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.win95.recyclerview.R
import com.win95.recyclerview.viewmodel.UserData
import com.win95.recyclerview.adapter.MyAdapter
import com.win95.recyclerview.networkcheckerpg.MyBroadcastReceiver
import com.win95.recyclerview.viewmodel.MainViewModel
import com.win95.recyclerview.networkcheckerpg.NetworkConnection


class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var myBroadcastReceiver: MyBroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        val progressBar : ProgressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.VISIBLE

        val recyclerView: RecyclerView = findViewById(R.id.rvUsers)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        val empty :List<UserData> = emptyList()
        recyclerView.adapter = MyAdapter(empty,this@MainActivity)


        myBroadcastReceiver = MyBroadcastReceiver()

        registerReceiver(myBroadcastReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        mainViewModel.list.observe(this,{
            if(it.isNotEmpty()) {
                progressBar.visibility = View.INVISIBLE
            }
            (recyclerView.adapter as MyAdapter).setDataInAdapter(it)
        })

        mainViewModel.fetchData()

    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(myBroadcastReceiver)
    }
}