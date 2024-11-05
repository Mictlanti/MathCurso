package com.horizon.matemticascurso.vms

import androidx.lifecycle.ViewModel
import com.horizon.matemticascurso.data.dataStore.DataPreferences
import com.horizon.matemticascurso.data.model.UserState
import com.horizon.matemticascurso.ui.theme.backgroundDark
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UserStateVM(private val dataPreferences: DataPreferences): ViewModel() {

    private val _state = MutableStateFlow(UserState())
    val state: StateFlow<UserState> = _state.asStateFlow()

    init {
        loadIndexColor()
    }

    private fun loadIndexColor() {
        val indexColor = dataPreferences.getSelectedColor()
        val isDarkTheme = dataPreferences.getThemeMode()
        _state.update { currentState ->
            currentState.copy(
                indexColor = indexColor,
                isDarkMode = isDarkTheme
            )
        }
        updateBackgroundColor(indexColor)
    }

    private fun updateBackgroundColor(indexColor: Int) {
        val background = _state.value.listColorsLight.getOrElse(indexColor) { backgroundDark }
        _state.update { currentState ->
            currentState.copy(background = background)
        }
    }

    fun saveIndexColor(index: Int) {
        _state.update { state ->
            state.copy(indexColor = index)
        }
        dataPreferences.saveSelectedColor(index)
        updateBackgroundColor(index)
    }

}