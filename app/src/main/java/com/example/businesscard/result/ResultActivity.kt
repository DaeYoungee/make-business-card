package com.example.businesscard.result

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.result.component.ResultScreen
import com.example.businesscard.result.ui.theme.MyApplicationTheme

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("name") ?: ""
        val phone = intent.getStringExtra("phone") ?: ""

        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
                        ResultScreen(name = name, phone = phone)
                    }
                }
            }
        }
    }
}

