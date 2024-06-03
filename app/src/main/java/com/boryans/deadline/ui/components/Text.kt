package com.boryans.deadline.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.boryans.deadline.ui.theme.DeadlineTheme

object Text {

  @Composable
  fun HeadlineLarge(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    fontFamily: FontFamily = FontFamily.Default,
    textColor: Color = Color.White,
  ) {
    Default(
      modifier = modifier,
      textAlign = textAlign,
      textColor = textColor,
      fontWeight = FontWeight.ExtraBold,
      text = text,
      fontFamily = fontFamily,
      fontSize = 45.sp
    )
  }

  @Composable
  fun Headline(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    textColor: Color = Color.White,
    maxLines: Int = 1,
    fontFamily: FontFamily = FontFamily.Default,
  ) {
    Default(
      modifier = modifier,
      textAlign = textAlign,
      textColor = textColor,
      fontWeight = FontWeight.ExtraBold,
      text = text,
      fontFamily = fontFamily,
      maxLines = maxLines,
      fontSize = 36.sp
    )
  }

  @Composable
  fun HeadlineSmall(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = 1,
    textColor: Color = Color.White,
    fontFamily: FontFamily = FontFamily.Default,
  ) {
    Default(
      modifier = modifier,
      textAlign = textAlign,
      textColor = textColor,
      fontWeight = FontWeight.ExtraBold,
      maxLines = maxLines,
      text = text,
      fontFamily = fontFamily,
      fontSize = 24.sp
    )
  }

  @Composable
  fun HeadlineExtraSmall(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    textColor: Color = Color.White,
    maxLines: Int = 1,
  ) {
    Default(
      modifier = modifier,
      textAlign = textAlign,
      textColor = textColor,
      fontWeight = FontWeight.ExtraBold,
      text = text,
      maxLines = maxLines,
      fontSize = 12.sp
    )
  }

  @Composable
  fun DefaultLarge(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    textColor: Color = Color.White,
    maxLines: Int = 1,
  ) {
    Default(
      modifier = modifier,
      textAlign = textAlign,
      textColor = textColor,
      text = text,
      maxLines = maxLines,
      fontSize = 17.sp
    )
  }

  @Composable
  fun Default(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    textColor: Color = Color.White,
    fontWeight: FontWeight = FontWeight.Normal,
    maxLines: Int = 1,
    textOverflow: TextOverflow = TextOverflow.Ellipsis,
    fontSize: TextUnit = 14.sp,
    fontFamily: FontFamily = FontFamily.Default,
  ) {
    androidx.compose.material3.Text(
      modifier = modifier,
      text = text,
      fontSize = fontSize,
      textAlign = textAlign,
      fontWeight = fontWeight,
      maxLines = maxLines,
      overflow = textOverflow,
      fontFamily = fontFamily,
      color = textColor,
    )
  }


}

@Preview
@Composable
private fun HeadlineLargePreview() {
  DeadlineTheme {
    Text.HeadlineLarge(text = "Headline large")
  }
}


@Preview
@Composable
private fun HeadlinePreview() {
  DeadlineTheme {
    Text.Headline(text = "Headline")
  }
}

@Preview
@Composable
private fun HeadlineSmallPreview() {
  DeadlineTheme {
    Text.HeadlineSmall(text = "Headline small")
  }
}

@Preview
@Composable
private fun HeadlineExtraSmallPreview() {
  DeadlineTheme {
    Text.HeadlineExtraSmall(text = "Headline extra small")
  }
}

@Preview
@Composable
private fun DefaultLargePreview() {
  DeadlineTheme {
    Text.DefaultLarge(text = "Default large")
  }
}

@Preview
@Composable
private fun DefaultPreview() {
  DeadlineTheme {
    Text.Default(text = "Default")
  }
}