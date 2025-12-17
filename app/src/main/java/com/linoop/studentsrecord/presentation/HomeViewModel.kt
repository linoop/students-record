package com.linoop.studentsrecord.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linoop.studentsrecord.domain.GetAllStudentsUseCase
import com.linoop.studentsrecord.domain.SaveStudentDataUseCase
import com.linoop.studentsrecord.domain.model.StudentRecord
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val saveStudentDataUseCase: SaveStudentDataUseCase,
    private val getAllStudentsUseCase: GetAllStudentsUseCase
): ViewModel() {

    val showSuccessDialog = MutableStateFlow(false)

    private val _studentsRecords: MutableStateFlow<List<StudentRecord>> = MutableStateFlow(emptyList())
    val studentsRecords: StateFlow<List<StudentRecord>> = _studentsRecords

    fun saveStudentData(studentRecord: StudentRecord) {
        viewModelScope.launch {
            saveStudentDataUseCase.invoke(studentRecord)
            showSuccessDialog.value = true
        }
    }

    fun getAllStudents(){
        viewModelScope.launch {
            _studentsRecords.value = getAllStudentsUseCase.invoke()
        }
    }
}