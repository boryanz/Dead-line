package com.boryans.deadline.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.boryans.deadline.ui.theme.DeadlineTheme
import com.boryans.deadline.utils.convertMillisToLocalDate
import com.boryans.deadline.utils.dateToString

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeadlineDateInput(
  onConfirmDate: (timeInMillis: String) -> Unit,
  modifier: Modifier = Modifier,
) {
  val dateState = rememberDatePickerState()
  val millisToLocalDate = dateState.selectedDateMillis?.let {
    convertMillisToLocalDate(it)
  }

  val dateAsString = millisToLocalDate?.let {
    dateToString(millisToLocalDate)
  }.orEmpty()

  var showDatePicker by remember {
    mutableStateOf(false)
  }

  Column(
    modifier = modifier,
    horizontalAlignment = Alignment.Start
  ) {
    Text.Default(text = "Deadline")
    Spacer(modifier = Modifier.height(3.dp))

    if (showDatePicker) {
      DatePickerDialog(
        onDismissRequest = { showDatePicker = false },
        dismissButton = {
          Button(onClick = { showDatePicker = false }) {
            Text.Default(text = "Cancel")
          }
        },
        confirmButton = {
          Button(onClick = {
            onConfirmDate(dateState.selectedDateMillis.toString())
            showDatePicker = false
          }) {
            Text.Default(text = "OK")
          }
        },
        content = {
          MyDatePicker(dateState)
        }
      )
    }
    TextField(
      modifier = Modifier
        .fillMaxWidth()
        .border(border = BorderStroke(1.dp, Color.White), shape = RoundedCornerShape(6.dp))
        .clickable { showDatePicker = true },
      value = dateAsString,
      readOnly = true,
      maxLines = 1,
      enabled = false,
      onValueChange = {},
      textStyle = TextStyle(color = Color.White),
      colors = TextFieldDefaults.colors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White,
        focusedContainerColor = MaterialTheme.colorScheme.surface,
        unfocusedContainerColor = MaterialTheme.colorScheme.surface,
        disabledContainerColor = MaterialTheme.colorScheme.surface,
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