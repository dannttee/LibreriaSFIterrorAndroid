package com.example.mundopelota.model

data class Pelota(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val descripcion: String,
    val categoria: CategoriaPelota
)

enum class CategoriaPelota {
    BASKETBALL,
    FUTBOL,
    VOLLEYBALL
}


