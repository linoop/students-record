package com.linoop.studentsrecord.domain

import com.linoop.studentsrecord.domain.model.StudentRecord

interface Repository {
    suspend fun saveStudentData(studentRecord: StudentRecord)

    suspend fun getAllStudents(): List<StudentRecord>
}