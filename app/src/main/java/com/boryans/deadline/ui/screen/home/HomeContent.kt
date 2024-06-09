package com.boryans.deadline.ui.screen.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.boryans.deadline.ui.components.DeadlineItem

@Composable
fun HomeContent(
  uiState: HomeUiState,
  onDeadlineItemClick: (deadlineId: String) -> Unit,
) {
  LazyColumn {
    items(uiState.deadlines) {
      DeadlineItem(
        deadline = it,
        onDeadlineItemClick = {onDeadlineItemClick(it.id)}
      )
    }
  }
}