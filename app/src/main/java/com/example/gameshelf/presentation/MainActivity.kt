package com.example.gameshelf.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gameshelf.data.network.JuegoDB
import com.example.gameshelf.navigation.NavGraph
import com.example.gameshelf.ui.theme.GameShelfTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint  //Anotación Android Entry Point para que se ejecuten los componentes de Hilt
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val juegoDB = JuegoDB.getDatabase(this)
        val juegoDao = juegoDB.juegoDao() // Inicializar el objeto JuegoDao

        setContent {
            GameShelfTheme {
                navController = rememberNavController()
                NavGraph(
                    navController = navController,
                    juegoDao = juegoDao // Pasar el objeto JuegoDao como argumento
                )
            }
        }
    }
}




