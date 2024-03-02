package com.example.clean.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clean.ui.theme.AppLightTheme

@Composable
fun AppActionBarView(
    modifier: Modifier,
    headerText: String,
    showBackButton: Boolean = true,
    onBackClick: (() -> Unit) = {}
) {
    Box(
        modifier = modifier
            .shadow(elevation = 1.dp)
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(0.dp)
            ) {
                if (showBackButton) {
                    IconButton(
                        onClick = { onBackClick() }, modifier = Modifier.size(30.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(30.dp),
                        )
                    }
                }

                Text(
                    text = headerText,
                    textAlign = TextAlign.Start,
                    style = TextStyle(color = Color.White, fontSize = 20.sp),
                    modifier = if (showBackButton) Modifier.padding(horizontal = 40.dp) else Modifier
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenCommonHeaderPreviewWithAllComponents() {
    AppLightTheme {
        Surface {
            AppActionBarView(modifier = Modifier.fillMaxWidth(),
                headerText = "Institution",
                showBackButton = true,
                onBackClick = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenCommonHeaderPreview() {
    AppLightTheme {
        Surface {
            AppActionBarView(modifier = Modifier.fillMaxWidth(),
                headerText = "Institution",
                showBackButton = false,
                onBackClick = {})
        }
    }
}