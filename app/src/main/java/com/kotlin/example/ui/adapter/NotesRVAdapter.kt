package com.kotlin.example.ui.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.example.R
import kotlinx.android.synthetic.main.item_note.view.*
import com.kotlin.example.mvvm.model.Note
import com.kotlin.example.mvvm.model.Note.*

class NotesRVAdapter(val onItemClick: ((Note) -> Unit)? = null) : RecyclerView.Adapter<NotesRVAdapter.ViewHolder>() {

    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(notes[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(note: Note) = with(itemView as CardView) {
            tv_title.text = note.title
            tv_text.text = note.note

            val color = when(note.color){
                Color.WHITE -> R.color.white
                Color.VIOLET -> R.color.violet
                Color.YELLOW -> R.color.yellow
                Color.RED -> R.color.red
                Color.PINK -> R.color.pink
                Color.GREEN -> R.color.green
            }

            setCardBackgroundColor(ContextCompat.getColor(itemView.context, color))

            itemView.setOnClickListener{
                onItemClick?.invoke(note)
            }
        }
    }


}