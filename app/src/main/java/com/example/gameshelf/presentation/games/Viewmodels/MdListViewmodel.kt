package com.example.gameshelf.presentation.games.Viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameshelf.domain.repository.GameRepository
import com.example.gameshelf.domain.repository.Result
import com.example.gameshelf.presentation.games.states.GameListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MdListViewmodel
@Inject constructor(
    private val gameRepository: GameRepository
): ViewModel(){

    private val _state: MutableState<GameListState> = mutableStateOf(GameListState())
    val state: State<GameListState> = _state

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing : StateFlow<Boolean> = _isRefreshing

    init {
        getGameList()
    }

    fun getGameList(){
        gameRepository.getMdGameList().onEach { result ->
            when(result) {
                is Result.Error -> {
                    _state.value = GameListState(error = result.message?: "Error Inesperado")
                }
                is Result.Loading -> {
                    _state.value = GameListState(isLoading = true)
                }
                is Result.Success -> {
                    _state.value = GameListState(games = result.data?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}