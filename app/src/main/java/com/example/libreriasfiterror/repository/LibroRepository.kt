package com.example.libreriasfiterror.repository

import com.example.libreriasfiterror.model.Libro
import com.example.libreriasfiterror.model.CategoriaLibro

object LibroRepository {
    private val librosIniciales = listOf(
        Libro(1, "Frankenstein", 7900.0, "El clásico de Mary Shelley", CategoriaLibro.TERROR),
        Libro(2, "Drácula", 8500.0, "La novela fundacional de vampiros", CategoriaLibro.TERROR),
        Libro(3, "Dune", 12500.0, "Épica de ciencia ficción", CategoriaLibro.CIENCIA_FICCION),
        Libro(4, "Neuromante", 9900.0, "Cyberpunk esencial", CategoriaLibro.CIENCIA_FICCION),
        Libro(5, "Cumbres Borrascosas", 7000.0, "Tragedia romántica británica", CategoriaLibro.NOVELAS),
        Libro(6, "El Principito", 6500.0, "Fábula filosófica universal", CategoriaLibro.NOVELAS)
    )

    fun getLibros(): List<Libro> = librosIniciales
}

