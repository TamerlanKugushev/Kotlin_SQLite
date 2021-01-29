package com.example.kotlinsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.kotlinsqlite.db.MyDbManager

class MainActivity : AppCompatActivity() {
    val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDB()

    }

    fun onClickNew(view: View) {

    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDatabase()
    }
}


