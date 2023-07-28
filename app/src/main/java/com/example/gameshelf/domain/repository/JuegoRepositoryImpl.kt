package com.example.gameshelf.domain.repository

import com.example.gameshelf.data.network.JuegoDao
import com.example.gameshelf.domain.model.Juego


//Implementa la interface JuegoRepository
//Cada funcion que definida en JuegoRepository debe estár implementada aquí.
//Implementación cuyas funciones están escritas en juegoDao (Insert y select)
//Con esto podemos acceder a los datos de los juegos almacenados en la base de datos local


class JuegoRepositoryImpl(
    private val juegoDao: JuegoDao
        ): JuegoRepository{
        override fun getJuegosFromRoom() = juegoDao.getJuegos()
        override fun addJuegoToRoom(juego: Juego) = juegoDao.addJuego(juego)
        override fun getJuegoFromRoom(id:String) = juegoDao.getJuego(id)
        override fun updateJuegoInRoom(juego: Juego) = juegoDao.updateJuego(juego)
        override fun deleteJuegoFromRoom(juego: Juego) = juegoDao.deleteJuego(juego)
    }

