package com.pashgulyash.whispnote

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pashgulyash.whispnote.databinding.ActivityMainBinding
import com.pashgulyash.whispnote.db.DatabaseHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dbHelper: DatabaseHelper
    
    companion object {
        private const val REQUEST_ADD_NOTE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        dbHelper = DatabaseHelper(this)

        binding.btnAddNote.setOnClickListener {
            startActivityForResult(
                Intent(this, NoteEditorActivity::class.java),
                REQUEST_ADD_NOTE
            )
        }
        updateNoteList()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ADD_NOTE && resultCode == RESULT_OK) {
            updateNoteList()
            Toast.makeText(this, "Заметка сохранена", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        updateNoteList()
    }

    private fun updateNoteList() {
        val notes = dbHelper.getAllNotes()
        binding.emptyState.visibility = if (notes.isEmpty()) View.VISIBLE else View.GONE
        Log.d("NOTES_DEBUG", "Заметок в базе: ${notes.size}")
    }
}
