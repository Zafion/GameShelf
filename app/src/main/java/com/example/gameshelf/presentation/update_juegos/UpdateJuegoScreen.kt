package com.example.gameshelf.presentation.update_juegos

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gameshelf.data.network.JuegoDao
import com.example.gameshelf.presentation.juegos.JuegosViewModel
import com.example.gameshelf.presentation.update_juegos.components.UpdateJuegoContent

import com.example.gameshelf.presentation.update_juegos.components.UpdateJuegoTopBar


//Archivo con pantalla de actualización de juego, con parametros y el viewmodel en ejecucion
@Composable
fun UpdateJuegoScreen(
    viewModel: JuegosViewModel = hiltViewModel(),
    juegoId: String,
    navigateBack: () -> Unit,
    juegoDao: JuegoDao // Agregar el objeto JuegoDao como parámetro
){
    LaunchedEffect(Unit){
        viewModel.getJuego(juegoId)
    }
    Scaffold(
        topBar = {
            UpdateJuegoTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateJuegoContent(
                padding=padding,
                juego = viewModel.juego,
                updateNombre = { nombre ->
                    viewModel.updateNombre(nombre)
                },
                updateConsola = {consola ->
                    viewModel.updateConsola(consola)
                },
                updateJuego = {juego ->
                    viewModel.updateJuego(juego)
                    juegoDao.updateJuego(juego) // Actualizar el juego en la base de datos
                },
                navigateBack = navigateBack
            )

        }
    )

}
