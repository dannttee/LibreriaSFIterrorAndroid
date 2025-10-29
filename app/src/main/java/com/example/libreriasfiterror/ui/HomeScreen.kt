package com.example.libreriasfiterror.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.libreriasfiterror.viewmodel.LibroViewModel
import com.example.libreriasfiterror.model.Libro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val viewModel: LibroViewModel = viewModel()
    val listaLibros = viewModel.libros

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Libros SFIterror") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listaLibros) { libro: Libro ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = libro.imagenRes),
                            contentDescription = libro.titulo,
                            modifier = Modifier.size(56.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(
                                text = libro.titulo,
                                style = MaterialTheme.typography.titleLarge
                            )
                            Text(
                                text = "Autor: ${libro.autor}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = "Precio: $${libro.precio}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}



