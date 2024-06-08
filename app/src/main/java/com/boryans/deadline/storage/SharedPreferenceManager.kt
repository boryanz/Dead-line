package com.boryans.deadline.storage

import android.content.SharedPreferences

object SharedPreferenceManager {

  private lateinit var sharedPreferences: SharedPreferences

  fun init(sharedPrefsInstance: SharedPreferences) {
    sharedPreferences = sharedPrefsInstance
  }

  fun put(key: String, value: String) {
    sharedPreferences.edit().putString(key, value).apply()
  }

  fun remove(key: String) {
    sharedPreferences.edit().remove(key).apply()
  }

  fun getAll(): Map<String, *> {
    return sharedPreferences.all
  }
}