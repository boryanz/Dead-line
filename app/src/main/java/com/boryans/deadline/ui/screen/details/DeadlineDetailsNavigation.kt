package com.boryans.deadline.ui.screen.details

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.boryans.deadline.domain.GetDeadlineUseCase
import com.boryans.deadline.navigation.Route
import com.boryans.deadline.ui.screenScopedViewModel

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.deadlineDetailsScreen() {
  composable<Route.DeadlineDetails> {
    val args = it.toRoute<Route.DeadlineDetails>()
    val viewModel: DeadlineDetailsViewModel = screenScopedViewModel(
      factory = DeadlineDetailsViewModelFactory(
        getDeadlineUseCase = GetDeadlineUseCase(),
        deadlineId = args.deadlineId
      )
    )
    val uiState = viewModel.getUiState()

    DeadlineDetailsScreen(
      uiState = uiState
    )
  }
}

fun NavHostController.navigateToDeadlineDetails(deadlineId: String) {
  navigate(route = Route.DeadlineDetails(deadlineId = deadlineId))
}
