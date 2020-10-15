package com.example.databaseassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DatabaseAdapter(private val list: ArrayList<String>) :
    RecyclerView.Adapter<DatabaseAdapter.WordViewHolder>() {

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemText: TextView = itemView.findViewById(R.id.item_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.itemText.text = list[position]
    }

    override fun getItemCount(): Int = list.size
}