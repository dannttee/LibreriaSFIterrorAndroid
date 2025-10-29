package com.example.libreriasfiterror.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// Simula datos agregados
val fakeCartBooks = listOf("Dune", "1984", "El resplandor")

@Composable
fun CarritoScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {
        Text("Carrito de compras", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        if (fakeCartBooks.isNotEmpty()) {
            fakeCartBooks.forEach { libro ->
                Card (Modifier
                    .padding(vertical = 6.dp)
                    .fillMaxWidth()) {
                    Row(modifier = Modifier.padding(12.dp)) {
                        Text(libro, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
            Spacer(Modifier.height(18.dp))
            Button(
                onClick = { /* Lógica para confirmar compra */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirmar compra")
            }
            Spacer(Modifier.height(10.dp))
            Button(onClick = { /* Lógica para limpiar carrito */ },
                modifier = Modifier.fillMaxWidth()) {
                Text("Vaciar carrito")
            }
        } else {
            Text("Tu carrito está vacío.", style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()) {
            Text("Volver")
        }
    }
}
