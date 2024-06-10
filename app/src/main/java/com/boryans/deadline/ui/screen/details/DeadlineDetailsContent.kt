package com.boryans.deadline.ui.screen.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.boryans.deadline.ui.components.DeadlineButton
import com.boryans.deadline.ui.components.Text
import com.boryans.deadline.ui.theme.bigShouldersDisplayBlack
import java.util.Locale

@Composable
fun DeadlineContent(
  uiState: DeadlineDetailsUiState,
  paddingValues: PaddingValues,
  onClick: () -> Unit,
) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(paddingValues)
      .padding(horizontal = 12.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top
  ) {
    TimeBoxCard(uiState)
    Spacer(modifier = Modifier.height(20.dp))
    Text.Default(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp),
      text = uiState.deadline?.description.orEmpty(),
      maxLines = 10,
      textAlign = TextAlign.Start
    )
    Spacer(modifier = Modifier.height(40.dp))
    DeadlineButton(text = "Edit", onClick = onClick)
  }
}

@Composable
fun TimeBoxCard(
  uiState: DeadlineDetailsUiState,
  modifier: Modifier = Modifier,
) {
  Surface(
    shape = RoundedCornerShape(10.dp)
  ) {
    Box(
      modifier = modifier
        .padding(horizontal = 16.dp)
        .wrapContentSize()
    ) {
      Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Column(
          modifier = Modifier.fillMaxWidth(),
          horizontalAlignment = Alignment.Start
        ) {
          Text.HeadlineSmall(text = uiState.deadline?.title.orEmpty())
          Spacer(modifier = Modifier.height(4.dp))
          Text.DefaultLarge(text = "Deadline in ${uiState.deadline?.fullDate.orEmpty()}")
        }
        Spacer(modifier = Modifier.height(20.dp))
        TimerRowDetails(uiState)
      }
    }
  }
}

@Composable
fun TimerRowDetails(
  uiState: DeadlineDetailsUiState,
  modifier: Modifier = Modifier,
) {
  Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceAround
  ) {
    TimerBoxDetails(title = "days", time = uiState.deadline?.daysRemaining.orEmpty())
    Spacer(modifier = Modifier.width(8.dp))
    TimerBoxDetails(title = "hours", time = uiState.deadline?.hoursRemaining.orEmpty())
    Spacer(modifier = Modifier.width(8.dp))
    TimerBoxDetails(title = "mins", time = uiState.deadline?.minutesRemaining.orEmpty())
    Spacer(modifier = Modifier.width(8.dp))
    TimerBoxDetails(title = "sec", time = uiState.deadline?.secondsRemaining.orEmpty())

  }
}

@Composable
fun TimerBoxDetails(
  title: String,
  time: String,
  modifier: Modifier = Modifier,
) {
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Surface(
      shape = RoundedCornerShape(10.dp),
      border = BorderStroke(1.dp, color = Color.Gray),
    ) {
      Box(
        modifier = modifier
          .width(70.dp)
          .wrapContentHeight()
          .padding(start = 12.dp, end = 12.dp, bottom = 6.dp),
        contentAlignment = Alignment.Center
      ) {
        Text.Headline(
          modifier = Modifier.wrapContentHeight(),
          text = time.uppercase(Locale.getDefault()),
          textColor = MaterialTheme.colorScheme.primary,
          fontFamily = bigShouldersDisplayBlack
        )
      }
    }
    Spacer(modifier = Modifier.height(3.dp))
    Text.DefaultLarge(
      text = title.uppercase(Locale.getDefault()),
      textColor = Color.Gray
    )
  }
}