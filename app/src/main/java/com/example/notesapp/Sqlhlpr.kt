package com.example.notesapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Sqlhlpr(context: Context?) : SQLiteOpenHelper(context, "details.db", null , 1)
{
    var sqLite: SQLiteDatabase = writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table notes (Note text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    fun savedata(s1: String) {
        val cv = ContentValues()
        cv.put("Note", s1)
        sqLite.insert("notes", null, cv)
        //var status = sqLite.insert("students", null, cv)
        //return status

    }
}