package com.example.businesscard.activity2

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TwoViewModel @Inject constructor(): ViewModel(){

    private var _input = MutableStateFlow("")
    val input: StateFlow<String> = _input.asStateFlow()

    fun setInput(text: String) {
        _input.update { text }
    }

    companion object {
        const val URL = "URL"
    }
}