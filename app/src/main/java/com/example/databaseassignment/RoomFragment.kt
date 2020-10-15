package com.example.databaseassignment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.fragment_room.*

class RoomFragment : Fragment(R.layout.fragment_room) {

    private lateinit var wordDatabase: WordDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wordDatabase =
            Room.databaseBuilder(view.context, WordDatabase::class.java, "roomDatabase").build()
        room_recyclerview.layoutManager = LinearLayoutManager(view.context)

        room_insert_bttn.setOnClickListener {
            insertData(Word(room_word_et.text.toString()))
        }
        room_display_bttn.setOnClickListener {
            readData(view.context)
        }
    }

    fun insertData(item: Word) {
        Thread {
            wordDatabase.wordDao().insertWord(item)
        }.start()
    }

    fun readData(context: Context) {
        val list: ArrayList<Word> = ArrayList()
        Thread {
            list.addAll(wordDatabase.wordDao().readAll())
            room_recyclerview.post {
                if (list.isEmpty()) Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show()
                else {
                    val uiList: ArrayList<String> = ArrayList()
                    list.forEach { uiList.add(it.word) }
                    room_recyclerview.adapter = DatabaseAdapter(uiList)
                }
            }
        }.start()
    }
}