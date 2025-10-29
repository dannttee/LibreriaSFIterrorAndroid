package com.example.libreriasfiterror.repository

import com.example.libreriasfiterror.model.Libro

object LibroRepository {
    private val librosIniciales = listOf(
        Libro(
            id = 1,
            titulo = "El misterio del tren",
            autor = "Agatha Christie",
            precio = 13990.0,
            genero = "Misterio",
            descripcion = "Un clásico del suspense policial.",
            imagenRes = 0 // Usa el ID de recurso real si tienes drawable
        ),
        Libro(
            id = 2,
            titulo = "La sombra sobre Innsmouth",
            autor = "H. P. Lovecraft",
            precio = 11990.0,
            genero = "Terror",
            descripcion = "Horror cósmico en un pueblo maldito.",
            imagenRes = 0
        )
        // Agrega más libros según necesites
    )

    fun getLibros(): List<Libro> = librosIniciales
}
