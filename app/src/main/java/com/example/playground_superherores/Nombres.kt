package com.example.playground_superherores

//Atributos de cada super heroe
data class Nombres(
    val id: Int,
    val nombre: String,
    //val imagenUrl: String,
    val imagenRes: Int,
    val descripcion: String,
    val superPoderes: List<String>,
    val universo: String,
    val tipo: String
)

//Lista de super herores con los anteriores atributos
val listaNombres = listOf(
    Nombres(
        id = 1,
        nombre = "Superman",
        //imagenUrl = "https://images.unsplash.com/photo-1531259683007-016a7b628fc3?auto=format&fit=crop&w=800&q=80",
        imagenRes = R.drawable.superman,
        descripcion = "Héroe de Krypton con fuerza extraordinaria.",
        superPoderes = listOf("Vuelo", "Super fuerza", "Visión láser"),
        universo = "DC",
        tipo = "Heroe"
    ),
    Nombres(
        id = 2,
        nombre = "Batman",
        //imagenUrl = "https://images.unsplash.com/photo-1577806722295-8e9a4e8e9f2a?auto=format&fit=crop&w=800&q=80",
        imagenRes = R.drawable.batman,
        descripcion = "Héroe de Gotham experto en estrategia y combate.",
        superPoderes = listOf("Inteligencia", "Artes marciales", "Tecnología"),
        universo = "DC",
        tipo = "Heroe"
    ),
    Nombres(
        id = 3,
        nombre = "Flash",
        //imagenUrl = "https://images.unsplash.com/photo-1550745165-9bc0b252726f?auto=format&fit=crop&w=800&q=80",
        imagenRes = R.drawable.flash,
        descripcion = "El hombre más rápido del mundo.",
        superPoderes = listOf("Super velocidad", "Reflejos", "Viaje temporal"),
        universo = "DC",
        tipo = "Heroe"
    ),
    Nombres(
        id = 4,
        nombre = "Thor",
        imagenRes = R.drawable.thor,
        descripcion = "Dios del trueno, un principe asgardiano y un guerrero de fuerza divina",
        superPoderes = listOf(
            "Control del trueno",
            "Fuerza y resistencia sobrehumanas",
            "Su martillo encantado que le permite volar"
        ),
        universo = "Marvel",
        tipo = "Heroe"
    ),
    Nombres(
        id = 5,
        nombre = "Joker",
        imagenRes = R.drawable.joker,
        descripcion = "El famoso villano de Gotham, conocido por su personalidad caótica y su rivalidad con Batman",
        superPoderes = listOf(
            "Inteligencia",
            "Estrategia",
            "Manipulación"
        ),
        universo = "DC",
        tipo = "Villano"
    )
)