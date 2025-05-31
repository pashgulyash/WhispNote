package com.pashgulyash.whispnote

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pashgulyash.whispnote.databinding.ActivityMainBinding
import com.pashgulyash.whispnote.db.DatabaseHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        dbHelper = DatabaseHelper(this)

        binding.btnAddNote.setOnClickListener {
            startActivity(Intent(this, NoteEditorActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        updateNoteList()
    }

    private fun updateNoteList() {
        val notes = dbHelper.getAllNotes()
        if (notes.isNotEmpty()) {
            binding.emptyState.visibility = View.GONE
            // Здесь будет RecyclerView
        } else {
            binding.emptyState.visibility = View.VISIBLE
        }
    }
}
