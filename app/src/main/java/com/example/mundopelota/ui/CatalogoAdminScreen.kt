package com.example.mundopelota.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.mundopelota.viewmodel.CatalogoViewModel
import com.example.mundopelota.model.Pelota
import com.example.mundopelota.model.CategoriaPelota

@Composable
fun CatalogoAdminScreen(
    navController: NavController,
    catalogViewModel: CatalogoViewModel
) {
    var resultado by remember { mutableStateOf("") }
    var showEditDialog by remember { mutableStateOf(false) }
    var editPelota by remember { mutableStateOf<Pelota?>(null) }
    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf(CategoriaPelota.FUTBOL) }
    var expanded by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    fun limpiarCampos() {
        nombre = ""
        precio = ""
        descripcion = ""
        categoria = CategoriaPelota.FUTBOL
        editPelota = null
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Catálogo de productos (ADMIN)", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        catalogViewModel.pelotas.forEach { pelota ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("${pelota.nombre} (ID: ${pelota.id})", style = MaterialTheme.typography.bodyLarge)
                    Text("Precio: ${pelota.precio} | ${pelota.categoria.name.replace('_', ' ')}", style = MaterialTheme.typography.bodySmall)
                    Text(pelota.descripcion, style = MaterialTheme.typography.bodySmall)
                }
                // SOLO ESTA PARTE CAMBIA: usa Column
                Column(
                    modifier = Modifier.widthIn(min = 120.dp).fillMaxHeight(),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            editPelota = pelota
                            nombre = pelota.nombre
                            precio = pelota.precio.toString()
                            descripcion = pelota.descripcion
                            categoria = pelota.categoria
                            showEditDialog = true
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) { Text("Modificar") }
                    Button(
                        onClick = {
                            catalogViewModel.removePelota(pelota)
                            resultado = "Producto eliminado"
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                        modifier = Modifier.fillMaxWidth()
                    ) { Text("Eliminar") }
                }
            }
            Divider()
        }

        if (resultado.isNotEmpty()) {
            Spacer(Modifier.height(10.dp))
            Text(resultado, style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(Modifier.height(24.dp))
        Button(
            onClick = { navController.navigate("admin") { popUpTo(0) { inclusive = true } } },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Volver") }
    }

    if (showEditDialog && editPelota != null) {
        AlertDialog(
            onDismissRequest = { showEditDialog = false; limpiarCampos() },
            confirmButton = {
                Button(onClick = {
                    val nombreValido = nombre.isNotBlank()
                    val descripcionValida = descripcion.isNotBlank()
                    val precioValido = precio.toDoubleOrNull()?.let { it > 0 } ?: false
                    val existe = catalogViewModel.pelotas.any {
                        it.id != editPelota!!.id && it.nombre.equals(nombre, ignoreCase = true)
                    }
                    if (!nombreValido || !descripcionValida || !precioValido) {
                        resultado = "Campos obligatorios faltantes o inválidos"
                    } else if (existe) {
                        resultado = "Ya existe otro producto con ese nombre"
                    } else {
                        catalogViewModel.updatePelota(
                            Pelota(editPelota!!.id, nombre, precio.toDouble(), descripcion, categoria)
                        )
                        resultado = "Producto modificado"
                        showEditDialog = false
                        limpiarCampos()
                    }
                }) { Text("Guardar") }
            },
            dismissButton = {
                Button(onClick = { showEditDialog = false; limpiarCampos() }) { Text("Cancelar") }
            },
            title = { Text("Modificar producto") },
            text = {
                Column {
                    OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(
                        value = precio,
                        onValueChange = { precio = it.filter { c -> c.isDigit() || c == '.' } },
                        label = { Text("Precio") }
                    )
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(value = descripcion, onValueChange = { descripcion = it }, label = { Text("Descripción") })
                    Spacer(Modifier.height(8.dp))
                    Box {
                        OutlinedButton(onClick = { expanded = true }) { Text(categoria.name.replace('_', ' ')) }
                        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                            CategoriaPelota.values().forEach { cat ->
                                DropdownMenuItem(
                                    onClick = { categoria = cat; expanded = false },
                                    text = { Text(cat.name.replace('_', ' ')) }
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}





