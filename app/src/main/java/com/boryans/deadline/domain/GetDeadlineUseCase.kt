package com.boryans.deadline.domain

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.boryans.deadline.data.model.Deadline
import com.boryans.deadline.storage.db.DeadlineDb
import com.boryans.deadline.storage.db.entities.toExternalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetDeadlineUseCase {

  @RequiresApi(Build.VERSION_CODES.O)
  operator fun invoke(context: Context, uuid: String): Flow<Deadline>? {
    val db = DeadlineDb.getDatabase(context)?.getDeadlineDao()
    return db?.getDeadline(uuid)?.map { it.toExternalModel() }
  }
}