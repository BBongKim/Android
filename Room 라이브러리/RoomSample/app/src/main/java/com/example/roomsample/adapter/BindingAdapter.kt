package com.example.roomsample.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomsample.entity.Diary

object BindingAdapter {

    @BindingAdapter("setDiaries")
    @JvmStatic
    fun setDiaries(view: RecyclerView, diaries: List<Diary>?) {
        if (view.adapter == null) {
            view.adapter = DiaryRecyclerAdapter()
        }

        diaries?.let {
            val adapter = view.adapter as DiaryRecyclerAdapter
            adapter.setDiaries(it)
        }
    }
}