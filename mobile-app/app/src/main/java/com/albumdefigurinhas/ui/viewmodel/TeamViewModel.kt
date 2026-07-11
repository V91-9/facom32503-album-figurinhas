package com.albumdefigurinhas.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albumdefigurinhas.data.model.Team
import com.albumdefigurinhas.domain.repository.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface TeamUiState {
    data object Loading : TeamUiState
    data class Success(val teams: List<Team>) : TeamUiState
    data class Error(val message: String) : TeamUiState
}

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val repository: TeamRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<TeamUiState>(TeamUiState.Loading)
    val uiState: StateFlow<TeamUiState> = _uiState.asStateFlow()

    init {
        loadTeams()
    }

    private fun loadTeams() {
        viewModelScope.launch {
            _uiState.value = TeamUiState.Loading
            
            try {
                repository.refreshTeams()
                repository.getAllTeams()
                    .catch { exception ->
                        _uiState.value = TeamUiState.Error("Erro ao ler o banco de dados: ${exception.message}")
                    }
                    .collect { teamList ->
                        _uiState.value = TeamUiState.Success(teamList)
                    }
            } catch (e: Exception) {
                _uiState.value = TeamUiState.Error("Falha na sincronização: ${e.message}")
            }
        }
    }
}