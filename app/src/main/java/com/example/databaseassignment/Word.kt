package com.example.databaseassignment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "roomExample")
data class Word(
    @PrimaryKey @ColumnInfo(name = "word") val word: String
)

