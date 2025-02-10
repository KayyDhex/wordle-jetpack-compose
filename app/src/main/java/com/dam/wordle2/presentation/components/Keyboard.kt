package com.dam.wordle2.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Keyboard(onKeyPressed: (Char) -> Unit, onBackspace: () -> Unit) {
    val keyboardRows = listOf(
        "QWERTYUIOP",
        "ASDFGHJKLÑ",
        "ZXCVBNM⌫"
    )

    Column(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        keyboardRows.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally)
            ) {
                row.forEach { key ->
                    KeyboardKey(
                        label = key.toString(),
                        onClick = {
                            if (key == '⌫') onBackspace() else onKeyPressed(key)
                        },
                        blockType = BlockType.GREY
                    )
                }
            }
        }
    }
}

@Composable
fun KeyboardKey(label: String, onClick: () -> Unit, blockType: BlockType) {
    val backgroundColor = when (blockType) {
        BlockType.GREEN -> Color(0xFF6AAA64)
        BlockType.YELLOW -> Color(0xFFC9B458)
        BlockType.GREY -> Color(0xFF787C7E)
        BlockType.TRANSPARENT -> Color.Transparent
    }
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        modifier = Modifier.width(25.dp),
        contentPadding = PaddingValues(0.dp) // Remove default padding

    ) {
        Text(text = label, fontSize = 12.sp, modifier = Modifier.padding(0.dp))
    }
}

@Preview
@Composable
fun KeyboardPreview() {
    Keyboard(
        onKeyPressed = { key -> println("Key pressed: $key") },
        onBackspace = { println("Backspace pressed") }
    )
}