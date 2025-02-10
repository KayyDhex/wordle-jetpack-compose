package com.dam.wordle2.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WordleGrid(solution: String, guesses: List<String>, currentAttempt: String) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(6) { rowIndex ->
            when {
                rowIndex < guesses.size -> {
                    WordRowCompare(guesses[rowIndex],solution)
                }
                rowIndex == guesses.size -> {
                    WordRow(currentAttempt.padEnd(5, ' '), -1)
                }
                else -> {
                    WordRow("     ", -1)
                }
            }
        }
    }
}

@Preview
@Composable
fun WordleGridPreview() {
    val guesses = listOf("WRODY", "APPLE") // Example guesses
    WordleGrid(solution = "WORDY", guesses = guesses, currentAttempt = "ASD")
}