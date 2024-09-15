package com.example.lab06.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.intellij.lang.annotations.Language

import androidx.compose.material.*
import androidx.compose.runtime.*
import com.example.lab06.navigation.AppScreens

@Composable
fun Settings(navController: NavController) {
    var notificationsEnabled by remember { mutableStateOf(true) }
    var darkThemeEnabled by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf("English") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Configuración", style = MaterialTheme.typography.displaySmall)
        Spacer(modifier = Modifier.height(24.dp))

        //opción para activar o desactivar notificaciones
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Permitir Notificaciones")
            Spacer(modifier = Modifier.weight(1f))
            Switch(checked = notificationsEnabled, onCheckedChange = { notificationsEnabled = it })
        }

        Spacer(modifier = Modifier.height(16.dp))

        //opción para el tema oscuro
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Activar Tema Oscuro")
            Spacer(modifier = Modifier.weight(1f))
            Switch(checked = darkThemeEnabled, onCheckedChange = { darkThemeEnabled = it })
        }

        Spacer(modifier = Modifier.height(16.dp))

        //seleccionar Idioma
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Seleccionar Idioma")
            Spacer(modifier = Modifier.weight(1f))
            DropdownMenu(selectedLanguage = selectedLanguage, onLanguageSelected = { selectedLanguage = it })
        }

        Spacer(modifier = Modifier.height(32.dp))

        //botón para el guardado de cambios
        Button(
            onClick = {
                navController.navigate(route = AppScreens.PantallaInicio.route)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Guardar Cambios")
        }
    }
}

@Composable
fun DropdownMenu(selectedLanguage: String, onLanguageSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val languages = listOf("English", "Spanish", "French", "German")

    Box(
        modifier = Modifier.wrapContentSize(Alignment.TopStart)
    ) {
        Button(onClick = { expanded = true }) {
            Text(text = selectedLanguage)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            languages.forEach { language ->
                DropdownMenuItem(onClick = {
                    onLanguageSelected(language)
                    expanded = false
                }) {
                    Text(text = language)
                }
            }
        }
    }
}


