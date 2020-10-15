package com.example.databaseassignment

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class SQLiteDBHandler(var context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "SQLExample.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "Something"
        private const val KEY_ID = "id"
        const val COL_WORD = "word"
        const val CREATE_TABLE_QUERY = "CREATE TABLE $TABLE_NAME (" +
                "$KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "$COL_WORD TEXT)"
        const val DROP_QUERY = "DROP TABLE IF EXISTS $TABLE_NAME"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_QUERY)
        onCreate(db)
    }

    fun insertData(word: String) {
        val database = this.writableDatabase
        val contentValues = ContentValues().apply { put(COL_WORD, word) }
        val result = database.insert(TABLE_NAME, null, contentValues)
        if (result == (0).toLong()) Toast.makeText(context, "Failed Insert", Toast.LENGTH_SHORT)
            .show()
        else Toast.makeText(context, "Inserted Successfully", Toast.LENGTH_SHORT).show()
    }

    fun readData(): ArrayList<String> {
        val database = this.readableDatabase
        val list = ArrayList<String>()
        val READ_QUERY = "SELECT * FROM $TABLE_NAME"
        val result = database.rawQuery(READ_QUERY, null)
        if (result.moveToFirst()) {
            do {
                val word = result.getString((result.getColumnIndex(COL_WORD)))
                list.add(word)
            } while (result.moveToNext())
        }
        return list
    }
}
