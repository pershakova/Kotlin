package com.kotlin.example.mvvm.viewmodel

class SplashViewState(authenticated: Boolean? = null, error: Throwable? = null): BaseViewState<Boolean?>(authenticated, error)