package com.boryans.deadline.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.boryans.deadline.navigation.Route
import com.boryans.deadline.ui.components.AppBar
import com.boryans.deadline.ui.components.DeadlineButton
import com.boryans.deadline.ui.components.DeadlineInput
import com.boryans.deadline.ui.theme.DeadlineTheme

fun NavGraphBuilder.addDeadlineScreen() {
  composable<Route.AddDeadline> {
    AddDeadlineScreen()
  }
}


@Composable
fun AddDeadlineScreen(modifier: Modifier = Modifier) {
  Surface {
    Scaffold(
      topBar = {
        AppBar(
          title = "Add new deadline",
          style = MaterialTheme.typography.headlineMedium
        )
      }
    ) { paddingValues ->
      Surface(
        modifier
          .fillMaxSize()
          .padding(paddingValues)
      ) {
        AddDeadlineContent()
      }
    }
  }
}

@Composable
fun AddDeadlineContent(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier.padding(horizontal = 12.dp),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    DeadlineInput(labelText = "Title", value = "", onValueChange = {})
    Spacer(modifier = Modifier.height(8.dp))
    DeadlineInput(labelText = "Deadline", value = "", onValueChange = {})
    Spacer(modifier = Modifier.height(8.dp))
    DeadlineInput(
      modifier = Modifier.height(200.dp),
      labelText = "Short description",
      value = "",
      onValueChange = {}
    )
    Spacer(modifier = Modifier.height(56.dp))
    DeadlineButton(text = "Save", onClick = {})
  }
}


@Preview
@Composable
private fun AddDeadlinePreview() {
  DeadlineTheme {
    AddDeadlineScreen()
  }
}

fun NavController.navigateToAddDeadlineScreen() {
  navigate(route = Route.AddDeadline)
}