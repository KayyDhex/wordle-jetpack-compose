package com.dam.wordle2.domain

import kotlinx.coroutines.flow.Flow

interface FakeDataSource {

    val words: Flow<List<String>>
    val scores: Flow<List<Score>>

    fun getRandomWord(): String
    fun getScores(): List<Score>
    fun addScore(score: Score)
    fun removeScore(score: Score)
}