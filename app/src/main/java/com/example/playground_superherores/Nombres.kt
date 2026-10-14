package com.example.playground_superherores

//Atributos de cada super heroe
data class Nombres(
    val id: Int,
    val nombre: String,
    //val imagenUrl: String,
    val imagenRes: Int,
    val descripcion: String,
    val superPoderes: List<String>
)

//Lista de super herores con los anteriores atributos
val listaNombres = listOf(
    Nombres(
        id = 1,
        nombre = "Superman",
        //imagenUrl = "https://images.unsplash.com/photo-1531259683007-016a7b628fc3?auto=format&fit=crop&w=800&q=80",
        imagenRes = R.drawable.superman,
        descripcion = "Héroe de Krypton con fuerza extraordinaria.",
        superPoderes = listOf("Vuelo", "Super fuerza", "Visión láser")
    ),
    Nombres(
        id = 2,
        nombre = "Batman",
        //imagenUrl = "https://images.unsplash.com/photo-1577806722295-8e9a4e8e9f2a?auto=format&fit=crop&w=800&q=80",
        imagenRes = R.drawable.batman,
        descripcion = "Héroe de Gotham experto en estrategia y combate.",
        superPoderes = listOf("Inteligencia", "Artes marciales", "Tecnología")
    ),
    Nombres(
        id = 3,
        nombre = "Flash",
        //imagenUrl = "https://images.unsplash.com/photo-1550745165-9bc0b252726f?auto=format&fit=crop&w=800&q=80",
        imagenRes = R.drawable.flash,
        descripcion = "El hombre más rápido del mundo.",
        superPoderes = listOf("Super velocidad", "Reflejos", "Viaje temporal")
    )
)