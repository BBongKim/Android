package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        val c = findViewById<CheckBoxView>(R.id.checkBoxView1)
        Log.d("TEST", c.getText() + " " + c.isChecked().toString())
    }
}