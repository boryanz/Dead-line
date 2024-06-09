package com.boryans.deadline.storage.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.boryans.deadline.storage.db.dao.DeadlineDao
import com.boryans.deadline.storage.db.entities.DeadlineEntity

@Database(entities = [DeadlineEntity::class], version = 1)
abstract class DeadlineDb : RoomDatabase() {

  companion object {

    @Volatile
    private var dbInstance: DeadlineDb? = null

    fun getDatabase(context: Context): DeadlineDb? {
      if (dbInstance == null) {
        synchronized(Unit) {
          dbInstance = Room.databaseBuilder(
            context = context.applicationContext,
            klass = DeadlineDb::class.java,
            "deadline_db"
          ).build()
        }
      }
      return dbInstance
    }
  }

  abstract fun getDeadlineDao(): DeadlineDao
}
