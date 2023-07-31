package com.example.gameshelf.presentation.games.states

import com.example.gameshelf.domain.model.Game

data class GameListState (
    val isLoading: Boolean = false,
    val games: List<Game> = emptyList(),
    val error: String = ""
)