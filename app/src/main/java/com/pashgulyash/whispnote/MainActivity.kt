package com.pashgulyash.whispnote

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pashgulyash.whispnote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddNote.setOnClickListener {
            startActivity(Intent(this, NoteEditorActivity::class.java))
        }
    }
}

    private fun setupRecyclerView() {
        adapter = NoteAdapter(emptyList()) { note ->
            val intent = Intent(this, NoteEditorActivity::class.java).apply {
                putExtra("NOTE_ID", note.id)
            }
            startActivity(intent)
        }
        
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.updateList(dbHelper.getAllNotes())
        binding.emptyState.root.visibility = 
            if (adapter.itemCount == 0) View.VISIBLE else View.GONE
    }
}
