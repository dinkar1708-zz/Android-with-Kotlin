package com.example.clean.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.clean.domain.model.User
import com.example.clean.ui.features.userrepository.UserRepoScreen
import com.example.clean.ui.features.userrepository.UserRepoScreenViewModel
import com.example.clean.ui.features.userrepository.UserSaver
import com.example.clean.ui.features.users.UsersListScreen
import com.example.clean.ui.features.users.UsersListViewModel


object MainDestinations {
    const val USERS_LIST_SCREEN_ROUTE = "users_list"
    const val USER_REPO_SCREEN_ROUTE = "user_repo"
}

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = MainDestinations.USERS_LIST_SCREEN_ROUTE
) {

    var searchedUser by rememberSaveable(stateSaver = UserSaver) { mutableStateOf(User()) }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(MainDestinations.USERS_LIST_SCREEN_ROUTE) {
            val viewModel: UsersListViewModel = hiltViewModel()
            UsersListScreen(viewModel = viewModel, onClick = {
                searchedUser = it
                navController.navigate(MainDestinations.USER_REPO_SCREEN_ROUTE)
            })
        }

        composable(MainDestinations.USER_REPO_SCREEN_ROUTE) {
            val viewModel: UserRepoScreenViewModel = hiltViewModel()
            viewModel.getUserRepositories(searchedUser)

            UserRepoScreen(viewModel = viewModel,
                onBackClick = { navController.popBackStack() })
        }
    }
}