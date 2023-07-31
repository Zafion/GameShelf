package com.example.gameshelf.presentation.update_juegos.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import com.example.gameshelf.core.Constants.Companion.UPDATE_JUEGOS_SCREEN


@Composable
fun UpdateJuegoTopBar(
    navigateBack: () -> Unit
){
    TopAppBar(
        title = {
            Text(UPDATE_JUEGOS_SCREEN)
        },
        navigationIcon = {
            IconButton(onClick = {navigateBack()}) {
                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
                
            }
        }
    )
}
