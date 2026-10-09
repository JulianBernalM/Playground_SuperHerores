package com.example.playground_superherores

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
import coil3.compose.AsyncImage
import org.w3c.dom.Text

//El componente recibirá la URL y el nombre del superhéroe y mostrará su imagen.
@Composable
fun HeroImage(
    imageUrl: String,
    contentDescription: String
){
    AsyncImage(
        model = imageUrl,
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
    }

}