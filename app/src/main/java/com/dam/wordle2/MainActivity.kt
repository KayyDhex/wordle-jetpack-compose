package com.dam.wordle2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dam.wordle2.navigation.Navigation
import com.dam.wordle2.ui.theme.Wordle2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Wordle2Theme {
                Navigation()
            }
        }
    }
}