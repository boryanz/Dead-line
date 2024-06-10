package com.boryans.deadline.storage.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.boryans.deadline.storage.db.entities.DeadlineEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DeadlineDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun addDeadline(deadline: DeadlineEntity)

  @Query("SELECT * FROM deadline_entity")
  fun getAllDeadlines(): Flow<List<DeadlineEntity>>

  @Query("SELECT * FROM deadline_entity WHERE uuid = :uuid")
  fun getDeadline(uuid: String): Flow<DeadlineEntity>

  @Query("DELETE FROM deadline_entity WHERE uuid = :uuid")
  fun deleteDeadline(uuid: String)

  @Update
  fun updateDeadline(deadline: DeadlineEntity)

}