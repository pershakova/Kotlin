package com.kotlin.example.mvvm.model

import com.kotlin.example.mvvm.provider.DataProvider

class NotesRepository(val dataProvider: DataProvider)  {
    fun getCurrentUser() = dataProvider.getCurrentUser()
    fun getNotes() = dataProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = dataProvider.saveNote(note)
    fun getNoteById(id: String) = dataProvider.getNoteById(id)
    fun deleteNote(id: String) = dataProvider.deleteNote(id)
}