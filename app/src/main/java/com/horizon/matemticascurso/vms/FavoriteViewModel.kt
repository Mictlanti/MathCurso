package com.horizon.matemticascurso.vms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horizon.matemticascurso.module.TopicData
import com.horizon.matemticascurso.repository.MathRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: MathRepository) : ViewModel() {

    private val _mathList = MutableStateFlow<List<TopicData>>(emptyList())
    val mathList = _mathList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllFavorites().collect { item ->
                if(item.isEmpty()) {
                    _mathList.value = emptyList()
                } else {
                    _mathList.value = item
                }
            }
        }
    }

    fun insertTopic(math: TopicData) = viewModelScope.launch { repository.insert(math) }

    fun updateTopic(math: TopicData) = viewModelScope.launch { repository.update(math) }

    fun deleteTopic(math: TopicData) = viewModelScope.launch { repository.delete(math) }

}