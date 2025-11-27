package com.example.businesscard.activity0

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.businesscard.activity0.screen.Activity0Screen
import com.example.businesscard.activity0.ui.theme.MyApplicationTheme
import com.example.businesscard.activity1.Activity1
import com.example.businesscard.activity3.Activity3
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Activity0 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Activity0Screen(startActivity1 = ::startActivity1, startActivity3 = ::startActivity3)
            }
        }
    }

    fun startActivity1() {
        val intent = Intent(this, Activity1::class.java)
        startActivity(intent)
    }
    fun startActivity3() {
        val intent = Intent(this, Activity3::class.java)
        startActivity(intent)
    }
}
