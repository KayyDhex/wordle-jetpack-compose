package com.dam.wordle2.presentation.screens.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dam.wordle2.data.allWords

class GameViewModel : ViewModel() {
    var solution by mutableStateOf(getRandomWord())
        private set

    var currentAttempt by mutableStateOf("")
        private set

    var attempts by mutableStateOf(listOf<String>())
        private set

    private fun getRandomWord(): String {
        return allWords.random()
    }
    fun restartGame() {
        solution = getRandomWord()
        currentAttempt = ""
        attempts = emptyList()
    }

    fun onKeyPressed(letter: Char) {
        if (currentAttempt.length < 5) {
            currentAttempt += letter
        }
    }

    fun onBackspace() {
        if (currentAttempt.isNotEmpty()) {
            currentAttempt = currentAttempt.dropLast(1)
        }
    }

    fun onSubmit() {
        if (currentAttempt.length == 5) {
            attempts = attempts + currentAttempt
            currentAttempt = ""
        }
    }
}