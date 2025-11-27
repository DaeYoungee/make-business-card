package com.example.businesscard.activity1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.businesscard.activity1.screen.Activity1Screen
import com.example.businesscard.activity1.ui.theme.MyApplicationTheme
import com.example.businesscard.activity2.Activity2
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Activity1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Activity1Screen(startActivity2 = ::startActivity2)
            }
        }
    }

    fun startActivity2() {
        val intent = Intent(this, Activity2::class.java)
        startActivity(intent)
    }
}
