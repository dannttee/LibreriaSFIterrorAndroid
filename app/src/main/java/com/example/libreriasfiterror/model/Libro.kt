package com.example.libreriasfiterror.model

data class Libro(
    val id: Int,
    val titulo: String,
    val autor: String,
    val precio: Double,
    val genero: String,
    val descripcion: String,
    val imagenRes: Int // Si usas recursos locales para imágenes
)
