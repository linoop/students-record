package com.linoop.studentsrecord.domain

import javax.inject.Inject

class GetAllStudentsUseCase @Inject constructor(val repository: Repository) {
    suspend operator fun invoke() = repository.getAllStudents()
}