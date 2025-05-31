package com.pashgulyash.whispnote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pashgulyash.whispnote.databinding.ActivityNoteEditorBinding

class NoteEditorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteEditorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteEditorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
