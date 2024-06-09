package com.boryans.deadline.data.model

data class Deadline(
  val id: String,
  val title: String,
  val fullDate: String,
  val daysRemaining: String,
  val hoursRemaining: String,
  val minutesRemaining: String,
  val description: String? = null,
  val secondsRemaining: String? = null,
)
