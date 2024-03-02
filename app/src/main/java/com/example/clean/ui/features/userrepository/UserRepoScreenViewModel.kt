package com.example.clean.ui.features.userrepository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean.di.DefaultDispatcher
import com.example.clean.domain.model.User
import com.example.clean.domain.usecase.UserRepositoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserRepoScreenViewModel @Inject constructor(
    private val userRepositoryUseCase: UserRepositoryUseCase,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _uiState = MutableStateFlow(UserRepoViewState())
    val uiState: StateFlow<UserRepoViewState> = _uiState.asStateFlow()

    fun getUserRepositories(user: User) = viewModelScope.launch(dispatcher) {
        _uiState.update { UserRepoViewState(isLoading = true) }

        userRepositoryUseCase.searchUserRepositories(
            login = user.login,
        ).catch { exception ->
            _uiState.update {
                UserRepoViewState(
                    errorMessage = exception.localizedMessage ?: "Error fetching repositories.",
                    isLoading = false
                )
            }
        }.collect { repositories ->
            _uiState.update {
                UserRepoViewState(
                    selectedUser = user,
                    repositories = repositories,
                    isLoading = false
                )
            }
        }

    }
}