package com.example.habitstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

val dataBase : DataHabits = DataHabits()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onClickAddHabits(view: View) {
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    }
}