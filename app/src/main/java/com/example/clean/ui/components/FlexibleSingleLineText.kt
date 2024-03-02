package com.example.clean.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Custom text component for single line, flexible, non-overlapping
 * text which can be used in the list items.
 */
@Composable
fun FlexibleSingleLineText(
    modifier: Modifier = Modifier,
    text: String,
    textSize: TextUnit = 18.sp,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(fontSize = textSize, color = MaterialTheme.colorScheme.onBackground),
        maxLines = maxLines,
        overflow = overflow
    )
}