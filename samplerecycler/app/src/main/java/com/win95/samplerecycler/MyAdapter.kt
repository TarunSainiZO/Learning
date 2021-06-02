package com.win95.samplerecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.content.Intent
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(private val dataSet: Array<String>, private val context : Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        init {
            textView = view.findViewById(R.id.textView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position]
        viewHolder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                viewHolder.textView.text,
                Toast.LENGTH_SHORT
            ).show()
            val context=viewHolder.textView.context
            val intent = Intent( context, Second::class.java)
            intent.putExtra("message",viewHolder.textView.text)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return dataSet.size
    }
}