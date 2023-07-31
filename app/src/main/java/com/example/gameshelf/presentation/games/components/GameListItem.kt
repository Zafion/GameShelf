package com.example.gameshelf.presentation.games.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.gameshelf.domain.model.Game
import com.example.gameshelf.presentation.games.components.GameUtils.copyGameToLocalDatabase
import com.example.gameshelf.ui.theme.Red100
import com.example.gameshelf.ui.theme.Yellow600
import com.example.gameshelf.data.network.JuegoDao


@ExperimentalMaterialApi
@Composable
fun GameListItem(game: Game, juegoDao: JuegoDao) {
    Card(
        elevation = 0.dp
    ){
        // Definir el diseño de la lista de juegos
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Mostrar la portada del juego
            Image(
                painter = rememberImagePainter(game.coverURL),
                contentDescription = game.title,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            // Mostrar el título y la plataforma del juego
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = game.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = game.platform,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            // Agregar un botón para copiar el juego a la base de datos local
            Button(
                onClick = { copyGameToLocalDatabase(game, juegoDao) },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Red100
                )
            ) {
                Text(
                    text = "Copiar a tu colección.",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }

    }
}