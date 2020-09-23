package com.kotlin.example.ui

import android.app.Application
import com.kotlin.example.di.appModule
import com.kotlin.example.di.mainModule
import com.kotlin.example.di.noteModule
import com.kotlin.example.di.splashModule
import org.koin.android.ext.android.startKoin

class App: Application() {

    companion object {
        lateinit var instance : App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin(this, listOf(appModule, splashModule, mainModule, noteModule))
    }
}