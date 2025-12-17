package com.linoop.studentsrecord.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.linoop.studentsrecord.domain.model.StudentRecord
import com.linoop.studentsrecord.ui.theme.StudentsRecordTheme
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.linoop.studentsrecord.navigation.Screen

@Composable
fun HomePage(modifier: Modifier = Modifier, viewModel: HomeViewModel? = null, navController: NavController? = null) {
    Box(modifier = modifier.fillMaxSize()) {
        StudentRecordForm(navController) { studentRecord ->
            viewModel?.saveStudentData(studentRecord)
        }
        if (viewModel != null) {
            ShowSuccessDialog(viewModel = viewModel)
        }
    }
}

@Composable
fun ShowSuccessDialog(modifier: Modifier = Modifier, viewModel: HomeViewModel) {
    val showDialog by viewModel.showSuccessDialog.collectAsState()
    if(showDialog)
    AlertDialog(
        text = {
            Text("Student record saved successfully!")
        },
        onDismissRequest = { viewModel.showSuccessDialog.value = false },
        confirmButton = {
            Button(onClick = { viewModel.showSuccessDialog.value = false }) {
                Text("OK")
            }
        }
    )

}


@Composable
fun StudentRecordForm(
    modifier: NavController?,
    onSaveClick: (StudentRecord) -> Unit = {}
) {
    var name by remember { mutableStateOf("") }
    var rollNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var department by remember { mutableStateOf("") }
    var semester by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Student Record Form",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = rollNumber,
            onValueChange = { rollNumber = it },
            label = { Text("Roll Number") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Phone Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = department,
            onValueChange = { department = it },
            label = { Text("Department") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = semester,
            onValueChange = { semester = it },
            label = { Text("Semester") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val student = StudentRecord(
                    name = name,
                    rollNumber = rollNumber,
                    email = email,
                    phoneNumber = phoneNumber,
                    department = department,
                    semester = semester
                )
                onSaveClick(student)
                name = ""
                rollNumber = ""
                email = ""
                phoneNumber = ""
                department = ""
                semester = ""
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text("Save Student Record")
        }

        Button(onClick = {modifier?.navigate(Screen.StudentList.route)}) {
            Text("View Student Records")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePagePreview() {
    StudentsRecordTheme {
        HomePage()
    }
}
