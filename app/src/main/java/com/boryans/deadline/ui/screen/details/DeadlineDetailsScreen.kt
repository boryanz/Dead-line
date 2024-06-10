package com.boryans.deadline.ui.screen.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.boryans.deadline.data.model.Deadline
import com.boryans.deadline.data.model.dummyDeadline
import com.boryans.deadline.ui.theme.DeadlineTheme

@Composable
fun DeadlineDetailsScreen(
  uiState: DeadlineDetailsUiState,
  onEditClicked: (deadline: Deadline) -> Unit,
  modifier: Modifier = Modifier,
) {

  Surface {
    Scaffold { paddingValues ->
      Surface(modifier = modifier.fillMaxSize()) {
        DeadlineContent(
          uiState = uiState,
          paddingValues = paddingValues,
          onClick = { onEditClicked(it) }
        )
      }
    }
  }
}

@Preview
@Composable
private fun DeadlineDetailsPreview() {
  DeadlineTheme {
    DeadlineDetailsScreen(
      uiState = DeadlineDetailsUiState(dummyDeadline),
      onEditClicked = {}
    )
  }
}