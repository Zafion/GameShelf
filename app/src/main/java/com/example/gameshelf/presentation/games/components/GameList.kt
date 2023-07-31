package com.example.gameshelf.presentation.games.components

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.DismissDirection.*
import androidx.compose.material.DismissValue.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.gameshelf.data.network.JuegoDao
import com.example.gameshelf.presentation.games.states.GameListState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState



@ExperimentalMaterialApi
@Composable
fun GameList(
    state: GameListState,
    isRefreshing: Boolean,
    refreshData: () -> Unit,
    juegoDao: JuegoDao // Agregar el objeto JuegoDao como argumento
) {
    var searchTerm by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            OutlinedTextField(
                value = searchTerm,
                onValueChange = { searchTerm = it },
                label = { Text("Buscar juego") },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            )

            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing),
                onRefresh = refreshData
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(
                        items = state.games.filter { it.title.contains(searchTerm, ignoreCase = true) }
                    ) { game ->
                        // Pasar el objeto JuegoDao como argumento
                        GameListItem(game = game, juegoDao = juegoDao)
                    }
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
                    .align(Alignment.Center),
                text = state.error,
                color = Color.Red,
                textAlign = TextAlign.Center
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}