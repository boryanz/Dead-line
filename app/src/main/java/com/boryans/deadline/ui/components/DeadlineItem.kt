package com.boryans.deadline.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.boryans.deadline.data.model.Deadline
import com.boryans.deadline.data.model.dummyDeadline
import com.boryans.deadline.ui.theme.DeadlineTheme
import java.util.Locale

@Composable
fun DeadlineItem(
  deadline: Deadline,
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 12.dp, vertical = 6.dp)
      .height(80.dp)
      .clip(RoundedCornerShape(6.dp))
      .background(color = MaterialTheme.colorScheme.onSurface),
    contentAlignment = Alignment.Center,
  ) {
    Row(
      modifier = modifier
        .fillMaxWidth()
        .padding(12.dp),
      horizontalArrangement = Arrangement.SpaceAround,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Column(horizontalAlignment = Alignment.Start) {
        Text(
          text = deadline.title,
          style = MaterialTheme.typography.headlineMedium,
          color = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(horizontalArrangement = Arrangement.Start) {
          Icon(
            modifier = Modifier
              .width(14.dp)
              .height(14.dp),
            imageVector = Icons.Default.DateRange,
            contentDescription = "Date",
            tint = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = "December 24th, 2025",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
          )
        }
      }
      Spacer(modifier = Modifier.width(12.dp))
      TimeBoxRow(deadline)
    }

  }
}

@Composable
fun TimeBoxRow(deadline: Deadline) {
  Row(
    horizontalArrangement = Arrangement.Center
  ) {
    TimeBox(title = "days", time = deadline.days)
    Spacer(modifier = Modifier.width(8.dp))
    TimeBox(title = "hours", time = deadline.hours)
    Spacer(modifier = Modifier.width(8.dp))
    TimeBox(title = "mins", time = deadline.minutes)
  }
}

@Composable
fun TimeBox(
  title: String,
  time: String,
  modifier: Modifier = Modifier,
) {
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Surface(
      shape = RoundedCornerShape(6.dp),
      border = BorderStroke(1.dp, color = Color.Gray),
      color = MaterialTheme.colorScheme.onSurface
    ) {
      Box(
        modifier = modifier
          .width(40.dp)
          .height(40.dp),
        contentAlignment = Alignment.Center
      ) {
        Text(
          text = time.uppercase(Locale.getDefault()),
          style = MaterialTheme.typography.headlineMedium,
          color = MaterialTheme.colorScheme.primary
        )
      }
    }
    Spacer(modifier = Modifier.height(3.dp))
    Text(
      text = title.uppercase(Locale.getDefault()),
      style = MaterialTheme.typography.titleMedium,
      color = Color.Gray,
    )
  }

}

@Preview
@Composable
private fun DeadlineItemPreview() {
  DeadlineTheme {
    Surface {
      DeadlineItem(dummyDeadline)
    }
  }
}

@Preview
@Composable
private fun TimeBoxRowPreview() {
  DeadlineTheme {
    TimeBoxRow(dummyDeadline)
  }
}

@Preview
@Composable
private fun TimeBoxPreview() {
  DeadlineTheme {
    TimeBox(time = "04", title = "days")
  }
}