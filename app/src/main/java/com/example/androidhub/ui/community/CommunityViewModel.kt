package com.example.androidhub.ui.community

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(): ViewModel() {

    private var _selectedScreen = mutableStateOf(1)
    val selectedScreen: State<Int> = _selectedScreen

    fun setSelectedScreen(selectedScreen: Int) {
        _selectedScreen.value = selectedScreen
    }

}