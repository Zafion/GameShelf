package com.example.gameshelf.presentation.juegos.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import com.example.gameshelf.core.Constants.Companion.DELETE_JUEGO


@Composable
fun DeleteIcon(
    deleteJuego: () -> Unit
){
    IconButton(onClick = deleteJuego) {
        Icon(imageVector = Icons.Default.Delete, contentDescription = DELETE_JUEGO)
    }
}