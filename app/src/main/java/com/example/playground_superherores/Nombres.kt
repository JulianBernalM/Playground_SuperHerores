package com.example.playground_superherores

//Atributos de cada super heroe
data class Nombres(
    val id: Int,
    val nombre: String,
    val imagenUrl: String,
    val descripcion: String,
    val superPoderes: List<String>
)

//Lista de super herores con los anteriores atributos
val listaNombres = listOf(
    Nombres(
        id = 1,
        nombre = "Superman",
        imagenUrl = "https://example.com/superman.jpg",
        descripcion = "Héroe de Krypton con fuerza extraordinaria.",
        superPoderes = listOf("Vuelo", "Super fuerza", "Visión láser")
    ),
    Nombres(
        id = 2,
        nombre = "Batman",
        imagenUrl = "https://example.com/batman.jpg",
        descripcion = "Héroe de Gotham experto en estrategia y combate.",
        superPoderes = listOf("Inteligencia", "Artes marciales", "Tecnología")
    ),
    Nombres(
        id = 3,
        nombre = "Flash",
        imagenUrl = "https://example.com/flash.jpg",
        descripcion = "El hombre más rápido del mundo.",
        superPoderes = listOf("Super velocidad", "Reflejos", "Viaje temporal")
    )
)