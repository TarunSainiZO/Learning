package com.win95.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(list : List<UserData>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val data : List<UserData>
    init{
        var idx = 1
        for(i in list){
            println("$idx in adapter ${i.login}")
            idx+=1
        }
        data = list
        println(data.toString())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.user,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvEmail.text = (data[position].login)
        holder.tvName.text = (data[position].type)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var tvName: TextView
        var tvEmail: TextView
        var ivUserImage : ImageView
        init{
            tvName = itemView.findViewById(R.id.name)
            tvEmail = itemView.findViewById(R.id.email)
            ivUserImage = itemView.findViewById(R.id.image)
        }
    }
}
