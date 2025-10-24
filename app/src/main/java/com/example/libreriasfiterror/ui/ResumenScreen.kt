package com.example.libreriasfiterror.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.libreriasfiterror.viewmodel.UsuarioViewModel

@Composable
fun ResumenScreen(
    navController: NavController,  // ← AGREGADO: parámetro necesario
    usuarioViewModel: UsuarioViewModel = viewModel()
) {
    val uiState by usuarioViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            "Resumen de registro",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(Modifier.height(16.dp))

        Text("Nombre: ${uiState.nombre}")
        Text("Correo: ${uiState.correo}")
        Text("Dirección: ${uiState.direccion}")

        Spacer(modifier = Modifier.height(24.dp))

        // ← AGREGADO: botón para navegar a Home
        Button(
            onClick = {
                navController.navigate("home") {
                    popUpTo("registro") { inclusive = true }
                    launchSingleTop = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a Home")
        }
    }
}
