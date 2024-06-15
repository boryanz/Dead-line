package com.boryans.deadline.ui.screen.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.boryans.deadline.ui.components.AddDeadlineFAB
import com.boryans.deadline.ui.components.AppBar
import com.boryans.deadline.ui.theme.DeadlineTheme

@Composable
fun HomeScreen(
  uiState: HomeUiState,
  onNavigateToAddDeadline: () -> Unit,
  onNavigateToDeadlineDetails: (id: String) -> Unit,
  onDeleteDeadline: (id: String) -> Unit,
  modifier: Modifier = Modifier,
) {
  Surface {
    Scaffold(
      modifier = modifier,
      topBar = {
        AppBar(
          title = "Deadlines",
          style = MaterialTheme.typography.headlineLarge
        )
      },
      floatingActionButton = {
        AddDeadlineFAB(
          onClick = onNavigateToAddDeadline
        )
      }
    ) { paddingValues ->
      Surface(
        modifier
          .fillMaxSize()
          .padding(paddingValues)
      ) {
        HomeContent(
          uiState = uiState,
          onDeadlineItemClick = { onNavigateToDeadlineDetails(it) },
          onSwipedDeadline = { onDeleteDeadline(it) }
        )
      }
    }
  }
}

@Preview
@Composable
private fun HomePreview() {
  DeadlineTheme {
    HomeScreen(
      uiState = HomeUiState(emptyList()),
      onNavigateToAddDeadline = { /*TODO*/ },
      onNavigateToDeadlineDetails = {},
      onDeleteDeadline = {}
    )
  }
}