package com.boryans.deadline

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.boryans.deadline.navigation.DeadlineNavigationGraph
import com.boryans.deadline.ui.theme.DeadlineTheme

class MainActivity : ComponentActivity() {
  @RequiresApi(Build.VERSION_CODES.O)
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
