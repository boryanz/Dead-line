package com.boryans.deadline.domain

import android.content.Context
import com.boryans.deadline.storage.db.DeadlineDb
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeleteDeadlineUseCase(
  private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
  suspend operator fun invoke(deadlineId: String, context: Context) {
    withContext(dispatcher) {
      DeadlineDb.getDatabase(context)?.getDeadlineDao()?.deleteDeadline(deadlineId)
    }
  }
}