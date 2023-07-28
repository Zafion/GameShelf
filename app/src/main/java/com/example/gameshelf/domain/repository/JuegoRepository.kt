package com.example.gameshelf.domain.repository

import com.example.gameshelf.domain.model.Juego
import kotlinx.coroutines.flow.Flow

//Repositorio para juegos de la base de datos local hecha con Room con funciones para acceder, añadir actualizar y borrar, algunas sin uso de momento.

typealias Juegos = List<Juego>
interface JuegoRepository {
    fun getJuegosFromRoom() : Flow<Juegos>
    fun addJuegoToRoom(juego: Juego)
    fun getJuegoFromRoom(id:String): Juego
    fun updateJuegoInRoom (juego: Juego)
    fun deleteJuegoFromRoom(juego: Juego)
}