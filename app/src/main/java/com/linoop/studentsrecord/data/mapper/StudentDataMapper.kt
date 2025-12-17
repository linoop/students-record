package com.linoop.studentsrecord.data.mapper

import com.linoop.studentsrecord.data.local.entity.Student
import com.linoop.studentsrecord.domain.model.StudentRecord

fun Student.toDomainModel() = StudentRecord(
    name = this.name,
    rollNumber = this.rollNumber,
    email = this.email,
    phoneNumber = this.phoneNumber?.drop(4)?.padStart(this.phoneNumber.length, '*') ?: "",
    department = this.department,
    semester = this.semester
)

fun StudentRecord.toDataModel() = Student(
    name = this.name,
    rollNumber = this.rollNumber,
    email = this.email,
    phoneNumber = this.phoneNumber,
    department = this.department,
    semester = this.semester
)