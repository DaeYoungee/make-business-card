package com.example.businesscard.activity5

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FiveViewModel @Inject constructor(
    @param:ApplicationContext private val context: Context
): ViewModel() {
    private val sf = context.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)

    private var _inputSave = MutableStateFlow("")
    val inputSave: StateFlow<String> = _inputSave.asStateFlow()

    private var _inputCheck = MutableStateFlow("")
    val inputCheck: StateFlow<String> = _inputCheck.asStateFlow()

    fun setInputSave(text: String) {
        _inputSave.update { text }
    }

    fun setInputCheck(text: String) {
        _inputCheck.update { text }
    }

    fun save(text: String) {
        sf.edit().apply { this.putString(SF_SAVE_KEY, text).apply() }
        showToastMsg("저장 성공")
    }

    fun compareSfData(s: String) {
        val original = sf.getString(SF_SAVE_KEY, "")
        if (s == original) {
            showToastMsg("일치")
            return
        }
        showToastMsg("불일치")
    }

    private fun showToastMsg(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val APP_NAME = "daeyoung"
        const val SF_SAVE_KEY = "sf_save_key"
    }
}