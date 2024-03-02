package com.example.clean

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.clean.ui.MVVMCleanUI
import com.example.clean.ui.theme.AppLightTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
// https://developer.android.com/training/dependency-injection/hilt-android?_gl@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppLightTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    // A surface container using the 'background' color from the theme
                    color = MaterialTheme.colorScheme.background
                ) {
                    MVVMCleanUI()
                }
            }
        }
    }
}