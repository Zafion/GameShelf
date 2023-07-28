package com.example.gameshelf.navigation


import com.example.gameshelf.core.Constants.Companion.FIRST_SCREEN
import com.example.gameshelf.core.Constants.Companion.GB_LIST
import com.example.gameshelf.core.Constants.Companion.GG_LIST
import com.example.gameshelf.core.Constants.Companion.JUEGOS_SCREEN
import com.example.gameshelf.core.Constants.Companion.MD_LIST
import com.example.gameshelf.core.Constants.Companion.MS_LIST
import com.example.gameshelf.core.Constants.Companion.NES_LIST
import com.example.gameshelf.core.Constants.Companion.SECOND_SCREEN
import com.example.gameshelf.core.Constants.Companion.SNES_LIST
import com.example.gameshelf.core.Constants.Companion.SPLASH_SCREEN
import com.example.gameshelf.core.Constants.Companion.UPDATE_JUEGOS_SCREEN

//Clase sellada con subclases de las pantallas con su ruta asociada.
sealed class Screen(val route: String){
    object JuegosScreen: Screen(JUEGOS_SCREEN)
    object UpdateJuegoScreen: Screen(UPDATE_JUEGOS_SCREEN)
    object SplashScreen: Screen(SPLASH_SCREEN)
    object FirstScreen: Screen(FIRST_SCREEN)
    object SecondScreen: Screen(SECOND_SCREEN)
    object NesList : Screen(NES_LIST)
    object MsList : Screen(MS_LIST)
    object MdList : Screen(MD_LIST)
    object SnesList : Screen(SNES_LIST)
    object GbList : Screen(GB_LIST)
    object GgList : Screen(GG_LIST)

}
