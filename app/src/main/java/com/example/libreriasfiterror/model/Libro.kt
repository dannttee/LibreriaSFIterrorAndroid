package com.example.libreriasfiterror.model

data class Libro(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val descripcion: String,
    val categoria: CategoriaLibro
)

enum class CategoriaLibro {
    TERROR, CIENCIA_FICCION, NOVELAS
}

