package com.boryans.deadline.ui.screen.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.boryans.deadline.navigation.Route
import com.boryans.deadline.ui.screenScopedViewModel

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.homeScreen(
  onNavigateToAddDeadline: () -> Unit,
  onNavigateToDeadlineDetails: (deadlineId: String) -> Unit,
) {
  composable<Route.Home> {
    val context = LocalContext.current
    val viewModel: HomeViewModel = screenScopedViewModel()
    val uiState = viewModel.getUiState()

    HomeScreen(
      uiState = uiState,
      onNavigateToAddDeadline = onNavigateToAddDeadline,
      onNavigateToDeadlineDetails = { onNavigateToDeadlineDetails(it) },
      onDeleteDeadline = { viewModel.onEvent(HomeUiEvent.DeadlineSwiped(it, context)) }
    )
  }
}