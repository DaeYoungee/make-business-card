package com.example.businesscard.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.businesscard.main.component.MainScreen
import com.example.businesscard.main.ui.theme.MyApplicationTheme
import com.example.businesscard.result.ResultActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
                        MainScreen(startResultActivity = ::startResultActivity)
                    }
                }
            }
        }
    }

    fun startResultActivity(name: String, phone: String) {
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("name", name)
            putExtra("phone", phone)
        }
        startActivity(intent)
    }
}