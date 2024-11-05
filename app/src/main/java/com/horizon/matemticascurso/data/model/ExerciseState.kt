package com.horizon.matemticascurso.data.model

data class ExerciseState(
    val activeBtnIndex: Int = 0,
    val correct: Boolean = false,
    val incorrect: Boolean = false,
    val finishAds: Boolean = false,
    val lifes: Int = 3,
    val onValueChange: String = "",
    val onValueChangeTwo: String = "",
    val onValueChangeThree: String = "",
    val onValueChangeFour: String = "",
    val textNull: String = ""
)
