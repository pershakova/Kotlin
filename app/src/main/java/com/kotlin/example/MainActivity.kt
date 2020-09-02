package com.kotlin.example

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getViewState().observe(this, Observer { value ->
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
        })

        val counter: LiveData<Int> = viewModel.getInitialCount()
        counter.observe(this, Observer {
            Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
        })

        val btnCount: Button = findViewById(R.id.button)
        btnCount.setOnClickListener {
            viewModel.getCurrentCount()
        }
    }
}