package com.win95.recyclerview

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Adapter
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.win95.rec.MainViewModel
import com.win95.users.NetworkConnection


class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
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
        val view = LayoutInflater.from(this).inflate(R.layout.network,null,false)

        val builder = AlertDialog.Builder(this)
        builder.setView(view)
        val dialog : AlertDialog = builder.create()
        dialog.window?.setGravity(Gravity.CENTER)
        dialog.setCancelable(false)

        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this, Observer {
            if(!it){
                dialog.show()
            }else{
                dialog.hide()
                mainViewModel.fetchData()
            }
        })

        mainViewModel.list.observe(this,{
            if(it.isNotEmpty()) {
                progressBar.visibility = View.INVISIBLE
            }
            (recyclerView.adapter as MyAdapter).setDataInAdapter(it)
        })

        Log.d("debug","starting fetch function")
        mainViewModel.fetchData()
        Log.d("debug","fetch function complete")

        val button = view.findViewById<Button>(R.id.retry)
        button.setOnClickListener {
            mainViewModel.fetchData()
        }
    }
}