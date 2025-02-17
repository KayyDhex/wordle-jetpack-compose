package com.dam.wordle2.data

import com.dam.wordle2.domain.FakeDataSource
import com.dam.wordle2.domain.Score
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

object FakeDataSource: FakeDataSource{

    private val _words = MutableStateFlow<List<String>>(emptyList())
    private val _scores = MutableStateFlow<List<Score>>(emptyList())

    init {
        _words.value = mutableListOf( "ARISE", "APPLE", "BENCH", "BRAVE", "CHARM", "CHESS", "CLEAR", "DANCE", "DODGE",
            "EAGLE", "ELITE", "FLAME", "FRAME", "GLOBE", "GRAPE", "HAPPY", "HEART", "IMAGE",
            "JOLLY", "JUMBO", "KNIFE", "LASER", "LUNCH", "MAGIC", "MARCH", "NERVE", "NOTCH",
            "OCEAN", "OLIVE", "PEACE", "PILOT", "QUIET", "QUEST", "RIDER", "RISKY", "SCENE",
            "SHINE", "TIGER", "TREAT", "UNITE", "VIVID", "WHALE", "WHEAT", "ZEBRA", "ZESTY")
    }

    override val words: Flow<List<String>>
        get() = _words

    override val scores: Flow<List<Score>>
        get() = _scores


    override fun getRandomWord(): String {
        return _words.value.random()
    }

    override fun getScores(): List<Score> {
        return _scores.value
    }

    override fun addScore(score: Score) {
        val scores = _scores.value.toMutableList()
        scores.add(score)
        _scores.value = scores
    }

    override fun removeScore(score: Score) {
        val scores = _scores.value.toMutableList()
        scores.remove(score)
        _scores.value = scores
    }
}