package com.horizon.matemticascurso.vms

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horizon.matemticascurso.data.model.ExerciseState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
class TopicVM : ViewModel() {

    private val _state = MutableStateFlow(ExerciseState())
    val state: StateFlow<ExerciseState> = _state.asStateFlow()

    fun activeBtnIndex(activeBtn: Int) {
        _state.update { state ->
            state.copy(activeBtnIndex = activeBtn)
        }
    }

    fun onValueChangeOne(onValue: String) {
        _state.update {
            it.copy(onValueChange = onValue)
        }
    }

    fun onValueChangeTwo(onValue: String) {
        _state.update {
            it.copy(onValueChangeTwo = onValue)
        }
    }

    fun onValueChangeThree(onValue: String) {
        _state.update {
            it.copy(onValueChangeThree = onValue)
        }
    }

    fun onValueChangeFour(onValue: String) {
        _state.update {
            it.copy(onValueChangeFour = onValue)
        }
    }

    fun checkInt(scope: CoroutineScope, pagerState: PagerState, indexCorrect : Int) {
        animatedScroll(scope, pagerState, _state.value.activeBtnIndex == indexCorrect)
    }

    fun checkFinishInt(indexCorrect: Int) {
        val s = _state.value
        if(_state.value.activeBtnIndex == indexCorrect) {
            _state.value = s.copy(
                correct = true,
                finishAds = true
            )
        }
        else {
            _state.value = s.copy(
                incorrect = true
            )
        }
        resetValues()
    }

    fun checkFinishString(isCorrect: Boolean) {
        val s = _state.value
        if(isCorrect) {
            _state.value = s.copy(
                correct = true,
                finishAds = true
            )
        }
        else {
            _state.value = s.copy(
                incorrect = true
            )
        }
        resetValues()
    }

    fun animatedScroll(scope: CoroutineScope, pagerState: PagerState, isCorrect: Boolean) {
        val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
        if(isCorrect){
            scope.launch {
                delay(1000)
                pagerState.animateScrollToPage(
                    nextPage,
                    animationSpec = tween(
                        durationMillis = 2000,
                        easing = LinearEasing
                    )
                )
            }
            _state.value = _state.value.copy(
                correct = true
            )
        }
        else {
            _state.value = _state.value.let {
                it.copy(
                    lifes = it.lifes - 1,
                    incorrect = true
                )
            }
        }
        resetValues()
    }

    private fun resetValues() {
        viewModelScope.launch {
            if (_state.value.incorrect || _state.value.correct) {
                delay(990)
                _state.value = _state.value.copy(
                    activeBtnIndex = 0,
                    incorrect = false,
                    correct = false,
                    onValueChange = "",
                    onValueChangeTwo = "",
                    onValueChangeThree = "",
                    onValueChangeFour = ""
                )
            }
        }
    }

    fun resetAds() {
        _state.value = _state.value.copy(
            finishAds = false
        )
    }

    fun newLives(){
        _state.value = _state.value.copy(
            lifes = 3
        )
    }

}