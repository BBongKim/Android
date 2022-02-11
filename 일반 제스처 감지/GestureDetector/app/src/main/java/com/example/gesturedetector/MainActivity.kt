package com.example.gesturedetector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import com.example.gesturedetector.databinding.ActivityMainBinding


// GestureListener를 구현하는 별도의 클래스를 만들 수 있지만, 그냥 바로 implement 하는 것이 더 편리한 것 같다.

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var gd: GestureDetectorCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gd = GestureDetectorCompat(this, this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gd.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onDown(p0: MotionEvent?): Boolean {
        binding.status.text = "onDown"
        return true
    }

    override fun onShowPress(p0: MotionEvent?) {
        binding.status.text = "onShowPress"
    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        binding.status.text = "onSingleTapUp"
        return true
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        binding.status.text = "onScroll"
        return true
    }

    override fun onLongPress(p0: MotionEvent?) {
        binding.status.text = "onLongPress"
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        binding.status.text = "onFling"
        return true
    }

    override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
        binding.status.text = "onSingleTapConfirmed"
        return true
    }

    override fun onDoubleTap(p0: MotionEvent?): Boolean {
        binding.status.text = "onDoubleTap"
        return true
    }

    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
        binding.status.text = "onDoubleTapEvent"
        return true
    }
}