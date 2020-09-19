package com.kotlin.example.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<T, S: BaseViewState<T>>: ViewModel() {
    open val viewStateLiveData = MutableLiveData<S>()
    open fun getViewState(): LiveData<S> = viewStateLiveData
}