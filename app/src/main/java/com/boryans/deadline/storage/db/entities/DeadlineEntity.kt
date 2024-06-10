package com.boryans.deadline.storage.db.entities

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.boryans.deadline.data.model.Deadline
import com.boryans.deadline.utils.convertMillisToLocalDate
import com.boryans.deadline.utils.dateToString
import java.util.TimeZone

@RequiresApi(Build.VERSION_CODES.O)
@Entity(tableName = "deadline_entity")
data class DeadlineEntity(
  @PrimaryKey
  val uuid: String,
  @ColumnInfo("title")
  val title: String,
  @ColumnInfo("description")
  val description: String,
  @ColumnInfo("timestamp")
  val timestamp: String,
)

@RequiresApi(Build.VERSION_CODES.O)

fun DeadlineEntity.toExternalModel(): Deadline {
  val currentMillisUTC: Long = System.currentTimeMillis()
  val timezoneOffsetMillis = TimeZone.getDefault().getOffset(currentMillisUTC)
  val currentMillisDeviceTime = currentMillisUTC + timezoneOffsetMillis

  val diff = timestamp.toLong() - currentMillisDeviceTime

  val seconds = diff / 1000 % 60
  val minutes = diff / (1000 * 60) % 60
  val hours = diff / (1000 * 60 * 60) % 24
  val days = diff / (1000 * 60 * 60 * 24)
  val localDate = convertMillisToLocalDate(timestamp.toLong())

  val dateAsString = dateToString(localDate)
  val daysRemaining = getFormattedTime(days)
  val hoursRemaining = getFormattedTime(hours)
  val minutesRemaining = getFormattedTime(minutes)
  val secondsRemaining = getFormattedTime(seconds)

  return Deadline(
    id = uuid,
    title = this.title,
    fullDate = dateAsString,
    daysRemaining = daysRemaining,
    hoursRemaining = hoursRemaining,
    minutesRemaining = minutesRemaining,
    secondsRemaining = secondsRemaining,
    description = description
  )
}

private fun getFormattedTime(timestamp: Long): String {
  return when {
    timestamp < 0 -> "00"
    else -> {
      if (timestamp < 10) "0$timestamp" else "$timestamp"
    }
  }
}

