package com.example.roomsample.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomsample.databinding.DiaryItemLayoutBinding
import com.example.roomsample.entity.Diary

class DiaryRecyclerAdapter : RecyclerView.Adapter<DiaryRecyclerAdapter.DiaryViewHolder>() {
    lateinit var binding: DiaryItemLayoutBinding
    private var diaryList: List<Diary>? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setDiaries(dairies: List<Diary>) {
        diaryList = dairies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryViewHolder {
        binding = DiaryItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        diaryList?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount(): Int {
        return diaryList?.size ?: 0
    }

    // getItemViewType을 오버라이드하면 스크롤해도 아이템이 섞이지 않는다.
    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class DiaryViewHolder(binding: DiaryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(diary: Diary) {
            binding.diary = diary
        }
    }
}