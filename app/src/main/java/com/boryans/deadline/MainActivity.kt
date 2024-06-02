package com.boryans.deadline

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.boryans.deadline.navigation.DeadlineNavigationGraph
import com.boryans.deadline.ui.theme.DeadlineTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      DeadlineTheme {
        DeadlineNavigationGraph()
      }
    }
  }
}

@Composable
fun HomeContent(
  modifier: Modifier = Modifier,
  onNavigateNext: () -> Unit,
) {
  Surface {
    Column(
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = "22d:12h:43m",
        style = MaterialTheme.typography.headlineLarge
      )
      Spacer(modifier = Modifier.height(20.dp))
      Button(onClick = onNavigateNext) {
        Text(text = "Navigate next")
      }
    }
  }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED)
@Composable
fun GreetingPreview() {
  DeadlineTheme {
    HomeContent {}
  }
}