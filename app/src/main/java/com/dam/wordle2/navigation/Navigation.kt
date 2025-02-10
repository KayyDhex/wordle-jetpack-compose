package com.dam.wordle2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dam.wordle2.presentation.screens.game.GameScreen
import com.dam.wordle2.presentation.screens.HomeScreen
import com.dam.wordle2.presentation.screens.ScoreScreen
import kotlinx.serialization.Serializable

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreenDes) {
        composable<HomeScreenDes>{
            HomeScreen(
                onGoPlay = {
                    navController.navigate(GameScreenDes)
                },
                onGoScore = {
                    navController.navigate(ScoreScreenDes)
                }
            )
        }
        composable<GameScreenDes> {
            GameScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
        composable<ScoreScreenDes> {
            ScoreScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Serializable
object HomeScreenDes

@Serializable
object GameScreenDes

@Serializable
object ScoreScreenDes