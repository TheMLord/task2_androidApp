package com.example.homeworktwoactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

var number = -1

class MainActivity : AppCompatActivity() {

    private val tagLog = "LogActivityOne"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(tagLog, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        number += 1
        Log.d(tagLog, "onStart")

    }

    override fun onResume() {
        super.onResume()
        val numberView = findViewById<TextView>(R.id.numberView)
        numberView.text = number.toString()
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

    fun onClickGoActivityTwo(view: View) {
        val intent = Intent(this, ActivityTwo::class.java)
        startActivity(intent)
    }
}