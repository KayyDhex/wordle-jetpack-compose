package com.dam.wordle2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dam.wordle2.presentation.screens.GameScreen
import com.dam.wordle2.presentation.screens.HomeScreen
import com.dam.wordle2.presentation.screens.ScoreScreen
import kotlinx.serialization.Serializable

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = GameScreenDes) {
        composable<HomeScreenDes>{
            HomeScreen()
        }
        composable<GameScreenDes> {
            GameScreen()
        }
        composable<ScoreScreenDes> {
            ScoreScreen()
        }
    }
}

@Serializable
object HomeScreenDes

@Serializable
object GameScreenDes

@Serializable
object ScoreScreenDes