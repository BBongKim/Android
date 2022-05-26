package com.example.roomsample.viewmodel

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.example.roomsample.database.DiaryDatabase
import com.example.roomsample.entity.Diary
import com.example.roomsample.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// ViewModel에서 Application의 context를 이용하기 위해선 AndroidViewModel를 상속받으면 된다.
// 주의할 점은, ViewModel에서 Acivity나 Fragment등의 view의 context를 참조하고 있으면 메모리 leak을 유발할 수 있다.

class DiaryViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: Repository
    val diaryList: LiveData<List<Diary>>?

    init {
        repository = Repository(application)
        diaryList = repository.diaryList
    }

    fun insert(diary: Diary) {
        repository.insert(diary)
    }
}