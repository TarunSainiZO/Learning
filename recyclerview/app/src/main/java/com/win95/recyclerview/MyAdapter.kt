package com.win95.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter() : RecyclerView.Adapter<ViewHolder>() {
    val list: MutableList<UserData>

    init {
        list = mutableListOf<UserData>()
    }

    fun setData(data: List<UserData>): Unit {
        list.clear()
        for (i in data) {
            list.add(i)
        }
        println(list.toString())
        this.notifyItemRangeInserted(0, list.size - 1);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvEmail.text = (list[position].login)
        holder.tvName.text = (list[position].type)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvName: TextView
    var tvEmail: TextView
    var ivUserImage: ImageView

    init {
        tvName = itemView.findViewById(R.id.name)
        tvEmail = itemView.findViewById(R.id.email)
        ivUserImage = itemView.findViewById(R.id.image)
    }
}