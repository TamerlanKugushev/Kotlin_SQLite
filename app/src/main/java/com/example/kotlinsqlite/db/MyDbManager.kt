package com.example.kotlinsqlite.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDbManager(val context: Context) {
    val myDbHelper = MyDbHelper(context)
    var dataBase: SQLiteDatabase? = null


    fun openDB() {
        dataBase = myDbHelper.writableDatabase
    }

    fun insertToDatabase(title: String, content: String) {
        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_TITLE, title)
            put(MyDbNameClass.COLUMN_NAME_CONTENT, content)
        }
        dataBase?.insert(MyDbNameClass.TABLE_NAME, null, values)
    }

    fun readDatabaseData(): ArrayList<String> {
        val dataList = ArrayList<String>()
        val cursor = dataBase?.query(
            MyDbNameClass.TABLE_NAME,
            null, null, null, null, null, null
        )
        with(cursor) {
            while (this?.moveToNext()!!) {
                val dataText =
                    cursor?.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_TITLE))
                dataList.add(dataText.toString())
            }
        }
        cursor?.close()
        return dataList
    }

    fun closeDatabase(){
        myDbHelper.close()
    }

}