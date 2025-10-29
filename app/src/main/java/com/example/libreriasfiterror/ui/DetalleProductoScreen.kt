package com.example.libreriasfiterror.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetalleProductoScreen(navController: NavController) {
    // Datos simulados del libro
    val nombreLibro = "Ejemplo: Dune"
    val autor = "Frank Herbert"
    val descripcion = "Clásico de la ciencia ficción con elementos épicos y filosóficos."
    val precio = "$10.000"

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text("Detalle del Producto", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(24.dp))
        Text("Libro: $nombreLibro", style = MaterialTheme.typography.titleLarge)
        Text("Autor: $autor", style = MaterialTheme.typography.bodyMedium)
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
