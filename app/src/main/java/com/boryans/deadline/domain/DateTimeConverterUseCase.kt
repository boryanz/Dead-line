package com.boryans.deadline.domain

import android.os.Build
import androidx.annotation.RequiresApi
import com.boryans.deadline.data.model.Deadline
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class DateTimeConverterUseCase() {
  private val now = System.currentTimeMillis()

  operator fun invoke(deadlineTimeStamp: String, title: String): Deadline {
    val timeDiff = deadlineTimeStamp.toLong() - now
    val seconds = timeDiff / 1000
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24

    return Deadline(
      title = title,
      fullDate = deadlineTimeStamp.toFullDate(),
      daysRemaining = days.toString(),
      hoursRemaining = (hours % 24).toString(),
      minutesRemaining = (minutes % 60).toString(),
      secondsRemaining = seconds.toString()
    )
  }

  private fun String.toFullDate(): String {
    val instant = Instant.ofEpochMilli(this.toLong())
    val localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate()
    val formattedDate = localDate.format(DateTimeFormatter.ofPattern("dd:MM:yyyy"))
    return formattedDate
  }
}