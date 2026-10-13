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
        imagenUrl = "https://commons.wikimedia.org/wiki/Special:Redirect/file/Superman%20(181095786).jpg",
        descripcion = "Héroe de Krypton con fuerza extraordinaria.",
        superPoderes = listOf("Vuelo", "Super fuerza", "Visión láser")
    ),
    Nombres(
        id = 2,
        nombre = "Batman",
        imagenUrl = "https://commons.wikimedia.org/wiki/Special:Redirect/file/Batman%20(122130218).jpg",
        descripcion = "Héroe de Gotham experto en estrategia y combate.",
        superPoderes = listOf("Inteligencia", "Artes marciales", "Tecnología")
    ),
    Nombres(
        id = 3,
        nombre = "Flash",
        imagenUrl = "https://commons.wikimedia.org/wiki/Special:Redirect/file/Montreal%20Comiccon%202016%20-%20The%20Flash%20(27643901323).jpg",
        descripcion = "El hombre más rápido del mundo.",
        superPoderes = listOf("Super velocidad", "Reflejos", "Viaje temporal")
    )
)