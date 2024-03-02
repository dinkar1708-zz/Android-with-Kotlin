package com.example.clean.ui.features.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean.di.DefaultDispatcher
import com.example.clean.domain.usecase.SearchRepositoryUseCase
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
class UsersListViewModel @Inject constructor(
    private val searchRepositoryUseCase: SearchRepositoryUseCase,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _uiState = MutableStateFlow(UsersListState())
    val uiState: StateFlow<UsersListState> = _uiState.asStateFlow()

    init {
        loadUsers()
    }

    private fun loadUsers() = viewModelScope.launch(dispatcher) {
        _uiState.update { UsersListState(isLoading = true) }

        searchRepositoryUseCase.searchUsers()
            .catch { exception ->
                _uiState.update {
                    UsersListState(
                        errorMessage = exception.localizedMessage
                            ?: "Error searching user list", // TODO: user string resource
                        isLoading = false
                    )
                }
            }
            .collect { userList ->
                _uiState.update {
                    UsersListState(
                        userList = userList,
                        isLoading = false
                    )
                }
            }
    }
}
