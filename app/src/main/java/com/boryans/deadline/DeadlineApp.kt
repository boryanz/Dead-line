package com.boryans.deadline

import android.app.Application
import android.content.Context
import com.boryans.deadline.storage.SharedPreferenceManager

class DeadlineApp : Application() {
  override fun onCreate() {
    super.onCreate()
    val sharedPreferences = getSharedPreferences("deadline", Context.MODE_PRIVATE)
    SharedPreferenceManager.init(sharedPreferences)
  }
}