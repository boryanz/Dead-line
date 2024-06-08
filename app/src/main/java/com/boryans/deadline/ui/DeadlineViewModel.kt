package com.boryans.deadline.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner

@Stable
abstract class DeadlineViewModel<UiState, UiEvent> : ViewModel() {
  @Composable
  abstract fun getUiState(): UiState

  abstract fun onEvent(uiEvent: UiEvent)
}

@Composable
inline fun <reified T : ViewModel> screenScopedViewModel(
  factory: ViewModelProvider.Factory? = null,
): T {
  val viewModelStoreOwner = LocalViewModelStoreOwner.current
  requireNotNull(viewModelStoreOwner) { "No ViewModelStoreOwner provided" }
  val viewModelProvider = factory?.let {
    ViewModelProvider(viewModelStoreOwner, it)
  } ?: ViewModelProvider(viewModelStoreOwner)
  return viewModelProvider[T::class.java]
}