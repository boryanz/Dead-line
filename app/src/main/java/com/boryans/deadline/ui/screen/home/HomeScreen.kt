package com.boryans.deadline.ui.screen.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.boryans.deadline.ui.components.AddDeadlineFAB
import com.boryans.deadline.ui.components.AppBar
import com.boryans.deadline.ui.theme.DeadlineTheme
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
  uiState: HomeUiState,
  onNavigateToAddDeadline: () -> Unit,
  onNavigateToDeadlineDetails: (id: String) -> Unit,
  onDeleteDeadline: (id: String) -> Unit,
  modifier: Modifier = Modifier,
) {
  val scope = rememberCoroutineScope()
  val snackBarHostState = remember { SnackbarHostState() }

  Surface {
    Scaffold(
      modifier = modifier,
      snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
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
          onSwipedDeadline = {
            scope.launch {
              snackBarHostState.showSnackbar(message = "Deadline deleted")
            }
            onDeleteDeadline(it)
          }
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