package com.example.gameshelf.presentation.games.components

import com.example.gameshelf.data.network.JuegoDao
import com.example.gameshelf.domain.model.Game
import com.example.gameshelf.domain.model.Juego
import com.google.firebase.firestore.FirebaseFirestore

object GameUtils {

    // Función para copiar el juego de Firestore a la base de datos local de Room
    fun copyGameToLocalDatabase(game: Game, juegoDao: JuegoDao) {
        // Obtener una instancia de Firebase Firestore
        val firestore = FirebaseFirestore.getInstance()

        // Obtener una referencia al documento del juego en Firestore
        val gameRef = firestore.collection("games").document(game.id)

        // Obtener el juego original de Firestore
        gameRef.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                val originalGame = document.toObject(Game::class.java)

                // Convertir el año a un entero utilizando el método toIntOrNull()
                val year = originalGame?.year?.toString()?.toIntOrNull() ?: 0

                // Crear un objeto Juego a partir del objeto Game original
                val juego = Juego(
                    id = originalGame?.id ?: "",
                    nombre = originalGame?.title ?: "",
                    consola = originalGame?.platform ?: "",
                    año = year,
                    genero = originalGame?.genere ?: "",
                    portadaURL = originalGame?.coverURL ?: ""
                )

                // Guardar una copia del juego en la base de datos local de Room
                juegoDao.addJuego(juego)
            }
        }
    }
}