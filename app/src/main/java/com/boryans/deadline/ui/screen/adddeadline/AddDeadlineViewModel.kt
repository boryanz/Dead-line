package com.boryans.deadline.ui.screen.adddeadline

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.boryans.deadline.domain.AddDeadlineUseCase
import com.boryans.deadline.domain.GetDeadlineUseCase
import com.boryans.deadline.storage.db.entities.DeadlineEntity
import com.boryans.deadline.ui.DeadlineViewModel
import java.util.UUID
import kotlinx.coroutines.launch

open class AddDeadlineViewModel(
  private val addDeadlineUseCase: AddDeadlineUseCase = AddDeadlineUseCase(),
  private val getDeadlineUseCase: GetDeadlineUseCase = GetDeadlineUseCase(),
) : DeadlineViewModel<AddDeadlineUiState, AddDeadlineEvent>() {

  private val deadlineId = mutableStateOf("")
  private val title = mutableStateOf("")
  private val timestamp = mutableStateOf("")
  private val description = mutableStateOf("")
  private val isSuccess = mutableStateOf(false)

  @Composable
  override fun getUiState(): AddDeadlineUiState {
    return AddDeadlineUiState(
      title = title.value,
      date = timestamp.value,
      shortDescription = description.value,
      isSuccessfullyAddedEvent = isSuccess.value
    )
  }

  @RequiresApi(Build.VERSION_CODES.O)
  override fun onEvent(uiEvent: AddDeadlineEvent) {
    when (uiEvent) {
      is AddDeadlineEvent.AddTitle -> {
        title.value = uiEvent.title
      }

      is AddDeadlineEvent.AddDate -> {
        timestamp.value = uiEvent.date
      }

      is AddDeadlineEvent.AddDescription -> {
        description.value = uiEvent.description
      }

      is AddDeadlineEvent.AddDeadline -> {
        viewModelScope.launch {
          addDeadlineUseCase(
            application = uiEvent.context,
            deadlineEntity = DeadlineEntity(
              uuid = deadlineId.value.ifEmpty { UUID.randomUUID().toString() },
              title = title.value,
              description = description.value,
              timestamp = timestamp.value
            )
          )
          isSuccess.value = true
        }
      }

      is AddDeadlineEvent.EditExistingDeadline -> {
        if (uiEvent.id != null) {
          viewModelScope.launch {
            getDeadlineUseCase(context = uiEvent.context, uuid = uiEvent.id)?.collect { deadline ->
              deadlineId.value = deadline.id
              title.value = deadline.title
              timestamp.value = deadline.fullDate
              description.value = deadline.description.orEmpty()
            }
          }
        }
      }
    }
  }
}

data class AddDeadlineUiState(
  val id: String? = null,
  val title: String,
  val date: String,
  val shortDescription: String,
  val isSuccessfullyAddedEvent: Boolean = false,
)

sealed interface AddDeadlineEvent {
  data class AddTitle(val title: String) : AddDeadlineEvent
  data class AddDate(val date: String) : AddDeadlineEvent
  data class AddDescription(val description: String) : AddDeadlineEvent
  data class AddDeadline(val context: Context) : AddDeadlineEvent
  data class EditExistingDeadline(val id: String?, val context: Context) : AddDeadlineEvent
}