package com.kotlin.example.mvvm.viewmodel

import com.kotlin.example.mvvm.model.Note

class NoteViewState(note: Note? = null, error: Throwable? = null) : BaseViewState<Note?>(note, error)