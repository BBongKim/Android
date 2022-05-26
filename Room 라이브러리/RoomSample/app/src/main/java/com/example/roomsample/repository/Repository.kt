package com.example.roomsample.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roomsample.dao.DiaryDao
import com.example.roomsample.database.DiaryDatabase
import com.example.roomsample.entity.Diary
import kotlinx.coroutines.*

class Repository(application: Application) {
    private var diaryDao: DiaryDao
    var diaryList: LiveData<List<Diary>>?

    init {
        val db = DiaryDatabase.getInstance(application.applicationContext)
        diaryDao = db!!.diaryDao()
        // Room에서 반환받은 LiveData를 참조해놓으면, 업데이트 관찰 가능
        diaryList = diaryDao.getAllDiaries()
    }

    fun insert(diary: Diary) {
        CoroutineScope(Dispatchers.IO).launch {
            diaryDao.insert(diary)
        }
    }

    fun delete(diary: Diary) {
        CoroutineScope(Dispatchers.IO).launch {
            diaryDao.delete(diary)
        }
    }

    fun update(diary: Diary) {
        CoroutineScope(Dispatchers.IO).launch {
            diaryDao.update(diary)
        }

    }

    suspend fun getFirstDiary(): Diary {
        return CoroutineScope(Dispatchers.IO).async {
            diaryDao.getFirstDiary()
        }.await()
    }
}