package com.example.libreriasfiterror.repository

import com.example.libreriasfiterror.model.Libro

class LibroRepository {

    fun obtenerLibros(): List<Libro> {
        return listOf(
            Libro(1, "1984", "George Orwell", 15.99),
            Libro(2, "Fundación", "Isaac Asimov", 12.99)
        )
    }
}
