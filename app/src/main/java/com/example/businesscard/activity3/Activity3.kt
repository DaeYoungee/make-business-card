package com.example.businesscard.activity3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.businesscard.activity3.ui.theme.MyApplicationTheme
import com.example.businesscard.activity4.Activity4
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Activity3 : ComponentActivity() {
    external fun nativeIncrement()
    external fun nativeGetCount(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        System.loadLibrary("nativetest-lib")

        enableEdgeToEdge()
        // 네이티브 count 초기화
        val initialCount = nativeGetCount()

        setContent {

            var count by remember { mutableIntStateOf(initialCount) }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Count = $count")

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        // 1 증가 (native)
                        nativeIncrement()
                        val newCount = nativeGetCount()
                        count = newCount

                        if (newCount > 10_000) {
                            startActivity(Intent(this@Activity3, Activity4::class.java))
                        }
                    }
                ) {
                    Text("Count 증가")
                }
            }

        }
    }
}