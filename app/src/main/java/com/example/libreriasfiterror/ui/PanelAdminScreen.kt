package com.example.libreriasfiterror.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.Alignment

@Composable
fun PanelAdminScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Panel de Administración", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(24.dp))

        // Navegación con limpieza del backstack
        Button(onClick = {
            navController.navigate("catalogo") {
                popUpTo("admin") { inclusive = true }
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Ver catálogo")
        }

        Spacer(Modifier.height(12.dp))
        Button(onClick = { /* Acción para agregar libro */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Agregar libro")
        }
        Spacer(Modifier.height(12.dp))
        Button(onClick = { /* Acción para eliminar libro */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Eliminar libro")
        }
        Spacer(Modifier.height(18.dp))
        Button(onClick = { navController.popBackStack() }, modifier = Modifier.fillMaxWidth()) {
            Text("Volver")
        }
    }
}
