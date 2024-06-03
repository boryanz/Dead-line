package com.boryans.deadline.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.boryans.deadline.ui.theme.DeadlineTheme

@Composable
fun DeadlineButton(
  text: String,
  modifier: Modifier = Modifier,
  onClick: () -> Unit,
) {
  OutlinedButton(
    modifier = modifier
      .fillMaxWidth()
      .height(56.dp),
    onClick = onClick,
    shape = RoundedCornerShape(10.dp)
  ) {
    Text.HeadlineSmall(text = text)
  }
}

@Preview(showBackground = false)
@Composable
private fun DeadlineButtonPreview() {
  DeadlineTheme {
    DeadlineButton(text = "Edit", onClick = {})
  }
}