package com.kotlin.example.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.kotlin.example.mvvm.model.NotesRepository
import com.kotlin.example.mvvm.provider.DataProvider
import com.kotlin.example.mvvm.provider.FirestoreProvider
import com.kotlin.example.mvvm.viewmodel.MainViewModel
import com.kotlin.example.mvvm.viewmodel.NoteViewModel
import com.kotlin.example.mvvm.viewmodel.SplashViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single<DataProvider> { FirestoreProvider(get(), get()) }
    single { NotesRepository(get()) }
}

val splashModule = module {
    viewModel { SplashViewModel(get()) }
}

val mainModule = module {
    viewModel { MainViewModel(get()) }
}

val noteModule = module {
    viewModel { NoteViewModel(get()) }
}