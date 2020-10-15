package com.example.databaseassignment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertWord(word : Word)

    @Query("SELECT * FROM roomExample")
    fun readAll() : List<Word>
}
