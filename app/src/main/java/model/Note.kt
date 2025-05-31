package com.pashgulyash.whispnote.model

data class Note(
    val id: Long = 0,
    val title: String,
    val content: String,
    val createdAt: String
)
