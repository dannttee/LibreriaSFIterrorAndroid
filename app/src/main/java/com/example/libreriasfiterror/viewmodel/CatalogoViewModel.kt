package com.example.libreriasfiterror.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.libreriasfiterror.model.Libro
import com.example.libreriasfiterror.model.CategoriaLibro


class CatalogoViewModel : ViewModel() {
    var libros = mutableStateListOf<Libro>()
        private set

    init {
        // Mínimo 6 libros, 2 por categoría
        libros.addAll(
            listOf(
                Libro(1, "Frankenstein", 7900.0, "El clásico de Mary Shelley", CategoriaLibro.TERROR),
                Libro(2, "Drácula", 8500.0, "La novela fundacional de vampiros", CategoriaLibro.TERROR),
                Libro(3, "Dune", 12500.0, "Épica de ciencia ficción", CategoriaLibro.CIENCIA_FICCION),
                Libro(4, "Neuromante", 9900.0, "Cyberpunk esencial", CategoriaLibro.CIENCIA_FICCION),
                Libro(5, "Cumbres Borrascosas", 7000.0, "Tragedia romántica británica", CategoriaLibro.NOVELAS),
                Libro(6, "El Principito", 6500.0, "Fábula filosófica universal", CategoriaLibro.NOVELAS)
            )
        )
    }

    fun addLibro(libro: Libro) { libros.add(libro) }
    fun removeLibro(libro: Libro) { libros.remove(libro) }
    fun updateLibro(libroActualizado: Libro) {
        val indice = libros.indexOfFirst { it.id == libroActualizado.id }
        if (indice >= 0) {
            libros[indice] = libroActualizado
        }
    }
}


