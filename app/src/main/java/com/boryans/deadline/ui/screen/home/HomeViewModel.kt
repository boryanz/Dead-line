package com.boryans.deadline.ui.screen.home

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewModelScope
import com.boryans.deadline.data.model.Deadline
import com.boryans.deadline.domain.DeleteDeadlineUseCase
import com.boryans.deadline.domain.GetRunningDeadlinesUseCase
import com.boryans.deadline.ui.DeadlineViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
class HomeViewModel(
  private val getDeadlinesUseCase: GetRunningDeadlinesUseCase = GetRunningDeadlinesUseCase(),
  private val deleteDeadlineUseCase: DeleteDeadlineUseCase = DeleteDeadlineUseCase(),
) : DeadlineViewModel<HomeUiState, HomeUiEvent>() {

  private val deadlinesState = mutableStateOf(emptyList<Deadline>())

  @Composable
  override fun getUiState(): HomeUiState {
    val context = LocalContext.current.applicationContext

    LaunchedEffect(Unit) {
      startCounters(context)
    }

    return HomeUiState(deadlinesState.value)
  }

  override fun onEvent(uiEvent: HomeUiEvent) {
    when (uiEvent) {
      is HomeUiEvent.DeadlineSwiped -> {
        viewModelScope.launch {
          deleteDeadlineUseCase(uiEvent.deadlineId, uiEvent.context)
        }
      }
    }
  }

  private fun updateCountersState(context: Context) {
    viewModelScope.launch {
      val deadlines = getDeadlinesUseCase(context)
      deadlines?.collect { activeDeadlines ->
        deadlinesState.value =
          activeDeadlines.sortedBy { deadline -> deadline.daysRemaining.toInt() }
      }
    }
  }

  private fun startCounters(applicationCtx: Context) = viewModelScope.launch {
    while (true) {
      updateCountersState(context = applicationCtx)
      delay(60000L)
    }
  }
}

data class HomeUiState(val deadlines: List<Deadline>)

sealed interface HomeUiEvent {
  val context: Context

  data class DeadlineSwiped(val deadlineId: String, override val context: Context) : HomeUiEvent
}