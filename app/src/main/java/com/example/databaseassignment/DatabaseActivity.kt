package com.example.databaseassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class DatabaseActivity : AppCompatActivity() {

    private val sqlFragment = SQLiteFragment()
    private val roomFragment = RoomFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.sqlite_btn -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.database_frame, sqlFragment)
                    .commit()
            }
            R.id.room_btn -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.database_frame, roomFragment)
                    .commit()
            }
        }
    }
}
