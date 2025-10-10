import com.example.libreriasfiterror.R
import com.example.libreriasfiterror.model.Libro

class LibroRepository {

    fun obtenerLibros(): List<Libro> {
        return listOf(
            Libro(
                1,
                "1984",
                "George Orwell",
                15.000,
                R.drawable.libro_1984
            ),
            Libro(
                2,
                "Fundación",
                "Isaac Asimov",
                13.000,
                R.drawable.fundacion
            )
        )
    }
}

