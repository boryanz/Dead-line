package com.boryans.deadline.domain

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.boryans.deadline.data.model.Deadline
import com.boryans.deadline.storage.db.DeadlineDb
import com.boryans.deadline.storage.db.entities.toExternalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@RequiresApi(Build.VERSION_CODES.O)
class GetRunningDeadlinesUseCase {

  operator fun invoke(application: Context): Flow<List<Deadline>>? {
    val db = DeadlineDb.getDatabase(application)
    return db?.getDeadlineDao()?.getAllDeadlines()?.map { deadlines ->
      deadlines.map { it.toExternalModel() }
    }
  }

}