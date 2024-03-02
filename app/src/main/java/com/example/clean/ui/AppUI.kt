package com.example.clean.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MVVMCleanUI() {
    val navController = rememberNavController()
    NavGraph(
        navController = navController,
        startDestination = MainDestinations.USERS_LIST_SCREEN_ROUTE
    )
}