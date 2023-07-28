package com.example.gameshelf.domain.model

//Entidad principal a almacenar: el Juego de la DB Firebase
//Tambien está el constructor para poder generar nuevos objetos game en la base de datos en caso de ser necesário.

data class Game(
    val id: String, //Id que es a su vez primary key del Game
    val coverURL: String,   //String con la ruta a la portada del juego
    val title : String,
    val platform: String,
    val year: Int,
    val genere: String
){
    constructor() : this("", "", "", "", 0, "")
}