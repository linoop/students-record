package com.linoop.studentsrecord.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.linoop.studentsrecord.domain.model.StudentRecord

@Composable
fun StudentList(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
    navController: NavHostController
) {
    val students by viewModel.studentsRecords.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getAllStudents()
    }

    Column {
        Text(
            text = "Students List",
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        LazyColumn {
            items(students.size) { index ->
                val student = students[index]
                StudentRecordItem(studentRecord = student)
            }
        }
    }

}

@Composable
fun StudentRecordItem(modifier: Modifier = Modifier, studentRecord: StudentRecord) {
    Card(
        modifier = modifier.fillMaxWidth().padding(10.dp),
        shape = RoundedCornerShape(20.dp)
    ){
            Column(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
                Text(text = "Student Name: ${studentRecord.name}")
                Text(text = "Age: ${studentRecord.email}")
                Text(text = "Grade: ${studentRecord.rollNumber}")
                Text(text = "Email: ${studentRecord.department}")
            }
        }

}