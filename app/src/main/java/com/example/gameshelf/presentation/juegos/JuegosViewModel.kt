package com.example.gameshelf.presentation.juegos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameshelf.core.Constants.Companion.NO_VALUE
import com.example.gameshelf.domain.model.Juego
import com.example.gameshelf.domain.repository.JuegoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

//ViewModel, maneja la comunicación entre la vista, el modelo, etc.
//debemos plasmar todos los eventos que realkizan cambios en la interfax de usuario

@HiltViewModel
class JuegosViewModel @Inject constructor(
    private val repo: JuegoRepository
): ViewModel(){

    var juego by mutableStateOf(Juego(NO_VALUE, NO_VALUE, NO_VALUE, 0, NO_VALUE, NO_VALUE))
    //Variable de estado que controla cuando se crea un nuevo juego
    var openDialog by mutableStateOf(false)
    //Desde aqui llamamos a la función getJuegos que nos devuelve la lista de juegos
    val juegos = repo.getJuegosFromRoom()

    //Funcion que llama a la funcion que añade un juego, usamos viewmodelScope.launch para hacerlo asíncrona
    fun addJuego(juego: Juego)= viewModelScope.launch (Dispatchers.IO){
        repo.addJuegoToRoom(juego)
    }
    //Funciones para abrir el cuadro de dialogo para agregar un juevo juego y otra para cerrarlo
    //Alteran la variable de estado que controlará si se muestra o no el cuadro de dialogo
    fun opendialog(){
        openDialog = true
    }
    fun closeDialog(){
        openDialog = false
    }
    //Funciones para que al borrar o actualizar, lo actualice en el objeto juego que está en memoria juego
    //Con Launch y LaunchedEffect lo hacemos de forma asincrona
    fun deleteJuego(juego: Juego) = viewModelScope.launch ( Dispatchers.IO ){
        repo.deleteJuegoFromRoom(juego)
    }

    fun updateNombre(nombre: String) {
        juego = juego.copy(
            nombre = nombre
        )
    }

    fun updateConsola(consola: String) {
        juego = juego.copy(
            consola = consola
        )
    }
    fun updateJuego(juego: Juego) = viewModelScope.launch ( Dispatchers.IO ){
        repo.updateJuegoInRoom(juego)
    }

    fun getJuego(id: String) = viewModelScope.launch (
        Dispatchers.IO
        ){
            juego = repo.getJuegoFromRoom(id)
    }
}

