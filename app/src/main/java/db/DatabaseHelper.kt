package com.pashgulyash.whispnote.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.pashgulyash.whispnote.model.Note

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "notes.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE notes (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT,
                content TEXT,
                created_at TEXT DEFAULT (datetime('now'))
        """)
    }

    fun addNote(title: String, content: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("title", title)
            put("content", content)
        }
        return db.insert("notes", null, values)
    }

    fun getAllNotes(): List<Note> {
        val notes = mutableListOf<Note>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM notes ORDER BY created_at DESC", null)
        
        while (cursor.moveToNext()) {
            notes.add(Note(
                id = cursor.getLong(0),
                title = cursor.getString(1),
                content = cursor.getString(2),
                createdAt = cursor.getString(3)
            )
        }
        cursor.close()
        return notes
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS notes")
        onCreate(db)
    }
                      }
