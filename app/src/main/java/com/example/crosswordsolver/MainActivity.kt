package com.example.crosswordsolver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.crosswordsolver.ui.theme.CrosswordSolverTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrosswordSolverTheme {
                CrosswordSolverApp()
            }
        }
    }
}
