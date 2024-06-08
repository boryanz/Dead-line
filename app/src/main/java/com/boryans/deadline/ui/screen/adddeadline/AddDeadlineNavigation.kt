package com.boryans.deadline.ui.screen.adddeadline

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.boryans.deadline.navigation.Route
import com.boryans.deadline.ui.screenScopedViewModel

fun NavGraphBuilder.addDeadlineScreen() {
  composable<Route.AddDeadline> {
    val viewModel: AddDeadlineViewModel = screenScopedViewModel()
    val uiState = viewModel.getUiState()

    AddDeadlineScreen(
      uiState = uiState,
      onTitleInput = { viewModel.onEvent(AddDeadlineEvent.AddTitle(it)) },
      onDateInput = { viewModel.onEvent(AddDeadlineEvent.AddDate(it)) },
      onDescriptionInput = { viewModel.onEvent(AddDeadlineEvent.AddDescription(it)) },
      onAddDeadlineClicked = { viewModel.onEvent(AddDeadlineEvent.AddDeadline) },
    )
  }
}

fun NavController.navigateToAddDeadlineScreen() {
  navigate(route = Route.AddDeadline)
}