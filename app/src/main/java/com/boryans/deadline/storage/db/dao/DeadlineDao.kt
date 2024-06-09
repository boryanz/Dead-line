package com.boryans.deadline.storage.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.boryans.deadline.storage.db.entities.DeadlineEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DeadlineDao {

  @Insert
  fun addDeadline(deadline: DeadlineEntity)

  @Query("SELECT * FROM deadline_entity")
  fun getAllDeadlines(): Flow<List<DeadlineEntity>>

}