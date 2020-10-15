package com.example.databaseassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var sqlite_bttn : Button
    private lateinit var room_bttn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sqlite_bttn = findViewById(R.id.sqlite_bttn)
        room_bttn = findViewById(R.id.room_bttn)
    }

    fun onClick(view : View){
        when(view.id){
            R.id.sqlite_bttn ->{
                val intentSqlite : Intent = Intent(this, SQLiteActivity::class.java)
                startActivity(intentSqlite)
            }
            R.id.room_bttn ->{
                val intentRoom : Intent = Intent(this, RoomActivity::class.java)
                startActivity(intentRoom)
            }
        }
    }
}