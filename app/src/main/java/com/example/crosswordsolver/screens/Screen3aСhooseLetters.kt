package ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crosswordsolver.AppScreen
import com.example.crosswordsolver.R
import com.example.crosswordsolver.model.LetterButtonModel

@Composable
fun ScreenChooseLetters(
    onButtonLetterClick: (LetterButtonModel) -> Unit,
    chosenLetters: Set<LetterButtonModel>,
    trigger: Boolean,
    onButtonNextClick: () -> Unit,
    appScreen: AppScreen
) {
    val configuration = LocalConfiguration.current
    val text: String
    val color: Color

    if (appScreen == AppScreen.ModeSet) {
        text = stringResource(R.string.choose_letters)
        color = Color.Green
    } else {
        text = stringResource(R.string.exlude_letters)
        color = Color.Red
    }

    if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        VerticalLayout(
            onButtonLetterClick,
            chosenLetters,
            onButtonNextClick,
            text,
            color
        )
    } else {
        HorizontalLayout(
            onButtonLetterClick,
            chosenLetters,
            onButtonNextClick,
            text,
            color
        )
    }
}

@Composable
fun VerticalLayout(
    onButtonLetterClick: (LetterButtonModel) -> Unit,
    chosenLetters: Set<LetterButtonModel>,
    onButtonNextClick: () -> Unit,
    text: String,
    color: Color,

    ) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = text,
            fontSize = 48.sp,
            textAlign = TextAlign.Center,
            lineHeight = 56.sp,
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        CreateButtons(
            onButtonLetterClick,
            chosenLetters,
            Configuration.ORIENTATION_PORTRAIT,
            color
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onButtonNextClick) {
            Text(
                text = stringResource(R.string.next),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun HorizontalLayout(
    onButtonLetterClick: (LetterButtonModel) -> Unit,
    chosenLetters: Set<LetterButtonModel>,
    onButtonNextClick: () -> Unit,
    text: String,
    color: Color
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontSize = 40.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
        CreateButtons(
            onButtonLetterClick,
            chosenLetters,
            Configuration.ORIENTATION_LANDSCAPE,
            color
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onButtonNextClick) {
            Text(
                text = stringResource(R.string.next),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
private fun CreateButtons(
    onButtonLetterClick: (LetterButtonModel) -> Unit,
    chosenLetters: Set<LetterButtonModel>,
    orientation: Int,
    color: Color
) {
    val letterGroups =
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            chosenLetters.chunked(8)
        } else {
            chosenLetters.chunked(11)
        }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        letterGroups.forEach { group ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                group.forEach { letter ->
                    Button(
                        onClick = { onButtonLetterClick(letter) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (letter.isPressed) {
                                color
                            } else {
                                Color.Gray
                            }
                        ),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .weight(1f)
                            .padding(2.dp)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "${letter.letter}",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}
