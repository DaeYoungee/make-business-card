package com.example.businesscard.activity1

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.businesscard.activity1.util.RandomStringUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class OneViewModel @Inject constructor(
    @param:ApplicationContext private val context: Context
): ViewModel(){

    private var _input = MutableStateFlow("")
    val input: StateFlow<String> = _input.asStateFlow()

    val rValue = RandomStringUtil.randomString8()

    fun setInput(text: String) {
        _input.update { text }
    }

    fun validateInput(input: String, onSuccess: () -> Unit) {
        if (input == rValue) {
            onSuccess()
            return
        }
        showFailToastMsg()
    }

    private fun showFailToastMsg() {
        Toast.makeText(context, "입력하신 번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val COMPARISON_VALUE = "010"
    }
}