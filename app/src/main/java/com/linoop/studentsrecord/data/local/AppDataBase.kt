package com.linoop.studentsrecord.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.linoop.studentsrecord.data.local.dao.StudentDao
import com.linoop.studentsrecord.data.local.entity.Student

@Database(entities = [Student::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun studentDao(): StudentDao
}