package com.example.businesscard.main.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.businesscard.main.MainViewModel

@Composable
@Preview(showBackground = true)
fun MainScreen(viewModel: MainViewModel= hiltViewModel()) {

    val name = viewModel.name.collectAsStateWithLifecycle().value
    val phone = viewModel.phone.collectAsStateWithLifecycle().value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Input(
            placeholder = "name",
            value = name,
            onValueChange = viewModel::setName,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Input(
            placeholder = "phone",
            value = phone,
            onValueChange = viewModel::setPhone,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(modifier = Modifier.fillMaxWidth(0.9f), onClick = {}, shape = RoundedCornerShape(12.dp)) {
            Text(text = "명함 만들기")
        }
    }

}

@Composable
fun Input(placeholder: String, value: String, onValueChange: (String) -> Unit) {
    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(text = placeholder)
        Spacer(modifier = Modifier.width(12.dp))
        OutlinedTextField(value = value, onValueChange = onValueChange, placeholder = { Text(text = placeholder, color = Color.LightGray) })
    }
}