package com.example.crosswordsolver

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.crosswordsolver.screens.Screen1WordLength

@Composable
fun CrosswordSolverApp(

) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Screen1WordLength { }


    }

}
