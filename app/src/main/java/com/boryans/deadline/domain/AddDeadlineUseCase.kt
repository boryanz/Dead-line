package com.boryans.deadline.domain

import android.content.Context
import com.boryans.deadline.storage.db.DeadlineDb
import com.boryans.deadline.storage.db.entities.DeadlineEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddDeadlineUseCase(
  private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
  suspend operator fun invoke(application: Context, deadlineEntity: DeadlineEntity) =
    withContext(dispatcher) {
      val database = DeadlineDb.getDatabase(application)
      database?.getDeadlineDao()?.addDeadline(deadlineEntity)
    }
}