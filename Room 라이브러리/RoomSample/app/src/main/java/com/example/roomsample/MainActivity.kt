package com.example.roomsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.roomsample.databinding.ActivityMainBinding
import com.example.roomsample.entity.Diary
import com.example.roomsample.viewmodel.DiaryViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: DiaryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // lifecycleOwner 지정 필수
        binding.lifecycleOwner = this
        setContentView(binding.root)

        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this)[DiaryViewModel::class.java]
        binding.viewModel = viewModel
        binding.activity = this
    }

    fun send() {
        val text = binding.editText.text.toString()

        if (text != "") {
            val diary = Diary(text)
            viewModel.insert(diary)
            binding.editText.text.clear()
        }
    }
}