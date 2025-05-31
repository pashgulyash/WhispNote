package com.pashgulyash.whispnote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pashgulyash.whispnote.databinding.ActivityNoteEditorBinding
import com.pashgulyash.whispnote.db.DatabaseHelper

class NoteEditorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteEditorBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteEditorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        dbHelper = DatabaseHelper(this)
        
        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val content = binding.etContent.text.toString()
            if (title.isNotEmpty()) {
                dbHelper.addNote(title, content)
                finish()
            }
        }
    }
}
