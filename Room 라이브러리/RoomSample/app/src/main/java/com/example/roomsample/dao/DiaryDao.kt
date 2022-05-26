package com.example.roomsample.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomsample.entity.Diary

@Dao
interface DiaryDao {
    @Insert
    fun insert(diary: Diary)

    @Update
    fun update(diary: Diary)

    @Delete
    fun delete(diary: Diary)

    @Query("SELECT * FROM diary")
    fun getAllDiaries(): LiveData<List<Diary>>

    @Query("SELECT * FROM diary LIMIT 1")
    fun getFirstDiary(): Diary
}