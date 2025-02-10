package com.dam.wordle2.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dam.wordle2.R
import com.dam.wordle2.presentation.components.WordRowCompare
import com.dam.wordle2.ui.theme.Wordle2Theme

@Composable
fun HomeScreen() {
    Scaffold {
        paddingValues ->
        Column (modifier = Modifier.padding(paddingValues).padding(horizontal = 16.dp, vertical = 25.dp)) {
            LogoHeader()
            Spacer(modifier = Modifier.weight(1f))
            Information()
            Spacer(modifier = Modifier.weight(1f))
            Buttons()
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
fun HomeScreenPreview() {
    Wordle2Theme {
        HomeScreen()
    }
}

@Composable
fun LogoHeader() {
    Image(painter = painterResource(id = R.drawable.wordle_emblem), contentDescription = "Wordle Emblem")
}

@Composable
fun Information() {
    Column (
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Text("How to play?")
        Text("Guess the Wordle in 6 tries\n" +
                "\n" +
                "Each guess must be a valid 5-letter word.\n" +
                "The color of the tiles will change to show how close your guess was to the word.")
        Text("Examples")
        WordRowCompare("wordy", "wishe")
        Text("W is in the word and in the correct position")
        WordRowCompare("light", "ieqwe")
        Text("i is in the word but in the wrong position")
        WordRowCompare("rogue", "qwpzz")
        Text("Any letter not in the word")
    }
}

@Composable
fun Buttons() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = {

            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4B7846),
                contentColor = Color.White
            )
        ) {
            Text("Play")
        }
        Button(
            onClick = {

            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4B7846),
                contentColor = Color.White
            )
        ) {
            Text("Score")
        }
    }
}