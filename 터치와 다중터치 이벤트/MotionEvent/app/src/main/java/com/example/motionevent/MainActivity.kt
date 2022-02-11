package com.example.motionevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.example.motionevent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityMain.setOnTouchListener {_, m ->
            handleTouch(m)
            true
        }
    }

    // 하나 이상의 터치가 동시 발생할 시 해당 터치를 Pointer라 한다.
    // 따라서, 2번째 이후의 Motion Event는 Pointer DOWN/UP이 출력된다.

    private fun handleTouch(m : MotionEvent) {
        val pointerCount = m.pointerCount
        for (i in 0 until pointerCount) {
            val x = m.getX(i)
            val y = m.getY(i)
            val id = m.getPointerId(i)
            val action = m.actionMasked
            val actionIndex = m.actionIndex
            val actionString: String

            actionString = when(action) {
                MotionEvent.ACTION_DOWN -> "DOWN"
                MotionEvent.ACTION_UP -> "UP"
                MotionEvent.ACTION_POINTER_DOWN -> "Pointer DOWN"
                MotionEvent.ACTION_POINTER_UP -> "Pointer UP"
                MotionEvent.ACTION_MOVE -> "Move"
                else -> ""
            }

            val status = "Action: $actionString, Index: $actionIndex, ID: $id, X: $x, Y: $y"

            if (i == 0) binding.textView2.text = status
            else binding.textView.text = status
        }
    }
}