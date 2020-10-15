package com.example.databaseassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SQLiteActivity : AppCompatActivity(){
    private lateinit var word_et : EditText
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        word_et = findViewById(R.id.sql_word_et)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    fun sqlOnClick(view : View){
        val sql_database = SQLiteDBhandler(this@SQLiteActivity)
        when(view.id){
            R.id.sql_insert_bttn -> sql_database.insertData(word_et.text.toString())
            R.id.sql_display_bttn -> {
                val data = sql_database.readData()
                recyclerView.adapter = DatabaseAdapter(data)
            }
        }
    }
}