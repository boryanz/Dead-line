package com.boryans.deadline.ui.screen.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.boryans.deadline.ui.components.DeadlineItem
import com.boryans.deadline.ui.components.SwipeToDeleteContainer

@Composable
fun HomeContent(
  uiState: HomeUiState,
  onSwipedDeadline: (id: String) -> Unit,
  onDeadlineItemClick: (deadlineId: String) -> Unit,
) {
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