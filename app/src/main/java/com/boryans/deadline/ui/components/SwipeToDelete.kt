@file:OptIn(ExperimentalMaterial3Api::class)

package com.boryans.deadline.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.DismissDirection.EndToStart
import androidx.compose.material3.DismissDirection.StartToEnd
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun <T> SwipeToDeleteContainer(
  item: T,
  onDelete: (T) -> Unit,
  animationDuration: Int = 500,
  content: @Composable (T) -> Unit,
) {
  var isRemoved by remember {
    mutableStateOf(false)
  }
  val state = rememberDismissState(
    confirmValueChange = { value ->
      if (value == DismissValue.DismissedToStart) {
        isRemoved = true
        true
      } else {
        false
      }
    }
  )

  LaunchedEffect(key1 = isRemoved) {
    if (isRemoved) {
      delay(animationDuration.toLong())
      onDelete(item)
    }
  }

  AnimatedVisibility(
    visible = !isRemoved,
    exit = shrinkVertically(
      animationSpec = tween(durationMillis = animationDuration),
      shrinkTowards = Alignment.Top
    ) + fadeOut()
  ) {
    SwipeToDismiss(
      state = state,
      background = {
        DeleteBackground(swipeDismissState = state)
      },
      dismissContent = { content(item) },
      directions = setOf(EndToStart)
    )
  }
}

@Composable
fun DeleteBackground(
  swipeDismissState: DismissState,
) {
  var showIcon by remember {
    mutableStateOf(false)
  }

  showIcon = with(swipeDismissState) {
     progress in 0.2F..0.9F
  }

  val color = if (swipeDismissState.dismissDirection == StartToEnd) {
    Color.Transparent
  } else Color.Transparent

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(color)
      .padding(16.dp),
    contentAlignment = Alignment.CenterEnd
  ) {
    if (showIcon) {
      Icon(
        imageVector = Icons.Default.Delete,
        contentDescription = null,
        tint = Color.White,
      )
    }
  }
}