package com.dam.wordle2.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class BlockType {
    GREEN, YELLOW, GREY, TRANSPARENT
}

@Composable
fun Block(character: Char, blockType: BlockType) {
    val backgroundColor = when (blockType) {
        BlockType.GREEN -> Color(0xFF6AAA64)
        BlockType.YELLOW -> Color(0xFFC9B458)
        BlockType.GREY -> Color(0xFF787C7E)
        BlockType.TRANSPARENT -> Color.Transparent
    }

    Box(
        modifier = Modifier
            .size(50.dp)
            .background(backgroundColor, shape = RoundedCornerShape(4.dp))
            .border(2.dp, Color.Gray, shape = RoundedCornerShape(4.dp)), // Grey border ,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = character.toString(),
            fontSize = 24.sp,
            color = Color.White
        )
    }
}

@Composable
fun WordRow(word: String, highlightedIndex: Int) {
    Row (
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        word.forEachIndexed { index, character ->
            val blockType = if (index == highlightedIndex) BlockType.GREEN else BlockType.TRANSPARENT
            Block(character, blockType)
        }
    }
}

@Composable
fun WordRowCompare(word: String, guess: String) {
    Row (
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        word.forEachIndexed { index, character ->
            var blockType = BlockType.TRANSPARENT
            if(index < guess.length && character == guess[index] ){
                blockType = BlockType.GREEN
            }else if(guess.contains(character)){
                blockType = BlockType.YELLOW
            }else if(!guess.contains(character)){
                blockType = BlockType.GREY
            }
            Block(character, blockType)
        }
    }
}

@Preview
@Composable
fun BlockPreview() {
    Block('A', BlockType.GREY)
}

@Preview
@Composable
fun WordRowPreview() {
    WordRow("WORDY", 0) // Only the first letter 'W' is green
}

@Preview
@Composable
fun WordRowComparePreview() {
    WordRowCompare("WORDY", "WRODY") // 'W', 'O', 'R', 'D' are green
}