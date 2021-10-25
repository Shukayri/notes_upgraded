package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var edNote: EditText
    lateinit var btn: Button
    lateinit var mainRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edNote = findViewById(R.id.editTextTextPersonName5)
        btn = findViewById(R.id.button3)
        val notes = ArrayList<String>()
        mainRv = findViewById(R.id.mainRv)
        mainRv.adapter = MyAdapter(notes)
        mainRv.layoutManager = LinearLayoutManager(this)

        btn.setOnClickListener {

            var note = edNote.text.toString()
            var sql = Sqlhlpr(this)
            sql.savedata(note)
            notes.add(note)
            Toast.makeText(this, "Note Added!", Toast.LENGTH_LONG).show()
            edNote.text.clear()
            mainRv.adapter?.notifyDataSetChanged()
            //MyAdapter.notifyDataSetChanged(); recyclerview.setAdapter(MyAdapter)
        }


    }
}