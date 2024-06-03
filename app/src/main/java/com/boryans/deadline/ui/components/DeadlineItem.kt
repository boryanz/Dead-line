package com.boryans.deadline.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.boryans.deadline.data.model.Deadline
import com.boryans.deadline.data.model.dummyDeadline
import com.boryans.deadline.ui.theme.DeadlineTheme
import com.boryans.deadline.ui.theme.bigShouldersDisplayBlack
import java.util.Locale

@Composable
fun DeadlineItem(
  deadline: Deadline,
  modifier: Modifier = Modifier,
  onDeadlineItemClick: () -> Unit,
) {
  Box(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 12.dp)
      .height(80.dp)
      .clickable { onDeadlineItemClick() },
    contentAlignment = Alignment.Center,
  ) {
    Row(
      modifier = modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceAround,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Column(
        horizontalAlignment = Alignment.Start
      ) {
        Text.DefaultLarge(text = deadline.title)
        Spacer(modifier = Modifier.height(4.dp))
        Text.Default(text = deadline.timestamp, textColor = Color.Gray)
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
    ) {
      Box(
        modifier = modifier
          .width(40.dp)
          .wrapContentHeight()
          .padding(4.dp),
        contentAlignment = Alignment.Center
      ) {
        Text.HeadlineSmall(
          text = time,
          fontFamily = bigShouldersDisplayBlack,
          textColor = MaterialTheme.colorScheme.primary
        )
      }
    }
    Spacer(modifier = Modifier.height(3.dp))
    Text.HeadlineExtraSmall(
      text = title.uppercase(Locale.getDefault()),
      textColor = Color.Gray
    )
  }

}

@Preview
@Composable
private fun DeadlineItemPreview() {
  DeadlineTheme {
    Surface {
      DeadlineItem(dummyDeadline, onDeadlineItemClick = {})
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