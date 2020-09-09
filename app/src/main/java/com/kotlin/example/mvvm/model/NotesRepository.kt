package com.kotlin.example.mvvm.model

import com.kotlin.example.R
import com.kotlin.example.common.Shared

object NotesRepository {

    var note_titles: Array<String> = Shared.context!!.resources.getStringArray(R.array.note_titles)
    var note_texts: Array<String> = Shared.context!!.resources.getStringArray(R.array.note_texts)

    private val notes: List<Note> = listOf(
        Note(
            note_titles[0],
            note_texts[0],
            0xfff06292.toInt()
        ),
        Note(
            note_titles[1],
            note_texts[1],
            0xff9575cd.toInt()
        ),
        Note(
            note_titles[2],
            note_texts[3],
            0xff64b5f6.toInt()
        ),
        Note(
            note_titles[3],
            note_texts[3],
            0xff4db6ac.toInt()
        ),
        Note(
            note_titles[4],
            note_texts[4],
            0xffb2ff59.toInt()
        ),
        Note(
            note_titles[5],
            note_texts[5],
            0xffffeb3b.toInt()
        )
    )

    fun getNotes(): List<Note> {
        return notes
    }
}