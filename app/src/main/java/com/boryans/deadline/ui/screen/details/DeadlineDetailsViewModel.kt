package com.boryans.deadline.ui.screen.details

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.boryans.deadline.data.model.Deadline
import com.boryans.deadline.domain.GetDeadlineUseCase
import com.boryans.deadline.ui.DeadlineViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
class DeadlineDetailsViewModelFactory(
  private val getDeadlineUseCase: GetDeadlineUseCase,
  private val deadlineId: String,
) : ViewModelProvider.NewInstanceFactory() {
  override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T =
    DeadlineDetailsViewModel(getDeadlineUseCase, deadlineId) as T
}

@RequiresApi(Build.VERSION_CODES.O)
class DeadlineDetailsViewModel(
  private val getDeadlineUseCase: GetDeadlineUseCase,
  private val deadlineId: String,
) : DeadlineViewModel<DeadlineDetailsUiState, DeadlineDetailsUiEvent>() {

  private val deadlineState = mutableStateOf(DeadlineDetailsUiState())

  @Composable
  override fun getUiState(): DeadlineDetailsUiState {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
      startCountDown(context)
    }
    return deadlineState.value
  }

  private fun startCountDown(context: Context) {
    viewModelScope.launch {
      while (true) {
        updateUiState(context)
        delay(1000L)
      }
    }
  }

  private fun updateUiState(context: Context) {
    viewModelScope.launch {
      getDeadlineUseCase(context, deadlineId)?.collect { deadline ->
        deadlineState.value = DeadlineDetailsUiState(deadline)
      }
    }
  }

  override fun onEvent(uiEvent: DeadlineDetailsUiEvent) {
    when (uiEvent) {
      DeadlineDetailsUiEvent.RemoveDeadline -> {
        /* remove from DB */
      }
    }
  }
}


data class DeadlineDetailsUiState(val deadline: Deadline? = null)

sealed interface DeadlineDetailsUiEvent {
  data object RemoveDeadline : DeadlineDetailsUiEvent
}