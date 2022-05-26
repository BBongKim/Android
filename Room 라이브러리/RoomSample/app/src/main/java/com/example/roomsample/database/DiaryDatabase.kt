package com.example.roomsample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomsample.dao.DiaryDao
import com.example.roomsample.entity.Diary

@Database(entities = [Diary::class], version = 1)
abstract class DiaryDatabase : RoomDatabase() {
    abstract fun diaryDao(): DiaryDao

    companion object {
        private var instance: DiaryDatabase? = null

        @Synchronized
        fun getInstance(context: Context): DiaryDatabase? {
            if (instance == null) {
                synchronized(DiaryDatabase::class) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context,
                            DiaryDatabase::class.java,
                            "database-diary"
                        ).build()
                    }
                }
            }
            return instance
        }
    }
}