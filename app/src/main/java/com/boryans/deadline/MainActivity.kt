package com.boryans.deadline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
