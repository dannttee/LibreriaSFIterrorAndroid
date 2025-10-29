package com.example.libreriasfiterror.ui.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.libreriasfiterror.viewmodel.LibroViewModel
import com.example.libreriasfiterror.model.Libro

@Composable
fun CarritoScreen(
    viewModel: LibroViewModel,
    onEliminarDelCarrito: (Libro) -> Unit,
    onVolver: () -> Unit
) {
    val carrito = viewModel.carrito
    val total = carrito.sumOf { it.precio }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Carrito",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(carrito) { libro ->
                CarritoItem(libro, onEliminarDelCarrito)
                Spacer(Modifier.height(8.dp))
            }
        }
        Text(
            text = "Total: $${total}",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Button(
            onClick = onVolver,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver al catálogo")
        }
    }
}

@Composable
fun CarritoItem(libro: Libro, onEliminarDelCarrito: (Libro) -> Unit) {
    Card(Modifier.fillMaxWidth()) {
        Row(Modifier.padding(8.dp)) {
            Column(Modifier.weight(1f)) {
                Text(libro.titulo, style = MaterialTheme.typography.titleMedium)
                Text("Precio: $${libro.precio}", style = MaterialTheme.typography.bodySmall)
            }
            Button(
                onClick = { onEliminarDelCarrito(libro) },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text("Eliminar")
            }
        }
    }
}
