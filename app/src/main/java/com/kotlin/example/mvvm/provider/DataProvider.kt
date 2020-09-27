package com.kotlin.example.mvvm.provider

import androidx.lifecycle.LiveData
import com.kotlin.example.mvvm.model.Note
import com.kotlin.example.mvvm.model.NoteResult
import com.kotlin.example.mvvm.model.User

interface DataProvider {
    fun getCurrentUser() : LiveData<User?>
    fun subscribeToAllNotes() : LiveData<NoteResult>
    fun saveNote(note: Note) : LiveData<NoteResult>
    fun getNoteById(id: String) : LiveData<NoteResult>
    fun deleteNote(id: String) : LiveData<NoteResult>
}