package com.example.gameshelf.presentation.Screens

//Este es el Splash Screen, está programado para que salte a la siguiente pantalla a los 4 segundos.

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gameshelf.R
import com.example.gameshelf.navigation.Screen
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController){

    LaunchedEffect(key1 = true){
        delay(4000)
        navController.popBackStack() //limpia esta pantalla del stack de navegacion para no poder volver a ella
        navController.navigate(Screen.FirstScreen.route)

    }

    Splash()
}

@Composable
fun Splash(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(

            painter = painterResource(id = R.drawable.logo_circle_trans_black2),
            contentDescription = "Logo",
            Modifier.size(150.dp, 150.dp))
        Text(text = "Welcome to Game Shelf",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }


}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Splash()
}
