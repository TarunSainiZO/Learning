package com.win95.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(val data : List<UserData>, val context : Context): RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    class ViewHolder(view :View):RecyclerView.ViewHolder(view){
        val id : TextView
        val login : TextView
        init {
            id = view.findViewById(R.id.id)
            login = view.findViewById(R.id.login)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = data[position].id.toString()
        holder.login.text = data[position].login
        holder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                holder.login.text,
                Toast.LENGTH_SHORT
            ).show()
            val context=holder.login.context
            val intent = Intent( context, Second::class.java)
            intent.putExtra("message",holder.login.text)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

}

