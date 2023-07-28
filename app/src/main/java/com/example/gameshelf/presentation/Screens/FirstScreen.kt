package com.example.gameshelf.presentation.Screens

//Esta es la pantalla de bienvenida, desde aqui podemos acceder a:
//La biblioteca (Segunda pantalla)
//La colección (Tercera pantalla)

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gameshelf.R
import com.example.gameshelf.navigation.Screen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FirstScreen(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar() {
            Text(text = "Inicio")
        }
    }) {
        Box(modifier = Modifier.fillMaxSize()) {

        }
        Image(
            painter = painterResource(id = R.drawable.fondo1),
            contentDescription = "Fondo primera pantalla",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column( //Modificadores para que ocupe toda la pantalla y esté centrado
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Text(
//                modifier = Modifier
//                    .background(color = Color.Black, shape = RoundedCornerShape(8.dp))
//                    .padding(8.dp)
//                    .fillMaxWidth()
//                    .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(8.dp))
//                    .shadow(4.dp, shape = RoundedCornerShape(8.dp)),
//                text = "¿En qué te podemos ayudar?",
//                color = Color.LightGray,
//                textAlign = TextAlign.Center,
//                fontSize = 25.sp,
//                fontWeight = FontWeight.Bold
//            )
            Spacer(modifier = Modifier.height(25.dp))
            //Boton que llama al navController para ir a SecondScreen
            Button(
                modifier = Modifier
                    .width(350.dp)
                    .padding(vertical = 16.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(color = Color.Black)
                    .border(2.dp, Color.LightGray, shape = RoundedCornerShape(24.dp)),
                onClick = {
                    navController.navigate(Screen.SecondScreen.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            ) {
                Text(text = "Consultar la Gran Biblioteca", fontWeight = FontWeight.Bold, color = Color.LightGray,fontSize = 15.sp)
            }

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                modifier = Modifier
                    .width(350.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(color = Color.Black)
                    .border(2.dp, Color.LightGray, shape = RoundedCornerShape(24.dp)),
                onClick = {
                    navController.navigate(Screen.JuegosScreen.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            ) {
                Text(text = "Ir a tu colección", fontWeight = FontWeight.Bold, color = Color.LightGray,fontSize = 15.sp)
            }
        }
    }
}


