package com.example.clean.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun StateContentBox(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    errorMessage: String,
    content: @Composable () -> Unit
) {
    Box(modifier) {
        when {
            isLoading -> {
                SharedProgressIndicator()
            }

            errorMessage.isNotEmpty() -> {
                Text(
                    text = errorMessage,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }

            else -> {
                content()
            }
        }
    }
}
