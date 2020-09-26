package com.kotlin.example.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.core.content.res.ResourcesCompat
import org.koin.android.viewmodel.ext.android.viewModel
import com.kotlin.example.R
import com.kotlin.example.mvvm.model.Note
import com.kotlin.example.mvvm.viewmodel.NoteViewModel
import com.kotlin.example.mvvm.viewmodel.NoteViewState
import kotlinx.android.synthetic.main.activity_note.*
import java.text.SimpleDateFormat
import java.util.*

class NoteActivity : BaseActivity<Note?, NoteViewState>() {
    companion object {
        private const val NOTE_KEY = "note"
        private const val DATE_FORMAT = "dd.MM.yy HH:mm"

        fun start(context: Context, noteId: String? = null) = Intent(context, NoteActivity::class.java).apply {
            putExtra(NOTE_KEY, noteId)
            context.startActivity(this)
        }
    }

    override val layoutRes: Int = R.layout.activity_note
    private var note: Note? = null
    override val viewModel: NoteViewModel by viewModel()

    val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            saveNote()
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val noteId = intent.getStringExtra(NOTE_KEY)

        noteId?.let {
            viewModel.loadNote(it)
        } ?: let {
            supportActionBar?.title =  getString(R.string.new_note)
            initView()
        }
    }

    override fun renderData(data: Note?) {
        this.note = data
        supportActionBar?.title = note?.let {
            SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(it.lastChanged)
        } ?: getString(R.string.new_note)
        initView()
    }

    private fun initView() {
        titleEt.removeTextChangedListener(textWatcher)
        bodyEt.removeTextChangedListener(textWatcher)

        note?.let {
            titleEt.setTextKeepState(it.title)
            bodyEt.setTextKeepState(it.note)
            val color = when (it.color) {
                Note.Color.WHITE -> R.color.white
                Note.Color.VIOLET -> R.color.violet
                Note.Color.YELLOW -> R.color.yellow
                Note.Color.RED -> R.color.red
                Note.Color.PINK -> R.color.pink
                Note.Color.GREEN -> R.color.green
            }
            toolbar.setBackgroundColor(ResourcesCompat.getColor(resources, color, null))
        }

        titleEt.addTextChangedListener(textWatcher)
        bodyEt.addTextChangedListener(textWatcher)
    }

    private fun saveNote() {
        titleEt.text?.let {
            if (it.length < 3) return
        } ?: return

        note = note?.copy(
            title = titleEt.text.toString(),
            note = bodyEt.text.toString(),
            lastChanged = Date()
        ) ?: Note(UUID.randomUUID().toString(), titleEt.text.toString(), bodyEt.text.toString())

        note?.let { viewModel.save(it) }

    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

}