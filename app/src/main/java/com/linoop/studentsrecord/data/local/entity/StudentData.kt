package com.linoop.studentsrecord.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val rollNumber: String,
    val email: String,
    val phoneNumber: String,
    val department: String,
    val semester: String
) {

}