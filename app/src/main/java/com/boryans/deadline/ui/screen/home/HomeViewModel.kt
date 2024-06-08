package com.boryans.deadline.ui.screen.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.boryans.deadline.data.model.Deadline
import com.boryans.deadline.domain.DateTimeConverterUseCase
import com.boryans.deadline.storage.SharedPreferenceManager
import com.boryans.deadline.ui.DeadlineViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
class HomeViewModel(
  private val sharedPrefs: SharedPreferenceManager = SharedPreferenceManager,
  private val dateTimeConverterUseCase: DateTimeConverterUseCase = DateTimeConverterUseCase(),
) : DeadlineViewModel<HomeUiState, HomeUiEvent>() {

  private val deadlinesState = mutableStateOf(emptyList<Deadline>())

  @Composable
  override fun getUiState(): HomeUiState {
    LaunchedEffect(Unit) {
      startCounters()
    }
    return HomeUiState(deadlinesState.value)
  }

  override fun onEvent(uiEvent: HomeUiEvent) {
    when (uiEvent) {
      is HomeUiEvent.DeadlineSwiped -> {
        sharedPrefs.remove(uiEvent.deadlineKey)
        updateCountersState()
      }
    }
  }

  private fun updateCountersState() {
    val deadlines = sharedPrefs.getAll().map {
      dateTimeConverterUseCase((it.value as String), it.key)
    }.sortedByDescending { it.daysRemaining }

    deadlinesState.value = deadlines
  }

  private fun startCounters() = viewModelScope.launch {
    while (true) {
      updateCountersState()
      delay(60000L)
    }
  }
}

data class HomeUiState(val deadlines: List<Deadline>)

sealed interface HomeUiEvent {
  data class DeadlineSwiped(val deadlineKey: String) : HomeUiEvent
}