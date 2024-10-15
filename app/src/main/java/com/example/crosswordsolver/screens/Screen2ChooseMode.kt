package com.example.crosswordsolver.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crosswordsolver.R


private const val MODE_SET = 1
private const val MODE_MASK = 2

@Composable
fun ScreenChooseMode(
    onModeButtonClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.choose_mode),
            textAlign = TextAlign.Center,
            fontSize = 36.sp
        )
        DisplayButtons(onModeButtonClick)
        DisplayDescription()
    }
}

@Composable
private fun DisplayButtons(
    onModeButtonClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for (i in 1..2) {
            val modeButton = if (i == MODE_SET) MODE_SET else MODE_MASK
            Button(
                onClick = { onModeButtonClick(modeButton) },
                modifier = Modifier
                    .padding(16.dp)
                    .size(160.dp)
                    .clip(CircleShape),
                elevation = ButtonDefaults.buttonElevation(pressedElevation = 20.dp),
            ) {
                val modeText = if (i == MODE_SET) {
                    stringResource(R.string.mode_set)
                } else {
                    stringResource(R.string.mode_mask)
                }
                Text(
                    text = modeText,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun DisplayDescription() {
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        for (i in 1..2) {
            val modeText = if (i == MODE_SET) {
                stringResource(R.string.mode_set_description)
            } else {
                stringResource(R.string.mode_mask_description)
            }
            Text(
                text = modeText,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            )
        }
    }
}


