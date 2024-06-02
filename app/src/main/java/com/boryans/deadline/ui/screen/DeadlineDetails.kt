package com.boryans.deadline.ui.screen

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.boryans.deadline.navigation.Route
import com.boryans.deadline.ui.components.DeadlineButton
import com.boryans.deadline.ui.theme.DeadlineTheme
import java.util.Locale

fun NavGraphBuilder.deadlineDetailsScreen() {
  composable<Route.DeadlineDetails> {
    DeadlineDetailsScreen()
  }
}

@Composable
fun DeadlineDetailsScreen(
  modifier: Modifier = Modifier,
) {
  Surface {
    Scaffold { paddingValues ->
      Surface(modifier = modifier.fillMaxSize()) {
        DeadlineContent(paddingValues = paddingValues, onClick = {})
      }
    }
  }
}

@Composable
fun DeadlineContent(
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
    TimeBoxCard()
    Spacer(modifier = Modifier.height(20.dp))
    Text(
      modifier = Modifier.fillMaxWidth(),
      text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
        "Nulla interdum lectus mauris, a ullamcorper diamat. \n" +
        "Praesent ut lectus sit amet enim varius convallis. \n" +
        "Aenean interdum elementum quam vitae rhoncus.",
      style = MaterialTheme.typography.bodyMedium,
      color = Color.White
    )
    Spacer(modifier = Modifier.height(40.dp))
    DeadlineButton(text = "Edit", onClick = onClick)
  }
}

@Composable
fun TimeBoxCard(modifier: Modifier = Modifier) {
  Surface(
    shape = RoundedCornerShape(10.dp)
  ) {
    Box(
      modifier = modifier
        .padding(16.dp)
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
          Text(
            text = "Galichica Ultra", style = MaterialTheme.typography.headlineLarge,
            color = Color.White
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "24.03.2025", style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
          )
        }
        Spacer(modifier = Modifier.height(20.dp))
        TimerRowDetails()
      }
    }
  }
}

@Composable
fun TimerRowDetails(modifier: Modifier = Modifier) {
  Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceAround
  ) {
    TimerBoxDetails(title = "days", time = "22")
    Spacer(modifier = Modifier.width(8.dp))
    TimerBoxDetails(title = "hours", time = "12")
    Spacer(modifier = Modifier.width(8.dp))
    TimerBoxDetails(title = "mins", time = "45")
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
          .width(110.dp)
          .height(140.dp),
        contentAlignment = Alignment.Center
      ) {
        Text(
          text = time.uppercase(Locale.getDefault()),
          fontSize = 70.sp,
          fontWeight = FontWeight.ExtraBold,
          color = MaterialTheme.colorScheme.primary
        )
      }
    }
    Spacer(modifier = Modifier.height(3.dp))
    Text(
      text = title.uppercase(Locale.getDefault()),
      style = MaterialTheme.typography.headlineMedium,
      color = Color.Gray,
    )
  }

}

fun NavHostController.navigateToDeadlineDetails(deadlineId: String) {
  navigate(route = Route.DeadlineDetails(deadlineId = deadlineId))
}


@Preview
@Composable
private fun DeadlineDetailsPreview() {
  DeadlineTheme {
    DeadlineDetailsScreen()
  }
}