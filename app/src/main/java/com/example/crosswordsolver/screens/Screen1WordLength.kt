package com.example.crosswordsolver.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crosswordsolver.R

/**
 * Композ-функция, отвечающая за экран Выбора Длины Слова.
 *
 * @param onButtonLengthClick - функция обратного вызова, вызываемая при нажатии кнопки,
 *                       которая принимает длину слова и загружает соответствующий список слов.
 */
@Composable
fun Screen1WordLength(
    onButtonLengthClick: (Int) -> Unit
) {
    Screen1Display(onButtonLengthClick = onButtonLengthClick)
}

/**
 * Композ-функция, отвечающая за отрисовку данного экрана.
 *
 * - [Text] - элемент текста, предлагающий пользователю выбрать длину слова.
 * - [ButtonGrid] - функция, отображающая сетку из 12 кнопок для выбора длины слова.
 */
@Composable
private fun Screen1Display(onButtonLengthClick: (Int) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.choose_length),
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 24.dp)
        )
        ButtonGrid(onButtonLengthClick)
    }
}

/**
 * Композ-функция, отображающая сетку из 12 кнопок.
 *
 * Каждая кнопка при нажатии вызывает коллбэк [onButtonLengthClick] с соответствующим значением.
 * Это значение используется для загрузки списка слов из файла в зависимости от нажатой кнопки.
 *
 *  @param onButtonLengthClick Лямбда-функция, принимающая целочисленное значение.
 *                      Вызывается при нажатии на кнопку, предоставляя длину слова.
 *
 */
@Composable
private fun ButtonGrid(
    onButtonLengthClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 0.dp, end = 0.dp, top = 0.dp),
        verticalArrangement = Arrangement.Center
    ) {
        var value = 3
        for (x in 1..4) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                for (y in 3..5) {
                    val buttonValue = value
                    Button(
                        onClick = {
                            onButtonLengthClick(buttonValue)
                        },
                        modifier = Modifier
                            .size(120.dp)
                            .padding(12.dp)
                    ) {
                        Text(
                            text = "$buttonValue",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    value++
                }
            }
        }
    }
}

@Preview
@Composable

fun Screen1Preview() {
    Screen1WordLength {  }
}
