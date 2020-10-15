package com.example.databaseassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DatabaseAdapter(val list: ArrayList<String>) :
    RecyclerView.Adapter<DatabaseAdapter.Viewholder>() {

    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item_text = itemView.findViewById<TextView>(R.id.item_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.item_text.text = list[position]
    }

    override fun getItemCount(): Int = list.size
}