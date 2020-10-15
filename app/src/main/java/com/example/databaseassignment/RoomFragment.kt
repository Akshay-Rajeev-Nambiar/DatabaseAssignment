package com.example.databaseassignment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.android.synthetic.main.fragment_room.*

class RoomFragment : Fragment(R.layout.fragment_room) {
    private lateinit var room_et: EditText
    private lateinit var room_recycler : RecyclerView
    private lateinit var database: WordDatabase
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        room_et = view.findViewById(R.id.room_word_et)
        room_recycler = view.findViewById(R.id.room_recyclerview)

        database = Room.databaseBuilder(view.context, WordDatabase::class.java,"roomDatabase").build()
        room_recycler.layoutManager = LinearLayoutManager(view.context)

        room_insert_bttn.setOnClickListener {
            insertData(Word(room_et.text.toString()))
        }
        room_display_bttn.setOnClickListener {
            readData(view.context)
        }
    }

    fun insertData(item: Word){
        Thread{
            database.wordDao().insertWord(item)
        }.start()
    }
    fun readData(context : Context){
        val list : ArrayList<Word> = ArrayList()
        Thread{
            list.addAll(database.wordDao().readAll())
            room_recycler.post {
                if (list.isEmpty()) Toast.makeText(context,"Empty", Toast.LENGTH_SHORT).show()
                else{
                    val uiList : ArrayList<String> = ArrayList()
                    list.forEach { uiList.add(it.word) }
                    room_recycler.adapter = DatabaseAdapter(uiList)
                }
            }
        }.start()
    }
}