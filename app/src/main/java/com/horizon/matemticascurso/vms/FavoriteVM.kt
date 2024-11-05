package com.horizon.matemticascurso.vms

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horizon.matemticascurso.data.model.FavoriteState
import com.horizon.matemticascurso.repository.MathRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteVM @Inject constructor(private val repository: MathRepository) : ViewModel() {

    var state by mutableStateOf(FavoriteState())
        private set

    fun getTopicById(id: Long) = viewModelScope.launch(Dispatchers.IO) {
        repository.getFavoritesById(id).collect {item ->
            if(item != null) {
                state = state.copy(title = item.title)
            } else {
                Log.d("Error", "Error in database")
            }
        }
    }

}