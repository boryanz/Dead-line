package com.boryans.deadline.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.boryans.deadline.ui.theme.DeadlineTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
  title: String,
  style: TextStyle = TextStyle.Default,
  modifier: Modifier = Modifier,
) {
  TopAppBar(
    modifier = modifier.fillMaxWidth(),
    title = {
      Text(text = title, style = style, color = Color.White)
    }
  )
}


@Preview
@Composable
private fun AppBarPreview() {
  DeadlineTheme {
    AppBar(title = "Deadlines", style = MaterialTheme.typography.headlineLarge)
  }
}