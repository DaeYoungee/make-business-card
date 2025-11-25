package com.example.businesscard.result.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun ResultScreen(name: String = "", phone: String = "") {
    val style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Business Card", style = style)
        Spacer(modifier = Modifier.height(24.dp))
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            Text(text = "name: $name")
            Text(text = "phone: $phone")
        }
    }
}