package com.example.databaseassignment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SQLiteFragment : Fragment(R.layout.fragment_sqlite) {
    private lateinit var word_et : EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var insert_bttn : Button
    private lateinit var display_bttn : Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        word_et = view.findViewById(R.id.sql_word_et)
        recyclerView = view.findViewById(R.id.sql_recyclerview)
        insert_bttn = view.findViewById(R.id.sql_insert_bttn)
        display_bttn = view.findViewById(R.id.sql_display_bttn)
        val sql_database = SQLiteDBHandler(view.context)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        insert_bttn.setOnClickListener {
            sql_database.insertData(word_et.text.toString())
        }
        display_bttn.setOnClickListener {
            val data = sql_database.readData()
            recyclerView.adapter = DatabaseAdapter(data)
        }
    }
}
