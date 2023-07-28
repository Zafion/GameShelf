package com.example.gameshelf.data.network

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import com.example.gameshelf.core.Constants.Companion.JUEGO_TABLE
import com.example.gameshelf.domain.model.Juego
import com.example.gameshelf.domain.repository.Juegos
import kotlinx.coroutines.flow.Flow

//Dao con acceso a datos - Data acces object - Base de datos local
@Dao
interface JuegoDao {
    @Query("SELECT * FROM $JUEGO_TABLE ORDER BY id ASC")
    fun getJuegos(): Flow<Juegos>

    @Insert(onConflict = IGNORE)
    fun addJuego(juego: Juego)

    @Query("SELECT * FROM $JUEGO_TABLE WHERE id = :id")
    fun getJuego(id: String): Juego

    @Update
    fun updateJuego(juego: Juego)

    @Delete
    fun deleteJuego(juego: Juego)

}