package com.boryans.deadline.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.boryans.deadline.ui.theme.DeadlineTheme

@Composable
fun AddDeadlineFAB(onClick: () -> Unit) {
  FloatingActionButton(
    containerColor = MaterialTheme.colorScheme.primary,
    contentColor = MaterialTheme.colorScheme.secondary,
    onClick = onClick,
  ) {
    Icon(
      imageVector = Icons.Default.Add,
      contentDescription = "Add deadline",
      tint = Color.White
    )
  }
}

@Preview(showBackground = true)
@Composable
private fun AddDeadlineFABPreview() {
  DeadlineTheme {
    Surface {
      AddDeadlineFAB {}
    }
  }
}