package com.example.mundopelota.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetalleProductoScreen(navController: NavController) {
    // Datos simulados de la pelota
    val nombrePelota = "Ejemplo: Mikasa V200W"
    val tipo = "Vóleibol profesional"
    val descripcion = "Balón oficial de competencias internacionales, excelente control y durabilidad."
    val precio = "$29.990"

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text("Detalle del Producto", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(24.dp))
        Text("Pelota: $nombrePelota", style = MaterialTheme.typography.titleLarge)
        Text("Tipo: $tipo", style = MaterialTheme.typography.bodyMedium)
        Text("Descripción: $descripcion", style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(16.dp))
        Text("Precio: $precio", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(24.dp))
        Button(
            onClick = { navController.navigate("carrito") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar al carrito")
        }
        Spacer(Modifier.height(10.dp))
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}
