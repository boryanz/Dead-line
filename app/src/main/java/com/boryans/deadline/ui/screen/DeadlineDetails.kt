package com.boryans.deadline.ui.screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.boryans.deadline.navigation.Route

fun NavGraphBuilder.deadlineDetailsScreen() {
  composable<Route.DeadlineDetails> { }
}

fun NavHostController.navigateToDeadlineDetails(deadlineId: String) {
  navigate(route = Route.DeadlineDetails(deadlineId = deadlineId))
}