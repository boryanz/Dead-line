package com.boryans.deadline.data.model

data class Deadline(
  val title: String,
  val fullDate: String,
  val daysRemaining: String,
  val hoursRemaining: String,
  val minutesRemaining: String,
  val secondsRemaining: String? = null,
)
