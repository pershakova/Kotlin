package com.kotlin.example.mvvm.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlin.example.mvvm.provider.DataProvider
import com.kotlin.example.mvvm.provider.FirestoreProvider
import java.util.*

object NotesRepository {

    private val dataProvider: DataProvider = FirestoreProvider()

    fun getNotes() = dataProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = dataProvider.saveNote(note)
    fun getNoteById(id: String) = dataProvider.getNoteById(id)

}