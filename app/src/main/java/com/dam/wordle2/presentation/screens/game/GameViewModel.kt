package com.dam.wordle2.presentation.screens.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dam.wordle2.data.FakeDataSource
import com.dam.wordle2.domain.Score

class GameViewModel : ViewModel() {
    private val localDataSource = FakeDataSource

    var solution by mutableStateOf(getRandomWord())
        private set

    var currentAttempt by mutableStateOf("")
        private set

    var attempts by mutableStateOf(listOf<String>())
        private set

    var showModal by mutableStateOf(false)
        private set

    var messageDialog by mutableStateOf("")
        private set

    private fun getRandomWord(): String {
        return localDataSource.getRandomWord()
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
            if(currentAttempt == solution){
                showModal = true
                messageDialog = "You win!"
                localDataSource.addScore(Score(solution, attempts.size, "Hans"))
            }else if(attempts.size >= 6){
                showModal = true
                messageDialog = "You lose!"
            }
            currentAttempt = ""
        }
    }

    fun onCloseDialog(){
        showModal = false
    }
}