package com.kotlin.example.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.kotlin.example.mvvm.model.Note
import com.kotlin.example.mvvm.model.NotesRepository

class NoteViewModel() : ViewModel() {

    private var pendingNote: Note? = null

    fun saveChanges(note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        pendingNote?.let {
            NotesRepository.saveNote(it)
        }
    }
}