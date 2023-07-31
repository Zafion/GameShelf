package com.example.gameshelf.presentation.juegos.components
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.gameshelf.domain.model.Juego
import com.example.gameshelf.domain.repository.Juegos


//Contenido que incluye la lista de juegos
@Composable
fun JuegosContent(
    //recibe el padding de su componente padre y el objeto juegos que contiene la lista de juegos de la bd
    padding: PaddingValues,
    juegos: Juegos,
    deleteJuego: (juego: Juego) -> Unit,
    navigateToUpdateJuegoScreen: (juegoId: String) -> Unit

){
    //LazyColumn para mostrar la lista de elementos
    LazyColumn(modifier = Modifier.fillMaxSize().padding(padding)
    ){
        //Los elementos del LazyColumn los definen el contenido del archivo JuegoCard al que le pasamos los elementos de la lista
        items (juegos){
            juego->
            JuegoCard(
                juego = juego,
                deleteJuego = {
                    deleteJuego(juego)
                },
                navigateToUpdateJuegoScreen = navigateToUpdateJuegoScreen
            )
        }
    }
}

