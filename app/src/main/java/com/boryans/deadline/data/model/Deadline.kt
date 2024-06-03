package com.boryans.deadline.data.model

data class Deadline(
  val title: String,
  val timestamp: String,
  val days: String,
  val hours: String,
  val minutes: String,
  val seconds: String? = null,
)
