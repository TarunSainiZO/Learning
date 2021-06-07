package com.win95.recyclerview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.win95.recyclerview.R
import com.win95.recyclerview.activities.Second
import com.win95.recyclerview.viewmodel.UserData


class MyAdapter(var data : List<UserData>, val context : Context): RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    class ViewHolder(view :View):RecyclerView.ViewHolder(view){
        val id : TextView
        val login : TextView
        val imageView : ImageView
        init {
            id = view.findViewById(R.id.id)
            login = view.findViewById(R.id.login)
            imageView = view.findViewById(R.id.imageView)
        }
    }
    fun setDataInAdapter(data : List<UserData>){
        this.data = arrayListOf()
        for(i in data){
            (this.data as ArrayList<UserData>).add(i)
        }
        this.notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = data[position].id.toString()
        holder.login.text = data[position].login
        Glide.with(holder.imageView.context).load(data[position].avatarUrl).into(holder.imageView);
        holder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                holder.login.text,
                Toast.LENGTH_SHORT
            ).show()
            val context=holder.login.context
            val intent = Intent( context, Second::class.java)
            intent.putExtra("message",holder.login.text)
            intent.putExtra("image",data[position].avatarUrl)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

}

