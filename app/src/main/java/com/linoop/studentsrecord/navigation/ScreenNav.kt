package com.linoop.studentsrecord.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.linoop.studentsrecord.presentation.HomePage
import com.linoop.studentsrecord.presentation.HomeViewModel
import com.linoop.studentsrecord.presentation.StudentList

sealed class Screen(val route: String) {
    object AddStudent : Screen("AddStudent")
    object StudentList: Screen("StudentList")
}

@Composable
fun ScreenNavigation(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.AddStudent.route
    ) {
        composable(Screen.AddStudent.route) {
            HomePage(
                modifier = modifier,
                viewModel = hiltViewModel<HomeViewModel>(),
                navController
            )
        }

        composable(route = Screen.StudentList.route) {
            StudentList( modifier = modifier,
                viewModel = hiltViewModel<HomeViewModel>(),
                navController
            )
        }
    }
}