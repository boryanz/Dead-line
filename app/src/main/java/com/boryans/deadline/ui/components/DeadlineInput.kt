package com.boryans.deadline.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.boryans.deadline.ui.theme.DeadlineTheme

@Composable
fun DeadlineInput(
  labelText: String,
  value: String,
  modifier: Modifier = Modifier,
  maxLines: Int = 1,
  onValueChange: (userInput: String) -> Unit,
) {
  Column(
    modifier = modifier,
    horizontalAlignment = Alignment.Start
  ) {
    Text(
      text = labelText,
      style = MaterialTheme.typography.headlineSmall,
      color = Color.White
    )
    Spacer(modifier = Modifier.height(3.dp))
    OutlinedTextField(
      modifier = modifier,
      value = value,
      maxLines = maxLines,
      onValueChange = onValueChange,
      colors = TextFieldDefaults.colors(
        unfocusedContainerColor = MaterialTheme.colorScheme.onSurface,
        focusedContainerColor = MaterialTheme.colorScheme.onSurface,
      )
    )
  }
}


@Preview
@Composable
private fun DeadlineInputPreview() {
  DeadlineTheme {
    DeadlineInput(
      labelText = "Title",
      value = "",
      onValueChange = {}
    )
  }
}