package com.example.databaseassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var sqlite_bttn : Button
    private lateinit var room_bttn : Button
    private val sqlFragment = SQLiteFragment()
    private val roomFragment = RoomFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sqlite_bttn = findViewById(R.id.sqlite_bttn)
        room_bttn = findViewById(R.id.room_bttn)

    }

    fun onClick(view : View){
        when(view.id){
            R.id.sqlite_bttn ->{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.database_frame, sqlFragment)
                    commit()
                }
            }
            R.id.room_bttn ->{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.database_frame, roomFragment)
                    commit()
                }
            }
        }
    }
}