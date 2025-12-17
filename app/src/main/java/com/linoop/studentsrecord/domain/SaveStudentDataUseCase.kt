package com.linoop.studentsrecord.domain

import com.linoop.studentsrecord.domain.model.StudentRecord
import javax.inject.Inject


class SaveStudentDataUseCase @Inject constructor(val repository: Repository) {
    suspend operator fun invoke(studentRecord: StudentRecord){
        repository.saveStudentData(studentRecord)
    }
}