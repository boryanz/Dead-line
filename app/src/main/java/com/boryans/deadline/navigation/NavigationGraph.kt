package com.boryans.deadline.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.boryans.deadline.domain.GetDeadlineUseCase
import com.boryans.deadline.ui.screen.adddeadline.AddDeadlineEvent
import com.boryans.deadline.ui.screen.adddeadline.AddDeadlineScreen
import com.boryans.deadline.ui.screen.adddeadline.AddDeadlineViewModel
import com.boryans.deadline.ui.screen.details.DeadlineDetailsScreen
import com.boryans.deadline.ui.screen.details.DeadlineDetailsViewModel
import com.boryans.deadline.ui.screen.details.DeadlineDetailsViewModelFactory
import com.boryans.deadline.ui.screen.home.HomeScreen
import com.boryans.deadline.ui.screen.home.HomeUiEvent
import com.boryans.deadline.ui.screen.home.HomeViewModel
import com.boryans.deadline.ui.screenScopedViewModel
import com.boryans.deadline.utils.OnLifecycleEvent

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DeadlineNavigationGraph(
  navController: NavHostController = rememberNavController(),
) {
  val context = LocalContext.current

  NavHost(navController = navController, startDestination = Route.Home) {

    composable<Route.Home> {
      val viewModel: HomeViewModel = screenScopedViewModel()
      val uiState = viewModel.getUiState()

      HomeScreen(
        uiState = uiState,
        onNavigateToAddDeadline = { navController.navigate(Route.AddDeadline(null)) },
        onNavigateToDeadlineDetails = { navController.navigate(Route.DeadlineDetails(it)) },
        onDeleteDeadline = { viewModel.onEvent(HomeUiEvent.DeadlineSwiped(it, context)) }
      )
    }

    composable<Route.AddDeadline> {
      val viewModel: AddDeadlineViewModel = screenScopedViewModel()
      val uiState = viewModel.getUiState()
      val args = it.toRoute<Route.AddDeadline>()

      OnLifecycleEvent { _, event ->
        if (event == Lifecycle.Event.ON_CREATE) {
          viewModel.onEvent(AddDeadlineEvent.EditExistingDeadline(args.id, context))
        }
      }

      AddDeadlineScreen(
        uiState = uiState,
        onTitleInput = { viewModel.onEvent(AddDeadlineEvent.AddTitle(it)) },
        onDateInput = { viewModel.onEvent(AddDeadlineEvent.AddDate(it)) },
        onDescriptionInput = { viewModel.onEvent(AddDeadlineEvent.AddDescription(it)) },
        onAddDeadlineClicked = { viewModel.onEvent(AddDeadlineEvent.AddDeadline(context.applicationContext)) },
      )
    }

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
        uiState = uiState,
        onEditClicked = {
          navController.navigate(
            Route.AddDeadline(
              id = it.id,
            )
          )
        }
      )
    }
  }
}