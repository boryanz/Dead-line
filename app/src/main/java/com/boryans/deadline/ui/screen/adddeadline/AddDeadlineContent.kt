package com.boryans.deadline.ui.screen.adddeadline

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.boryans.deadline.ui.components.DeadlineButton
import com.boryans.deadline.ui.components.DeadlineDateInput
import com.boryans.deadline.ui.components.DeadlineInput

@Composable
fun AddDeadlineContent(
  uiState: AddDeadlineUiState,
  onTitleInput: (title: String) -> Unit,
  onDateInput: (date: String) -> Unit,
  onDescriptionInput: (description: String) -> Unit,
  onAddDeadlineClicked: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Column(
    modifier = modifier.padding(horizontal = 12.dp),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    DeadlineInput(labelText = "Title", value = uiState.title, onValueChange = { onTitleInput(it) })
    Spacer(modifier = Modifier.height(8.dp))
    DeadlineDateInput(onConfirmDate = { onDateInput(it) })
    Spacer(modifier = Modifier.height(8.dp))
    DeadlineInput(
      modifier = Modifier.height(200.dp),
      labelText = "Short description",
      value = uiState.shortDescription,
      onValueChange = { onDescriptionInput(it) }
    )
    Spacer(modifier = Modifier.height(56.dp))
    DeadlineButton(text = "Save", onClick = onAddDeadlineClicked)
  }
}