package com.example.lab06.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab06.R
import com.example.lab06.navigation.AppNavigation
import com.example.lab06.navigation.AppScreens

@Composable
fun Info(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "PROGRAMACIÓN EN MOVILES",
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(bottom = 20.dp)
            )
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.android),
                contentDescription = "",
                modifier = Modifier
                    .size(250.dp)
                    .padding(bottom = 24.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "- Identificar las principales características del entorno de desarrollo Android Studio.\n" +
                        "- Crear aplicaciones Android que puedan ser ejecutadas en un dispositivo Móvil.\n" +
                        "- Implementar aplicaciones que hagan uso de los recursos disponibles en un Dispositivo Móvil.\n" +
                        "- Implementar aplicaciones que consulten información de bases de datos por medio de servicios Web.",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }

        Button(
            onClick = {
                navController.navigate(route = AppScreens.PantallaInicio.route)
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text(text = "Regresar")
        }
    }
}