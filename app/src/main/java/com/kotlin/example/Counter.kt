package com.kotlin.example

class Counter {
    private var counter: Int = 0

    fun refreshData() : Int {
        return counter++
    }
}