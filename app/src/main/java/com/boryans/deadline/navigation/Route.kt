package com.boryans.deadline.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
  @Serializable
  data object Home : Route

  @Serializable
  data class DeadlineDetails(val deadlineId: String) : Route

  @Serializable
  data object AddDeadline : Route
}