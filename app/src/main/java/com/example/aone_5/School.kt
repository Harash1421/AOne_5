package com.example.aone_5

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class School(context:Context) : SQLiteOpenHelper(context, "marks.db", null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table marks (Name text, Phone text, Marks integer, Result text)")
        db?.execSQL("insert into marks values ('John Bravo', '5214874125', 85, 'Successful')")
        db?.execSQL("insert into marks values ('Mikel Kane', '4214587458', 78, 'Successful')")
        db?.execSQL("insert into marks values ('Harry Williams', '5214876254', 97, 'Successful')")
        db?.execSQL("insert into marks values ('Nicolo Suarez', '3254875421', 88, 'Successful')")
        db?.execSQL("insert into marks values ('Luis Bravo', '6154278412', 94, 'Successful')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

}