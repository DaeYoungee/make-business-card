package com.example.businesscard.activity1.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.businesscard.activity1.OneViewModel

@Composable
fun Activity1Screen(startActivity2: () -> Unit, viewModel: OneViewModel = hiltViewModel()) {

    val input = viewModel.input.collectAsStateWithLifecycle().value


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "hint: ${viewModel.rValue}")
        OutlinedTextField(
            placeholder = { Text(text = viewModel.rValue) },
            singleLine = true,
            value = input,
            onValueChange = { viewModel.setInput(it) },
            suffix = {
                Button(onClick = {viewModel.validateInput(input, startActivity2)}) { Text("check") }
            }
        )
    }
}