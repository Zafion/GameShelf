package com.example.gameshelf.navigation
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.gameshelf.core.Constants.Companion.JUEGO_ID
import com.example.gameshelf.data.network.JuegoDao
import com.example.gameshelf.navigation.Screen.*
import com.example.gameshelf.presentation.Screens.*
import com.example.gameshelf.presentation.juegos.JuegosScreen
import com.example.gameshelf.presentation.update_juegos.UpdateJuegoScreen



//NavoHost con las Rutas de navegación de para las distintas pantallas
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NavGraph(
    navController: NavHostController,
    juegoDao: JuegoDao // Agregar el objeto JuegoDao como argumento
){
    NavHost(navController = navController,
        startDestination = SplashScreen.route){

        composable(
            route = JuegosScreen.route
        ){
            JuegosScreen(
                navigateToUpdateJuegoScreen = {
                        juegoId -> navController.navigate(
                    "${UpdateJuegoScreen.route}/${juegoId}")
                }
            )
        }

        composable(
            route = "${UpdateJuegoScreen.route}/{$JUEGO_ID}",
            arguments = listOf(
                navArgument(JUEGO_ID){
                    type = NavType.IntType
                }
            )
        ){
                backStackEntry ->
            val juegoId = backStackEntry.arguments?.getInt(JUEGO_ID)?.toString() ?: ""
            UpdateJuegoScreen(
                juegoId = juegoId,
                navigateBack = {
                    navController.popBackStack()
                },
                juegoDao = juegoDao // Pasar el objeto JuegoDao como argumento
            )
        }


        composable(
            route = SplashScreen.route
        ){
            SplashScreen(navController)
        }
        composable(
            route = FirstScreen.route
        ){
            FirstScreen(navController)
        }
        composable(SecondScreen.route){
            SecondScreen(navController)
        }

        composable(NesList.route){
            NesListScreen(
                navController = navController,
                juegoDao = juegoDao // Pasar el objeto JuegoDao como argumento
            )
        }

        composable(MsList.route){
            MsListScreen(
                navController = navController,
                juegoDao = juegoDao // Pasar el objeto JuegoDao como argumento
            )
        }

        composable(MdList.route){
            MdListScreen(
                navController = navController,
                juegoDao = juegoDao // Pasar el objeto JuegoDao como argumento
            )
        }

        composable(SnesList.route){
            SnesListScreen(
                navController = navController,
                juegoDao = juegoDao // Pasar el objeto JuegoDao como argumento
            )
        }

        composable(GbList.route){
            GbListScreen(
                navController = navController,
                juegoDao = juegoDao // Pasar el objeto JuegoDao como argumento
            )
        }

        composable(GgList.route){
            GgListScreen(
                navController = navController,
                juegoDao = juegoDao // Pasar el objeto JuegoDao como argumento
            )
        }
    }
}