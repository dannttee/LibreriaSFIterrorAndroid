package com.example.libreriasfiterror.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.libreriasfiterror.viewmodel.CatalogoViewModel
import com.example.libreriasfiterror.viewmodel.UserAdminViewModel
import com.example.libreriasfiterror.model.Libro
import com.example.libreriasfiterror.model.CategoriaLibro

@Composable
fun PanelAdminScreen(
    navController: NavController,
    catalogViewModel: CatalogoViewModel,
    userAdminViewModel: UserAdminViewModel
) {
    var showDialog by remember { mutableStateOf(false) }
    var isEditing by remember { mutableStateOf(false) }
    var libroEditando: Libro? by remember { mutableStateOf(null) }
    var nombreLibro by remember { mutableStateOf("") }
    var precioLibro by remember { mutableStateOf("") }
    var descripcionLibro by remember { mutableStateOf("") }
    var categoriaSeleccionada by remember { mutableStateOf(CategoriaLibro.TERROR) }
    var expanded by remember { mutableStateOf(false) }
    var resultado by remember { mutableStateOf("") }

    fun limpiarCampos() {
        nombreLibro = ""
        precioLibro = ""
        descripcionLibro = ""
        categoriaSeleccionada = CategoriaLibro.TERROR
        libroEditando = null
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Panel de Administración", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))

        // Botones principales
        Button(
            onClick = { navController.navigate("catalogo") { popUpTo("admin") { inclusive = true } } },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Ver catálogo") }

        Spacer(Modifier.height(8.dp))
        Button(
            onClick = {
                showDialog = true
                isEditing = false
                limpiarCampos()
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Crear nuevo libro") }

        Spacer(Modifier.height(8.dp))
        Button(
            onClick = {
                userAdminViewModel.isAdmin = false
                navController.navigate("login") {
                    popUpTo(0) { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Cerrar sesión") }

        // Listado CRUD
        Spacer(Modifier.height(24.dp))
        Text("Catálogo de productos", style = MaterialTheme.typography.titleLarge)

        catalogViewModel.libros.forEach { libro ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(libro.nombre, style = MaterialTheme.typography.bodyLarge)
                    Text("Precio: ${libro.precio} | ${libro.categoria.name.replace('_',' ')}", style = MaterialTheme.typography.bodySmall)
                    Text(libro.descripcion, style = MaterialTheme.typography.bodySmall)
                }
                Row {
                    Button(
                        onClick = {
                            isEditing = true
                            showDialog = true
                            libroEditando = libro
                            nombreLibro = libro.nombre
                            precioLibro = libro.precio.toString()
                            descripcionLibro = libro.descripcion
                            categoriaSeleccionada = libro.categoria
                        },
                        modifier = Modifier.padding(end=4.dp)
                    ) { Text("Editar") }
                    Button(
                        onClick = {
                            catalogViewModel.removeLibro(libro)
                            resultado = "Producto eliminado"
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                    ) { Text("Eliminar") }
                }
            }
            Divider()
        }

        // Mensaje de feedback
        if (resultado.isNotEmpty()) {
            Spacer(Modifier.height(10.dp))
            Text(resultado, style = MaterialTheme.typography.bodyMedium)
        }
    }

    // Diálogo de agregar/modificar
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false; isEditing = false; limpiarCampos() },
            confirmButton = {
                Button(onClick = {
                    val nombreValido = nombreLibro.isNotBlank()
                    val descripcionValida = descripcionLibro.isNotBlank()
                    val precioValido = precioLibro.toDoubleOrNull()?.let { it > 0 } ?: false
                    val categoriaValida = categoriaSeleccionada in CategoriaLibro.values()
                    if (!nombreValido || !descripcionValida || !precioValido) {
                        resultado = "Campos obligatorios faltantes o inválidos"
                    } else {
                        if (isEditing && libroEditando != null) {
                            val libroMod = libroEditando!!.copy(
                                nombre = nombreLibro,
                                precio = precioLibro.toDouble(),
                                descripcion = descripcionLibro,
                                categoria = categoriaSeleccionada
                            )
                            catalogViewModel.updateLibro(libroMod)
                            resultado = "Producto modificado"
                        } else {
                            val idNuevo = (catalogViewModel.libros.maxOfOrNull { it.id } ?: 0) + 1
                            val exists = catalogViewModel.libros.any { it.nombre.equals(nombreLibro, ignoreCase = true) }
                            if (exists) {
                                resultado = "El libro ya existe en el catálogo"
                            } else {
                                val nuevoLibro = Libro(
                                    id = idNuevo,
                                    nombre = nombreLibro,
                                    precio = precioLibro.toDouble(),
                                    descripcion = descripcionLibro,
                                    categoria = categoriaSeleccionada
                                )
                                catalogViewModel.addLibro(nuevoLibro)
                                resultado = "Producto creado"
                            }
                        }
                        limpiarCampos()
                        showDialog = false
                        isEditing = false
                    }
                }) {
                    Text(if (isEditing) "Modificar" else "Agregar")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false; isEditing = false; limpiarCampos() }) {
                    Text("Cancelar")
                }
            },
            title = { Text(if (isEditing) "Editar producto" else "Agregar libro a catálogo") },
            text = {
                Column {
                    OutlinedTextField(
                        value = nombreLibro,
                        onValueChange = { nombreLibro = it },
                        label = { Text("Nombre del libro") }
                    )
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(
                        value = precioLibro,
                        onValueChange = { precioLibro = it.filter { c -> c.isDigit() || c == '.' } },
                        label = { Text("Precio") }
                    )
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(
                        value = descripcionLibro,
                        onValueChange = { descripcionLibro = it },
                        label = { Text("Descripción") }
                    )
                    Spacer(Modifier.height(8.dp))
                    Box {
                        OutlinedButton(onClick = { expanded = true }) {
                            Text(categoriaSeleccionada.name.replace('_', ' '))
                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            CategoriaLibro.values().forEach { categoria ->
                                DropdownMenuItem(
                                    onClick = {
                                        categoriaSeleccionada = categoria
                                        expanded = false
                                    },
                                    text = { Text(categoria.name.replace('_', ' ')) }
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}
