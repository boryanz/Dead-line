package com.boryans.deadline.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.boryans.deadline.ui.screen.adddeadline.addDeadlineScreen
import com.boryans.deadline.ui.screen.adddeadline.navigateToAddDeadlineScreen
import com.boryans.deadline.ui.screen.details.deadlineDetailsScreen
import com.boryans.deadline.ui.screen.details.navigateToDeadlineDetails
import com.boryans.deadline.ui.screen.home.homeScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DeadlineNavigationGraph(
  navController: NavHostController = rememberNavController(),
) {
  NavHost(navController = navController, startDestination = Route.Home) {
    homeScreen(
      onNavigateToAddDeadline = { navController.navigateToAddDeadlineScreen() },
      onNavigateToDeadlineDetails = { navController.navigateToDeadlineDetails(it) }
    )
    addDeadlineScreen()
    deadlineDetailsScreen()
  }
}