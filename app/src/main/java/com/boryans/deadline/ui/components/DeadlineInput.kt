package com.boryans.deadline.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
    Text.Default(text = labelText)
    Spacer(modifier = Modifier.height(3.dp))
    OutlinedTextField(
      modifier = modifier.fillMaxWidth(),
      value = value,
      maxLines = maxLines,
      onValueChange = onValueChange,
      shape = RoundedCornerShape(6.dp),
      colors = TextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        focusedContainerColor = MaterialTheme.colorScheme.surface,
        unfocusedContainerColor = MaterialTheme.colorScheme.surface
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