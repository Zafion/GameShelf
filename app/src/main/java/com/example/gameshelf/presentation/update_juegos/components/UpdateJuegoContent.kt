package com.example.gameshelf.presentation.update_juegos.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gameshelf.core.Constants.Companion.NOMBRE
import com.example.gameshelf.core.Constants.Companion.UPDATE
import com.example.gameshelf.core.Constants.Companion.CONSOLA
import com.example.gameshelf.domain.model.Juego



@Composable
fun UpdateJuegoContent(
    padding: PaddingValues,
    juego: Juego,
    updateNombre: (nombre : String) -> Unit,
    updateConsola: (consola: String) -> Unit,
    updateJuego: (juego: Juego) -> Unit,
    navigateBack: ()-> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = juego.nombre, onValueChange = {nombre -> updateNombre(nombre)}, placeholder = {Text(NOMBRE)} )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = juego.consola, onValueChange = {consola -> updateConsola(consola)}, placeholder = {Text(CONSOLA)} )
        Button(
            onClick = {
                updateJuego(juego)
                navigateBack()
            }
        ) {
            Text(UPDATE)
        }

    }
}