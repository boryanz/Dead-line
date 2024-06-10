package com.boryans.deadline.ui.screen.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.boryans.deadline.R
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
  Icon(
    painter = painterResource(id = R.drawable.ic_deadline),
    contentDescription = "deadline icon"
  )
  Spacer(modifier = Modifier.height(32.dp))
  Text.Default(text = "No goals to crush? Let's add some.")
}