package com.example.lab06.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lab06.navigation.AppScreens

@Composable
fun CustomScaffold(navController: NavController) {
    Scaffold(
        topBar = { CustomTopBar(navController) },
        bottomBar = { CustomBottomBar(navController) },
        floatingActionButton = { CustomFAB() },
        content = { padding ->
            CustomContent(padding)
        }
    )
}

@Composable
fun CustomContent(padding: PaddingValues) {
    Column(
        // Modificadores de estilo de la columna
        modifier = Modifier
            // Ocupar todo el espacio disponible
            .fillMaxSize()
            .padding(padding),

        // Contenido de la aplicación
        content = {
            Text(text = "My app content")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: NavController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
            }
        },
        title = { Text(text = "Sample Title") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null
                )
            }
            IconButton(onClick = {
                navController.navigate(route = AppScreens.Profile.route)
            }) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
fun CustomBottomBar(navController: NavController) {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            IconButton(onClick = {
                navController.navigate(route = AppScreens.Settings.route)
            }) {
                Icon(Icons.Filled.Settings, contentDescription = "Build description")
            }
            IconButton(onClick = {
                navController.navigate(route = AppScreens.Info.route)
            }) {
                Icon(
                    Icons.Filled.Info,
                    contentDescription = "Menu description",
                )
            }
        }
    }
}


@Composable
fun CustomFAB() {
    FloatingActionButton(
        // Color de fondo
        //backgroundColor = MaterialTheme.colors.primary,
        // Acción al hacer clic en el botón (sin definir)
        onClick = { /*TODO*/ }) {
        Text(
            fontSize = 24.sp, // Tamaño de fuente del texto del botón
            text = "+" // Texto del botón
        )
    }
}
