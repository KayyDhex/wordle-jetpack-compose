package com.dam.wordle2.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dam.wordle2.presentation.components.Keyboard
import com.dam.wordle2.presentation.components.WordleGrid
import com.dam.wordle2.ui.theme.Wordle2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen() {

    var currentAttempt by remember { mutableStateOf("") }
    var attempts by remember { mutableStateOf(mutableListOf<String>()) }

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text("Back")
                },
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ){
        paddingValues ->
        Column (modifier = Modifier.padding(paddingValues).padding(horizontal = 16.dp, vertical = 25.dp)) {
            GridGame(currentAttempt,attempts )
            Spacer(modifier = Modifier.weight(1f))
            Keyboard(
                onKeyPressed = { key ->
                    if (currentAttempt.length < 5) {
                        currentAttempt += key
                    }
                },
                onBackspace = {
                    if (currentAttempt.isNotEmpty()) {
                        currentAttempt = currentAttempt.dropLast(1)
                    }
                },
            )
            Spacer(modifier = Modifier.height(16.dp))
            SubmitButton(onSubmit = {
                attempts.add(currentAttempt)
                currentAttempt = ""
            })
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
fun GameScreenPreview() {
    Wordle2Theme {
        GameScreen()
    }
}

@Composable
fun GridGame(currentAttempt: String, attempts: MutableList<String>) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WordleGrid(solution = "WORDY", guesses = attempts, currentAttempt)
    }
}

@Composable
fun SubmitButton(onSubmit: () -> Unit) {
    Button(
        onClick = {
            onSubmit()
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4B7846),
            contentColor = Color.White
        )
    ) {
        Text("Submit")
    }
}