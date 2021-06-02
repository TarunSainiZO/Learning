package com.win95.samplerecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val textView : TextView = findViewById(R.id.textView)
        val bundle :Bundle ?=intent.extras
        if (bundle!=null){
            val message = bundle.getString("message") // 1
            textView.text = message
        }
    }
}