package com.linoop.studentsrecord.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.linoop.studentsrecord.data.local.entity.Student

@Dao
interface StudentDao {

    @Insert
    suspend fun saveStudentData(student: Student)

    @Delete
    suspend fun deleteStudentData(student: Student)

    @Query("SELECT * FROM student")
    suspend fun selectAllStudents(): List<Student>
}