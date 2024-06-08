package com.boryans.deadline.ui.screen.adddeadline

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.boryans.deadline.storage.SharedPreferenceManager
import com.boryans.deadline.ui.DeadlineViewModel

class AddDeadlineViewModel(
  private val sharedPrefs: SharedPreferenceManager = SharedPreferenceManager,
) : DeadlineViewModel<AddDeadlineUiState, AddDeadlineEvent>() {

  private val title = mutableStateOf("")
  private val date = mutableStateOf("")
  private val description = mutableStateOf("")
  private val isSuccess = mutableStateOf(false)

  @Composable
  override fun getUiState(): AddDeadlineUiState {
    return AddDeadlineUiState(
      title = title.value,
      date = date.value,
      shortDescription = description.value,
      isSuccessfullyAddedEvent = isSuccess.value
    )
  }

  override fun onEvent(uiEvent: AddDeadlineEvent) {
    when (uiEvent) {
      is AddDeadlineEvent.AddTitle -> {
        title.value = uiEvent.title
      }

      is AddDeadlineEvent.AddDate -> {
        date.value = uiEvent.date
      }

      is AddDeadlineEvent.AddDescription -> {
        description.value = uiEvent.description
      }

      AddDeadlineEvent.AddDeadline -> {
        sharedPrefs.put(title.value, date.value)
        isSuccess.value = true
      }
    }
  }
}

data class AddDeadlineUiState(
  val title: String,
  val date: String,
  val shortDescription: String,
  val isSuccessfullyAddedEvent: Boolean = false,
)

sealed interface AddDeadlineEvent {
  data class AddTitle(val title: String) : AddDeadlineEvent
  data class AddDate(val date: String) : AddDeadlineEvent
  data class AddDescription(val description: String) : AddDeadlineEvent
  data object AddDeadline : AddDeadlineEvent
}