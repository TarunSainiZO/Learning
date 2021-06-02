package com.win95.samplerecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rcRows : RecyclerView = findViewById(R.id.rvRows)
        rcRows.layoutManager = LinearLayoutManager(applicationContext)
        val data :Array<String> = Array<String>(100){"$it hello"}
        rcRows.adapter = MyAdapter(data,this@MainActivity)
    }

}

