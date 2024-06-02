package com.boryans.deadline.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.boryans.deadline.data.model.dummyDeadline
import com.boryans.deadline.navigation.Route
import com.boryans.deadline.ui.components.AddDeadlineFAB
import com.boryans.deadline.ui.components.AppBar
import com.boryans.deadline.ui.components.DeadlineItem
import com.boryans.deadline.ui.theme.DeadlineTheme

fun NavGraphBuilder.homeScreen(
  onNavigateToAddDeadline: () -> Unit,
  onNavigateToDeadlineDetails: () -> Unit,
) {
  composable<Route.Home> {
    HomeScreen(
      onNavigateToAddDeadline = onNavigateToAddDeadline,
      onNavigateToDeadlineDetails = onNavigateToDeadlineDetails
    )
  }
}

@Composable
fun HomeScreen(
  onNavigateToAddDeadline: () -> Unit,
  onNavigateToDeadlineDetails: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Surface {
    Scaffold(
      modifier = modifier,
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
        HomeContent(onDeadlineItemClick = onNavigateToDeadlineDetails)
      }
    }
  }

}

@Composable
fun HomeContent(
  onDeadlineItemClick: () -> Unit,
) {
  LazyColumn {
    items(5) {
      DeadlineItem(
        deadline = dummyDeadline,
        onDeadlineItemClick = onDeadlineItemClick
      )
    }
  }
}


@Preview
@Composable
private fun HomePreview() {
  DeadlineTheme {
    HomeScreen(onNavigateToAddDeadline = { /*TODO*/ }, onNavigateToDeadlineDetails = {})
  }
}

fun NavController.navigateToHomeScreen() {
  navigate(route = Route.Home)
}