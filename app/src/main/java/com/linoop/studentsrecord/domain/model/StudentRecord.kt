package com.linoop.studentsrecord.domain.model

data class StudentRecord(
    val name: String,
    val rollNumber: String,
    val email: String,
    val phoneNumber: String,
    val department: String,
    val semester: String
)