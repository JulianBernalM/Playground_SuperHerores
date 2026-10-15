package com.example.playground_superherores

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Card
import androidx.compose.material3.Button
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.Color

//El componente recibirá la URL y el nombre del superhéroe y mostrará su imagen.
//Ahora el componente recigira una imagen y el nombre del superheroe
@Composable
fun HeroImage(
    imagenRes: Int,
    contentDescription: String
){
    Image(
        painter = painterResource(id = imagenRes),
        contentDescription = contentDescription,
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp),
        contentScale = ContentScale.Crop
    )
}

//El componente encargado de mostrar la informacion basica del super heroe
@Composable
fun HeroInfo(hero: Nombres){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text (
            text = "ID: ${hero.id}"
        )

        Text (
            text = hero.nombre
        )

        Text (
            text = hero.descripcion
        )

        Text(
            text = "Superpoderes: ${hero.superPoderes.joinToString ()}"
        )
        //Creamos la condicion si el atributo hero.marvel es true entonces aparece Si
        Text(
            text = "Universo: ${hero.universo}"
        )
    }

}

//Componente encargado de mostrar la version detallada de la informacion del super heroe
@Composable
fun HeroInfoDetail(hero: Nombres) {
    //Contenedor visual del detalle
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {//coloca elementos horizontalmente
        Column(
            modifier = Modifier.padding(16.dp)
        ) {//reserva el espacio para el avatar
            Text(
                text = hero.nombre
            )

            Spacer(modifier = Modifier.height(8.dp))
            //Organiza información verticalmente
            Text(
                text = hero.descripcion
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "ID: ${hero.id}"
            )

            Text(
                text = "Universo: ${hero.universo}"
            )


            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Superpoderes"
            )

            Spacer(modifier = Modifier.height(8.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                hero.superPoderes.forEach { poder ->
                    AssistChip(
                        onClick = {},
                        label = {
                            Text(text = poder)
                        }
                    )}
            }
        }



    }
}

//Componente que analiza los superpoderes de cada héroe y determina qué perfil tiene: Estratega, Cósmico, Velocista o Titán
fun heroProfile(superPoderes: List<String>): String {
    return when {
        superPoderes.any { it.contains("Inteligencia", ignoreCase = true) } ->
            "Estratega"

        superPoderes.any { it.contains("Vuelo", ignoreCase = true) } ->
            "Cósmico"

        superPoderes.any { it.contains("velocidad", ignoreCase = true) } ->
            "Velocista"

        superPoderes.any { it.contains("fuerza", ignoreCase = true) } ->
            "Titán"

        else -> "Héroe"
    }
}

//Componente reutilizable que reunirá la imagen y la información del superhéroe.
//En este lugar es donde debemos hacer el cambio del color
@Composable
fun HeroCard(
    hero: Nombres,
    onClick: (() -> Unit)? = null,
    option: Int = 0,
    modifier: Modifier = Modifier,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (hero.universo == "DC") {
                Color.Gray
            } else {
                Color.Cyan
            }
        ),
        modifier = modifier
            .fillMaxWidth()
            .then( //permite que la tarjeta sea opcionalmente pulsable
                if (onClick != null) {
                    Modifier.clickable { onClick() }
                } else {
                    Modifier
                }
            )
    ) {
        Column {
            HeroImage(
                imagenRes = hero.imagenRes,
                contentDescription = hero.nombre
            )
            //option = 0 muestra la información compacta // option = 1 muestra la información detallada
            if (option == 0) {
                HeroInfo(hero)
            } else {
                HeroInfoDetail(hero)
            }
        }
    }
}

//Pantalla que mostrará todos los superhéroes en una lista vertical usando LazyColumn
@Composable
fun ListaSuperHeroes(
    //La función recibe la listaNombres del archivo Nombres.kt
    superheroes: List<Nombres>,
    onVerDetalle: (Int) -> Unit
) {//Lista vertical que contiene los super heroes
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = superheroes,
            key = { it.id }
        ) { hero ->

            HeroCard(
                hero = hero,
                onClick = {
                    //Cuando el usuario pulse una tarjeta, enviamos el ID del héroe hacia la función que posteriormente se encargará de navegar a su detalle
                    onVerDetalle(hero.id)
                },
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

//Pantalla que aparecerá cuando toquemos una tarjeta
@Composable
fun DetalleSuperHeroe(
    //Recibe el superhéroe que debemos mostrar
    hero: Nombres,
    //Función para regresar a la lista
    onVolver: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            //Es importante porque option = 1 hace que se utilice nuestro componente en lugar de HeroInfo
            HeroCard(
                hero = hero,
                option = 1
            )

            Button(
                onClick = onVolver,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Volver a la lista"
                )
            }
        }
    }
}

//Componente que conectar la lista con el detalle y contiene dos rutas: lista y detalle/{id}
//Primer componente que sera llamado en main activity
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        //Cuando la app se abre empieza en este lugar (en la lista)
        startDestination = Routes.LISTA
    ) {
        composable(Routes.LISTA) {
            ListaSuperHeroes(
                superheroes = listaNombres,
                onVerDetalle = { id ->
                    navController.navigate(
                        Routes.detalle(id)
                    )
                }
            )
        }
        //Cuando pulsamos, por ejemplo, Batman: Se ejecuta Routes.detalle(2)
        composable(
            route = Routes.DETALLE,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
            //Recupera el id(2)
        ) { backStackEntry ->

            val id = backStackEntry
                .arguments
                ?.getInt("id")


            //Busca en nuestra lista el superhéroe cuyo ID sea 2.
            val hero = listaNombres.find {
                it.id == id
            }

            //Por último, popBackStack() hará que el botón “Volver a la lista” regrese a la pantalla anterior
            if (hero != null) {
                DetalleSuperHeroe(
                    hero = hero,
                    onVolver = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}