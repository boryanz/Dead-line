package com.boryans.deadline.ui.screen.adddeadline

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.boryans.deadline.ui.components.AppBar
import com.boryans.deadline.ui.theme.DeadlineTheme

@Composable
fun AddDeadlineScreen(
  uiState: AddDeadlineUiState,
  onTitleInput: (title: String) -> Unit,
  onDateInput: (date: String) -> Unit,
  onDescriptionInput: (description: String) -> Unit,
  onAddDeadlineClicked: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Surface {
    Scaffold(
      topBar = {
        AppBar(
          title = "Add new deadline",
          style = MaterialTheme.typography.headlineMedium
        )
      }
    ) { paddingValues ->
      Surface(
        modifier
          .fillMaxSize()
          .padding(paddingValues)
      ) {
        AddDeadlineContent(
          uiState = uiState,
          onTitleInput = onTitleInput,
          onDateInput = onDateInput,
          onDescriptionInput = onDescriptionInput,
          onAddDeadlineClicked = onAddDeadlineClicked
        )
      }
    }
  }
}

@Preview
@Composable
private fun AddDeadlinePreview() {
  DeadlineTheme {
    //AddDeadlineScreen()
  }
}