package com.example.androidhub.ui.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(): ViewModel() {

    private var _selectedTab = mutableStateOf(1)
    val selectedTab: State<Int> = _selectedTab

    fun setSelectedTab(tab: Int) {
        _selectedTab.value = tab
    }

}