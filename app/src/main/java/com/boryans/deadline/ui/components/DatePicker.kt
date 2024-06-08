package com.boryans.deadline.ui.components

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.boryans.deadline.ui.theme.DeadlineTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDatePicker(
  datePickerState: DatePickerState = rememberDatePickerState(),
) {
  DatePicker(
    state = datePickerState,
    colors = DatePickerDefaults.colors(
      containerColor = MaterialTheme.colorScheme.surface,
      titleContentColor = Color.White,
      weekdayContentColor = Color.White,
      dayContentColor = Color.White,
      dayInSelectionRangeContentColor = Color.White,
      selectedYearContentColor = Color.White,
    ),
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun MyDatePickerPreview() {
  DeadlineTheme {
    MyDatePicker()
  }
}