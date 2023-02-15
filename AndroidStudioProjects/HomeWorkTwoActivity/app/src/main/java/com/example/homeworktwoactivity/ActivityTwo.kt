package com.example.homeworktwoactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView


class ActivityTwo : AppCompatActivity() {
    private val tagLog = "LogActivityTwo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        val numberView2 = findViewById<TextView>(R.id.numberViewTwo)
        numberView2.text = (number * number).toString()

        Log.d(tagLog, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(tagLog, "onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d(tagLog, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tagLog, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tagLog, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tagLog, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tagLog, "onDestroy")
    }

    fun onClickGoActivityOne(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}