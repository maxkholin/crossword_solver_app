package com.example.crosswordsolver.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crosswordsolver.R
import com.example.crosswordsolver.logic.searchBySet
import com.example.crosswordsolver.model.LetterButtonModel

private const val MODE_SET = 1

@Composable
fun ScreenResult(
    words: List<String>,
    chosenLetters: Set<LetterButtonModel>,
    exludeLetters: Set<LetterButtonModel>,
    onTryAgainButtonClick: () -> Unit,
    mode: Int
) {
    val foundWords = if (mode == MODE_SET) {
        searchBySet(words, chosenLetters, exludeLetters)
    } else {
        listOf("Привет", " Макс")
    }

    if (foundWords.isEmpty()) {
        TryAgain(onTryAgainButtonClick)
    } else {
        Result(foundWords, onTryAgainButtonClick)
    }
}


@Composable
private fun Result(
    words: List<String>,
    onTryAgainButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.words_found) + words.size,
            fontSize = 48.sp,
            modifier = Modifier.padding(horizontal = 100.dp, vertical = 32.dp)
        )
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 16.dp)
        ) {
            items(words) { word ->
                Text(
                    text = word,
                    fontSize = 36.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        TryAgainButton(onTryAgainButtonClick)
    }
}

@Composable
private fun TryAgain(
    onTryAgainButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.not_found),
            fontSize = 48.sp
        )
        Spacer(modifier = Modifier.height(48.dp))
        TryAgainButton(onTryAgainButtonClick)
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
fun TryAgainButton(onTryAgainButtonClick: () -> Unit) {
    Button(
        onClick = onTryAgainButtonClick,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.try_again),
            fontSize = 36.sp
        )
    }
}