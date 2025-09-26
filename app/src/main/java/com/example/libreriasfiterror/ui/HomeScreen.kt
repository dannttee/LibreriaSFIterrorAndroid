package com.example.libreriasfiterror.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.libreriasfiterror.viewmodel.LibroViewModel

@Composable
fun HomeScreen() {
    val viewModel: LibroViewModel = viewModel()
    val listaLibros = viewModel.libros.observeAsState(initial = emptyList())

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
            items(listaLibros.value) { libro ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = 4.dp
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = libro.titulo, style = MaterialTheme.typography.h6)
                        Text(text = "Autor: ${libro.autor}", style = MaterialTheme.typography.body2)
                        Text(text = "Precio: $${libro.precio}", style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
    }
}

