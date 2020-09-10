package com.kotlin.example.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kotlin.example.R
import com.kotlin.example.common.DATE_TIME_FORMAT
import com.kotlin.example.mvvm.model.Color
import com.kotlin.example.mvvm.model.Note
import com.kotlin.example.mvvm.viewmodel.MainViewModel
import com.kotlin.example.mvvm.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_note.*
import java.text.SimpleDateFormat
import java.util.*

class NoteActivity : AppCompatActivity() {

    companion object {
        private val EXTRA_NOTE = NoteActivity::class.java.name + "extra.NOTE"

        fun start(context: Context, note: Note? = null) = Intent(context, NoteActivity::class.java).apply {
            putExtra(EXTRA_NOTE, note)
            context.startActivity(this)
            }
        }

    private var note: Note? = null
    lateinit var viewModel : NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        note = intent.getParcelableExtra(EXTRA_NOTE)

        //setSupportActionBar(toolbar) падает здесь, если не комментировать(
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        initView()
    }

    private fun initView() {
        if (note != null) {
            titleEt.setText(note?.title ?: "")
            bodyEt.setText(note?.note ?: "")
            val color = when(note!!.color) {
                Color.WHITE -> R.color.color_white
                Color.VIOLET -> R.color.color_violet
                Color.YELLOW -> R.color.color_yello
                Color.RED -> R.color.color_red
                Color.PINK -> R.color.color_pink
                Color.GREEN -> R.color.color_green
                Color.BLUE -> R.color.color_blue
            }

            toolbar.setBackgroundColor(resources.getColor(color))
        }

        titleEt.addTextChangedListener(textChangeListener)
        bodyEt.addTextChangedListener(textChangeListener)
    }

    private fun saveNote(){
        titleEt.text?.let {
        if (it.length<3){
            return
            }
            }?: return

        note = note?.copy(
            title = titleEt.text.toString(),
            note = bodyEt.text.toString(),
            lastChanged = Date()
        ) ?: Note(UUID.randomUUID().toString(), titleEt.text.toString(), bodyEt.text.toString())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private val textChangeListener = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            saveNote()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // not used
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // not used
        }
    }
}