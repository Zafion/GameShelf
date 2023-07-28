package com.example.gameshelf.presentation.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gameshelf.R
import com.example.gameshelf.navigation.Screen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
//Con Navcontroller llamamos al control de desplazamiento
//Con text: String? estamos indicando que puede recibir un texto desde la primera pantalla
fun SecondScreen(navController: NavController){
    Scaffold (topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "La Gran Biblioteca")
        }
    }) {
        Box(modifier = Modifier.fillMaxSize()) {
        }
        // Agregamos la imagen de fondo
        Image(
            painter = painterResource(R.drawable.fondo2),
            contentDescription = "Fondo segunda pantalla",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        val scrollState = rememberScrollState()
        Column( //Modificadores para que ocupe toda la pantalla y esté centrado
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Text(
//                modifier = Modifier
//                    .background(color = Color.Black, shape = RoundedCornerShape(8.dp))
//                    .padding(8.dp)
//                    .fillMaxWidth()
//                    .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(8.dp)),
//                text = "¿De que sistema buscas información?",
//                color = Color.LightGray,
//                textAlign = TextAlign.Center,
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold
//            )

            Spacer(modifier = Modifier.height(25.dp))

            //Boton que llama al navController para ir a NES.
            Button(
                modifier = Modifier
                    .width(350.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(color = Color.Black)
                    .border(2.dp, color = Color.LightGray, shape = RoundedCornerShape(24.dp)),
                onClick = {
                    navController.navigate(Screen.NesList.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            ) {
                Text(text = "Nintendo Entertaiment System (NES)", color = Color.LightGray, fontWeight = FontWeight.Bold,fontSize = 15.sp)
            }

            Spacer(modifier = Modifier.height(25.dp))

            //Boton que llama al navController para ir Master System.
            Button(
                modifier = Modifier
                    .width(350.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(color = Color.Black)
                    .border(2.dp, color = Color.LightGray, shape = RoundedCornerShape(24.dp)),
                onClick = {
                    navController.navigate(Screen.MsList.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            ) {
                Text(text = "Sega Master System", color = Color.LightGray, fontWeight = FontWeight.Bold,fontSize = 15.sp)
            }

            Spacer(modifier = Modifier.height(25.dp))

            //Boton que llama al navController para ir a Megadrive.
            Button(
                modifier = Modifier
                    .width(350.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(color = Color.Black)
                    .border(2.dp, color = Color.LightGray, shape = RoundedCornerShape(24.dp)),
                onClick = {
                    navController.navigate(Screen.MdList.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            ) {
                Text(text = "Sega Mega Drive", color = Color.LightGray, fontWeight = FontWeight.Bold,fontSize = 15.sp)
            }

            Spacer(modifier = Modifier.height(25.dp))

            //Boton que llama al navController para ir a Snes.
            Button(
                modifier = Modifier
                    .width(350.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(color = Color.Black)
                    .border(2.dp, color = Color.LightGray, shape = RoundedCornerShape(24.dp)),
                onClick = {
                    navController.navigate(Screen.SnesList.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            ) {
                Text(text = "Super Nintendo (SNES)", color = Color.LightGray, fontWeight = FontWeight.Bold,fontSize = 15.sp)
            }

            Spacer(modifier = Modifier.height(25.dp))

            //Boton que llama al navController para ir a GameBoy.
            Button(
                modifier = Modifier
                    .width(350.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(color = Color.Black)
                    .border(2.dp, color = Color.LightGray, shape = RoundedCornerShape(24.dp)),
                onClick = {
                    navController.navigate(Screen.GbList.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            ) {
                Text(text = "Game Boy", color = Color.LightGray, fontWeight = FontWeight.Bold,fontSize = 15.sp)
            }

            Spacer(modifier = Modifier.height(25.dp))

            //Boton que llama al navController para ir a GameGear.
            Button(
                modifier = Modifier
                    .width(350.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(color = Color.Black)
                    .border(2.dp, color = Color.LightGray, shape = RoundedCornerShape(24.dp)),
                onClick = {
                    navController.navigate(Screen.GgList.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            ) {
                Text(text = "Game Gear", color = Color.LightGray, fontWeight = FontWeight.Bold,fontSize = 15.sp)
            }

            Spacer(modifier = Modifier.height(25.dp))

//            //Boton que llama al navController para ir a FirstScreen
//            Button(
//                modifier = Modifier
//                    .width(350.dp)
//                    .height(48.dp)
//                    .clip(RoundedCornerShape(24.dp))
//                    .background(color = Color.Black)
//                    .border(2.dp, color = Color.LightGray, shape = RoundedCornerShape(24.dp)),
//                onClick = {
//                    navController.navigate(Screen.FirstScreen.route)
//                },
//                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
//            ) {
//                Text(text = "Volver a Inicio", color = Color.LightGray, fontWeight = FontWeight.Bold,fontSize = 15.sp)
//            }

        }
    }
}



