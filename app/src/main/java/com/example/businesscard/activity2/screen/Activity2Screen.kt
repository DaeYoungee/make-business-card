package com.example.businesscard.activity2.screen

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.businesscard.activity2.TwoViewModel

@Composable
fun Activity2Screen(viewModel: TwoViewModel = hiltViewModel()) {
    val input = viewModel.input.collectAsStateWithLifecycle().value

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            placeholder = { Text(text = TwoViewModel.URL) },
            singleLine = true,
            value = input,
            onValueChange = { viewModel.setInput(it) },
        )
        if (input.isNotEmpty()) {
            CustomWebView(url = input)
        }
    }
}

@Composable
fun ColumnScope.CustomWebView(
    url: String,
) {
    AndroidView(
        modifier = Modifier.weight(1f).fillMaxWidth(),
        factory = {
            val myWebView = WebView(it)
            // 스마트폰 browser로 실행되는게 아니라 인앱에서 웹뷰를 띄우기 위해 WebViewClient 할당
            myWebView.webViewClient = WebViewClient()

            myWebView.apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        }, update = {
            it.loadUrl(url)
        })
}
