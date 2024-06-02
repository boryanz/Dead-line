package com.boryans.deadline.ui.screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.boryans.deadline.navigation.Route

fun NavGraphBuilder.addDeadlineScreen() {
  composable<Route.AddDeadline> {  }
}

fun NavController.navigateToAddDeadlineScreen() {
  navigate(route = Route.AddDeadline)
}