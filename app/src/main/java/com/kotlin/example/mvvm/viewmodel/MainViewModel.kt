package com.kotlin.example.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.example.mvvm.model.NotesRepository

class MainViewModel() : ViewModel() {

    private val viewStateLiveData = MutableLiveData<MainViewState>()

    init {
        viewStateLiveData.value = MainViewState(NotesRepository.getNotes())
    }

    fun getViewState(): LiveData<MainViewState> = viewStateLiveData
}