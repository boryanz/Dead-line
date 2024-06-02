package com.boryans.deadline.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.boryans.deadline.ui.theme.DeadlineTheme

@Composable
fun DeadlineButton(
  text: String,
  modifier: Modifier = Modifier,
  onClick: () -> Unit,
) {
  Button(
    modifier = modifier
      .padding(vertical = 8.dp, horizontal = 12.dp)
      .fillMaxWidth()
      .height(56.dp),
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(
      contentColor = Color.White,
      containerColor = MaterialTheme.colorScheme.primary
    ),
    shape = RoundedCornerShape(10.dp)
  ) {
    Text(
      text = text,
      style = MaterialTheme.typography.headlineMedium,
    )
  }
}

@Preview(showBackground = true)
@Composable
private fun DeadlineButtonPreview() {
  DeadlineTheme {
    DeadlineButton(text = "Edit", onClick = {})
  }
}