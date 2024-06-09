package com.boryans.deadline.storage.db.entities

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.boryans.deadline.data.model.Deadline
import com.boryans.deadline.utils.convertMillisToLocalDate
import com.boryans.deadline.utils.dateToString
import java.util.UUID

@RequiresApi(Build.VERSION_CODES.O)
@Entity(tableName = "deadline_entity")
data class DeadlineEntity(
  @PrimaryKey
  val uuid: UUID,
  @ColumnInfo("title")
  val title: String,
  @ColumnInfo("description")
  val description: String,
  @ColumnInfo("timestamp")
  val timestamp: String,
)

@RequiresApi(Build.VERSION_CODES.O)
fun DeadlineEntity.toExternalModel(): Deadline {
  val now = System.currentTimeMillis()
  val diff = timestamp.toLong() - now

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
    title = this.title,
    fullDate = dateAsString,
    daysRemaining = daysRemaining,
    hoursRemaining = hoursRemaining,
    minutesRemaining = minutesRemaining,
    secondsRemaining = secondsRemaining
  )
}

private fun getFormattedTime(timestamp: Long): String {
  return if (timestamp < 10) "0$timestamp" else "$timestamp"
}

