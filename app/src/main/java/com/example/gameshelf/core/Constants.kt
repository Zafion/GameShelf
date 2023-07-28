package com.example.gameshelf.core


//Constantes del proyecto
class Constants {
    companion object{   //Usamos companion para poder usar la constante en cualquier lugar
        //Room
        const val JUEGO_TABLE = "juego_table"

        //Screens
        const val JUEGOS_SCREEN = "Juegos"
        const val UPDATE_JUEGOS_SCREEN = "Update juego"
        const val SPLASH_SCREEN = "Splash"
        const val FIRST_SCREEN = "Inicio"
        const val SECOND_SCREEN = "Biblioteca"
        const val NES_LIST = "Listado de Nes"
        const val MS_LIST = "Listado de Master System"
        const val MD_LIST = "Listado de Mega Drive"
        const val SNES_LIST = "Listado de Super Nes"
        const val GB_LIST = "Listado de Game Boy"
        const val GG_LIST = "Listado de Game Gear"


        //Arguments
        const val JUEGO_ID = "juegoId"

        //Actions
        const val ADD_JUEGO = "Agregar juego"
        const val DELETE_JUEGO = "Borrar un juego"

        //Buttons para datos de colección local de usuario con Room
        const val ADD = "Agregar"
        const val DISMISS = "Cancelar"
        const val UPDATE = "Modificar"

        //Placeholders de colección local de usuario con Room
        const val NOMBRE = "Nombre del juego..."
        const val CONSOLA = "Escribe de que consola es"
        const val NO_VALUE = ""
    }
}