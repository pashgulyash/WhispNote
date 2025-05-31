package com.pashgulyash.whispnote.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pashgulyash.whispnote.databinding.ItemNoteBinding
import com.pashgulyash.whispnote.model.Note

class NoteAdapter(
    private var notes: List<Note>,
    private val onNoteClick: (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    fun updateList(newList: List<Note>) {
        notes = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNoteBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.binding.tvTitle.text = note.title
        holder.binding.tvDate.text = note.createdAt
        holder.binding.root.setOnClickListener { onNoteClick(note) }
    }

    override fun getItemCount() = notes.size
}
