package com.boryans.deadline.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.boryans.deadline.ui.components.DeadlineItem
import com.boryans.deadline.ui.components.SwipeToDeleteContainer
import com.boryans.deadline.ui.components.Text

@Composable
fun HomeContent(
  uiState: HomeUiState,
  onSwipedDeadline: (id: String) -> Unit,
  onDeadlineItemClick: (deadlineId: String) -> Unit,
) {
  if (uiState.deadlines.isEmpty()) {
    EmptyDeadlinesContent()
  } else {
    LazyColumn {
      items(
        key = { it.id },
        items = uiState.deadlines
      ) {
        SwipeToDeleteContainer(
          item = it,
          onDelete = { onSwipedDeadline(it.id) }
        ) {
          DeadlineItem(
            deadline = it,
            onDeadlineItemClick = { onDeadlineItemClick(it.id) }
          )
        }
      }
    }
  }

}

@Composable
private fun EmptyDeadlinesContent() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(bottom = 50.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text.Default(text = "No goals to crush? Let's add some.")
  }
}