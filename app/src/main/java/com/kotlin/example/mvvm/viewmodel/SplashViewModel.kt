package com.kotlin.example.mvvm.viewmodel

import com.kotlin.example.mvvm.model.NoAuthException
import com.kotlin.example.mvvm.model.NotesRepository

class SplashViewModel() : BaseViewModel<Boolean?, SplashViewState>() {

    fun requestUser(){
        NotesRepository.getCurrentUser().observeForever {
            viewStateLiveData.value = if(it != null){
                SplashViewState(authenticated = true)
            } else {
                SplashViewState(error = NoAuthException())
            }
        }
    }
}