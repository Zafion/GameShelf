package com.example.gameshelf.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gameshelf.core.Constants.Companion.JUEGO_TABLE
import java.util.*

//Entidad principal a almacenar: el Juego en colección local de usuario con Room
@Entity(tableName = JUEGO_TABLE)

data class Juego(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val nombre: String,
    val consola: String,
    val año: Int = 0,   // valor por defecto
    val genero: String = "",
    val portadaURL: String = ""


)
