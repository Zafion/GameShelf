package com.example.gameshelf.presentation.juegos.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.gameshelf.domain.model.Juego


//Funcion que plasma cada item del listado
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun JuegoCard(
    juego: Juego,
    deleteJuego: () -> Unit,
    navigateToUpdateJuegoScreen: (juegoId: String) -> Unit


){
    //utiliza el componente Card para mostrar los datos del juego y su consola
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
            .fillMaxWidth(), elevation = 3.dp, onClick = {navigateToUpdateJuegoScreen(juego.id)}
    ) {
        //componente Row para mostrar datos de juego con icono de elimiar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(juego.nombre)
                Text(juego.consola)
            }
            Spacer(modifier = Modifier.weight(1f))
            DeleteIcon(
                deleteJuego = deleteJuego
            )

        }

    }

}