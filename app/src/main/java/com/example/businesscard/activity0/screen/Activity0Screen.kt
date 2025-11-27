package com.example.businesscard.activity0.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Activity0Screen(startActivity1: () -> Unit, startActivity3: () -> Unit ) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { startActivity1() }
        ) { Text(text = "startActivity_1") }

        Button(
            onClick = { startActivity3() }
        ) { Text(text = "startActivity_3") }
    }
}