package com.example.gameshelf.presentation.juegos


import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gameshelf.presentation.juegos.components.AddJuegoAlertDialog
import com.example.gameshelf.presentation.juegos.components.AddJuegoFlotatingActionButton
import com.example.gameshelf.presentation.juegos.components.JuegosContent




@Composable
fun JuegosScreen(

    viewModel: JuegosViewModel = hiltViewModel(),
    navigateToUpdateJuegoScreen: (juegoId: String) -> Unit
){
    //Usamos una variable de estado para guardar el contenido de la lista de juegos obtenidos a traves de viewModel
    val juegos by viewModel.juegos.collectAsState(
        initial = emptyList() )
    Scaffold (topBar = {
            TopAppBar(
                title = {
                Text(text = "Tu colección de Juegos")
            })
        },
        //El contenido de Scaffold lo tendremos en otros dos archivos
        content = {
            padding->
            JuegosContent(  //Le pasamos el padding acutual y el valor de juegos que nos da el viewmodel, tambíen las funciones.
                padding = padding,
                juegos = juegos,
                deleteJuego = { juego -> viewModel.deleteJuego(juego) },
                navigateToUpdateJuegoScreen = navigateToUpdateJuegoScreen
            )
            AddJuegoAlertDialog(    //Permite abir y cerrar el cuadro de dialogo y guardar un nuevo objeto en la db
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addJuego = {juego->
                    viewModel.addJuego(juego)
                }
            )
        },
        //Boton flotante que abre el cuadro de dialogo para añadir juego
        floatingActionButton ={
            AddJuegoFlotatingActionButton(
                openDialog = {
                    viewModel.opendialog()
                }
            )
        }
    )

}