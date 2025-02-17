package com.dam.wordle2.presentation.screens.score

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dam.wordle2.data.FakeDataSource
import com.dam.wordle2.domain.Score

class ScoreViewModel : ViewModel() {
    private val localDataSource = FakeDataSource

    var scores by mutableStateOf(listOf<Score>())
        private set

    init {
        scores = localDataSource.getScores()
    }
}