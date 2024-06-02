package com.boryans.deadline.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.boryans.deadline.ui.screen.addDeadlineScreen
import com.boryans.deadline.ui.screen.deadlineDetailsScreen
import com.boryans.deadline.ui.screen.homeScreen
import com.boryans.deadline.ui.screen.navigateToAddDeadlineScreen
import com.boryans.deadline.ui.screen.navigateToDeadlineDetails

@Composable
fun DeadlineNavigationGraph(
  navController: NavHostController = rememberNavController(),
) {
  NavHost(navController = navController, startDestination = Route.Home) {
    homeScreen(
      onNavigateToAddDeadline = { navController.navigateToAddDeadlineScreen() },
      onNavigateToDeadlineDetails = {navController.navigateToDeadlineDetails("12")}
    )
    addDeadlineScreen()
    deadlineDetailsScreen()
  }
}