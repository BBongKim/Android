package com.example.pinchgesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import com.example.pinchgesture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sgd: ScaleGestureDetector

    inner class MyOnScaleGestureListener : ScaleGestureDetector.OnScaleGestureListener {
        override fun onScale(p0: ScaleGestureDetector): Boolean {
            var scaleFactor = p0.scaleFactor

            if (scaleFactor > 1) binding.textView.text = "줌 아웃"
            else binding.textView.text = "줌 인"

            return true
        }

        override fun onScaleBegin(p0: ScaleGestureDetector): Boolean { return true }
        override fun onScaleEnd(p0: ScaleGestureDetector) {}

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sgd = ScaleGestureDetector(this, MyOnScaleGestureListener())
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        sgd.onTouchEvent(event)
        return super.onTouchEvent(event)
    }
}