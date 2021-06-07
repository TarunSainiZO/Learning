package com.win95.recyclerview.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.win95.recyclerview.R

class Second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val textView : TextView = findViewById(R.id.textView)
        val imageView : ImageView = findViewById(R.id.imageView)
        val bundle :Bundle ?=intent.extras
        if (bundle!=null){
            val message = bundle.getString("message") // 1
            textView.text = message
            val url = bundle.getString("image")
            Glide.with(imageView.context).load(url).into(imageView);
        }
    }
}