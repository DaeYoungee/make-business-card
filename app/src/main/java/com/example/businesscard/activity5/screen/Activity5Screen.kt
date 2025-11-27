package com.example.businesscard.activity5.screen

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
import com.example.businesscard.activity2.TwoViewModel
import com.example.businesscard.activity5.FiveViewModel

@Composable
fun Activity5Screen(modifier: Modifier = Modifier, viewModel: FiveViewModel = hiltViewModel()) {

    val inputSave = viewModel.inputSave.collectAsStateWithLifecycle().value
    val inputCheck = viewModel.inputCheck.collectAsStateWithLifecycle().value

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            placeholder = { Text(text = "sharedpreference_save") },
            singleLine = true,
            suffix = {
                Button(onClick = { viewModel.save(inputSave) }) { Text("save") }
            },
            value = inputSave,
            onValueChange = { viewModel.setInputSave(it) },
        )
        OutlinedTextField(
            placeholder = { Text(text = "sharedpreference_check") },
            singleLine = true,
            suffix = {
                Button(onClick = { viewModel.compareSfData(inputCheck) }) { Text("check") }
            },
            value = inputCheck,
            onValueChange = { viewModel.setInputCheck(it) },
        )
    }
}