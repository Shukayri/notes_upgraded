package com.example.notesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.edit_row.view.*

class MyAdapter(private val notes: ArrayList<String>) : RecyclerView.Adapter<MyAdapter.ItemViewHolder>(){
    class ItemViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.edit_row
                ,parent
                ,false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val note = notes[position]

        holder.itemView.apply{
            tv.text = note
        }
    }

    override fun getItemCount(): Int = notes.size

    fun update(){
        notifyDataSetChanged()
    }
}