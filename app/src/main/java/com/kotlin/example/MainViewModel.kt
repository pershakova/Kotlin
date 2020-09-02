package com.kotlin.example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var counter: Counter = Counter()

    private val viewStateLiveData = MutableLiveData<String>()
    private val viewStateCounter = MutableLiveData<Int>()

    init {
        viewStateLiveData.value = "Hello!"
    }

    fun getInitialCount():MutableLiveData<Int> {
        viewStateCounter.value = counter.refreshData()
        return viewStateCounter
    }

    fun getViewState(): LiveData<String> = viewStateLiveData

    fun getCurrentCount(){
        viewStateCounter.value = counter.refreshData()
    }
}
