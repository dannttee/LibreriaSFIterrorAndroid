package com.example.libreriasfiterror.ui.catalog

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
fun CatalogoScreen(
    viewModel: LibroViewModel,
    onAgregarAlCarrito: (Libro) -> Unit,
    onIrAlCarrito: () -> Unit
) {
    val libros = viewModel.libros
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(libros) { libro ->
                LibroItem(libro, onAgregarAlCarrito)
                Spacer(Modifier.height(8.dp))
            }
        }
        Button(
            onClick = onIrAlCarrito,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Ver carrito")
        }
    }
}

@Composable
fun LibroItem(libro: Libro, onAgregarAlCarrito: (Libro) -> Unit) {
    Card(Modifier.fillMaxWidth()) {
        Row(Modifier.padding(8.dp)) {
            Column(Modifier.weight(1f)) {
                Text(libro.titulo, style = MaterialTheme.typography.titleLarge)
                Text(libro.autor, style = MaterialTheme.typography.bodyMedium)
                Text("${libro.genero} - $${libro.precio}", style = MaterialTheme.typography.bodySmall)
                Text(libro.descripcion, style = MaterialTheme.typography.bodySmall)
                Button(
                    onClick = { onAgregarAlCarrito(libro) },
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("Agregar al carrito")
                }
            }
        }
    }
}
