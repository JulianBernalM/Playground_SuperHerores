package com.example.playground_superherores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.playground_superherores.ui.theme.Playground_SuperHeroresTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Playground_SuperHeroresTheme {
                AppNavigation()
            }
        }
    }
}
