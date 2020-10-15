package com.example.databaseassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class RoomActivity : AppCompatActivity() {
    private lateinit var room_et:EditText
    private lateinit var room_recycler : RecyclerView
    private lateinit var database: WordDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        room_et = findViewById(R.id.room_word_et)
        room_recycler = findViewById(R.id.room_recyclerview)

        database = Room.databaseBuilder(this, WordDatabase::class.java,"roomDatabase").build()
        room_recycler.layoutManager = LinearLayoutManager(this)
    }
    fun insertData(item: Word){
        Thread{
            database.wordDao().insertWord(item)
        }.start()
    }
    fun readData(){
        val list : ArrayList<Word> = ArrayList()
        Thread{
            list.addAll(database.wordDao().readAll())
            room_recycler.post {
                if (list.isEmpty()) Toast.makeText(this,"Empty",Toast.LENGTH_SHORT).show()
                else{
                    val uiList : ArrayList<String> = ArrayList()
                    list.forEach { uiList.add(it.word) }
                   room_recycler.adapter = DatabaseAdapter(uiList)
                }
            }
        }.start()
    }
    fun roomOnClick(view: View){
        when(view.id){
            R.id.room_insert_bttn ->     insertData(Word(room_et.text.toString()))
            R.id.room_display_bttn ->   readData()

        }
    }
}