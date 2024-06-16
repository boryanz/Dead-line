package com.boryans.deadline.ui.screen.adddeadline

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.boryans.deadline.ui.components.AppBar
import com.boryans.deadline.ui.theme.DeadlineTheme
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddDeadlineScreen(
  uiState: AddDeadlineUiState,
  onTitleInput: (title: String) -> Unit,
  onDateInput: (date: String) -> Unit,
  onDescriptionInput: (description: String) -> Unit,
  onAddDeadlineClicked: () -> Unit,
  modifier: Modifier = Modifier,
) {

  val scope = rememberCoroutineScope()
  val snackBarHostState = remember { SnackbarHostState() }

  Surface {
    Scaffold(
      snackbarHost = {
        SnackbarHost(hostState = snackBarHostState)
      },
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
          onAddDeadlineClicked = {
            scope.launch {
              if (uiState.title.isBlank() || uiState.date.isBlank()) {
                snackBarHostState.showSnackbar(
                  message = "Missing information!",
                  duration = SnackbarDuration.Short,
                )
              } else {
                snackBarHostState.showSnackbar("New deadline added.")
              }
            }
            if (uiState.title.isNotBlank() || uiState.date.isNotBlank()) {
              onAddDeadlineClicked()
            }
          }
        )
      }
    }
  }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun AddDeadlinePreview() {
  DeadlineTheme {
    AddDeadlineScreen(
      uiState = AddDeadlineUiState(
        title = "Title",
        date = "12.03.2024",
        isSuccessfullyAddedEvent = true,
        shortDescription = "Short description"
      ),
      onDescriptionInput = {},
      onAddDeadlineClicked = {},
      onDateInput = {},
      onTitleInput = {},
    )
  }
}