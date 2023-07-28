package com.example.gameshelf.presentation.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gameshelf.data.network.JuegoDao
import com.example.gameshelf.presentation.games.Viewmodels.MsListViewmodel
import com.example.gameshelf.presentation.games.components.GameList

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterialApi
@Composable

fun MsListScreen (navController: NavController, juegoDao: JuegoDao) {
    Scaffold(topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Estantería de Master System")
        }
    },

    modifier = Modifier.fillMaxSize()
    ) {

        val viewModel : MsListViewmodel = hiltViewModel()
        val state = viewModel.state.value
        val isRefreshing = viewModel.isRefreshing.collectAsState()

        GameList(
            state = state,
            isRefreshing = isRefreshing.value,
            refreshData = viewModel::getGameList,
            juegoDao = juegoDao
        )
    }
}