package com.example.gameshelf.presentation.juegos.components


import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.example.gameshelf.core.Constants.Companion.ADD_JUEGO


@Composable
fun AddJuegoFlotatingActionButton( //Recibe la funcion para abrir el cuadro de dialogo
    openDialog: () -> Unit
){
    FloatingActionButton(   // Usa componente FloatingActionButton para llamar la funcion openDialog delviewModel cuando se genere el evento clic, lo que cambia el valor de la variable de estado, que mostrará el cuadro de dialogo con icono
        onClick = openDialog, backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = ADD_JUEGO)

    }

}