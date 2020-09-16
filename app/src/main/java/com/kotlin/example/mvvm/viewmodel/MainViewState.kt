package com.kotlin.example.mvvm.viewmodel

import com.kotlin.example.mvvm.model.Note

class MainViewState(val notes: List<Note>? = null, error: Throwable? = null) : BaseViewState<List<Note>?>(notes, error)