package com.linoop.studentsrecord.data.repository

import com.linoop.studentsrecord.data.local.dao.StudentDao
import com.linoop.studentsrecord.data.mapper.toDataModel
import com.linoop.studentsrecord.data.mapper.toDomainModel
import com.linoop.studentsrecord.domain.Repository
import com.linoop.studentsrecord.domain.model.StudentRecord
import jakarta.inject.Inject

class RepositoryImpl @Inject constructor(val studentDao: StudentDao): Repository {
    override suspend fun saveStudentData(studentRecord: StudentRecord) {
        studentDao.saveStudentData(studentRecord.toDataModel())
    }

    override suspend fun getAllStudents(): List<StudentRecord> {
      return  studentDao.selectAllStudents().map { it.toDomainModel() }
    }
}