package com.example.gameshelf.presentation.juegos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.example.gameshelf.core.Constants.Companion.ADD
import com.example.gameshelf.core.Constants.Companion.ADD_JUEGO
import com.example.gameshelf.core.Constants.Companion.CONSOLA
import com.example.gameshelf.core.Constants.Companion.DISMISS
import com.example.gameshelf.core.Constants.Companion.NOMBRE
import com.example.gameshelf.core.Constants.Companion.NO_VALUE
import com.example.gameshelf.domain.model.Juego
import kotlinx.coroutines.job



@Composable
fun AddJuegoAlertDialog(
    //Le pasamos el estado de dialogo (abierto o no) y la funcion que cierra el cuadro de dialogo, además de la que agrega el nuevo juego
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addJuego: (juego: Juego) -> Unit
) {
    //Si la variable está en true, saca un componente AlertDialog.
    if (openDialog){
        //Utilizamos las variables nombre y consola para que el usuario escriba en los campos de texto
        var nombre by remember { mutableStateOf(NO_VALUE) }
        var consola by remember { mutableStateOf(NO_VALUE) }
        //Con focusrequest mandamos el foco al primer campo
        val focusRequester = FocusRequester()

        //Con alertDialog creamos el cuadro de dialogo y se configuran los atributos, onDismissRequest es para cerrar el dialogo
        AlertDialog(onDismissRequest = { closeDialog }, title = {
           Text(ADD_JUEGO) 
            }, text = { //En text van los campos donde el usuario escribirá el nombre y la consola
                Column {
                    TextField(value = nombre, onValueChange = { nombre=it }, placeholder = { Text(NOMBRE)},
                        modifier = Modifier.focusRequester(focusRequester)) //Al pimer campo le incamos que obtenga el foco
                LaunchedEffect(Unit){
                    coroutineContext.job.invokeOnCompletion {
                        focusRequester.requestFocus()
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                TextField(value = consola, onValueChange = {consola=it}, placeholder = { Text(CONSOLA)})
                }
            },
            confirmButton = {   //Ponemos un boton para cerrar el cuadro de dialogo y creara un nuevo objeto juego con los datos introducido.

                TextButton(
                    onClick = {
                        closeDialog()
                        val juego = Juego("", nombre, consola,0,"","")
                        addJuego(juego) //Tambien ejecuta addjuego que envia el objeto juego al viewModel.
                }) {
                    Text(ADD)

                }
            },
            dismissButton = {   //Boton que llama a closedialog del viewmodel
                TextButton(onClick = closeDialog) {
                    Text(DISMISS)
                
                }
            }
        )
    }

}