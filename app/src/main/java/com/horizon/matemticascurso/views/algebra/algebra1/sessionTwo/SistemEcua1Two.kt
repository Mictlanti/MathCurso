@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.sessionTwo

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.alertBtnStyle
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.components.topicsComponents.examplesToExercise.eToSistemEcuaOneSession1
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SistemEcua1TwoScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 7 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "sistema ecuaciones 1 sesion2", analytics = analytics)
    alertBtnStyle(
        PartiallyExpanded = true,
        showExample = showExample.value,
        onDismissRequest = { showExample.value = false },
        content = { eToSistemEcuaOneSession1(userStateVM) }
    )

    TopBarTopics(
        navController,
        titleTopBar = "Sistema de ecuaciones",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseSistemEcua1Two1(modifier, pagerState, topicVM, scope, userStateVM)
                1 -> LazyExerciseSistemEcua1Two2(modifier, pagerState, topicVM, scope, userStateVM)
                2 -> LazyExerciseSistemEcua1Two3(modifier, pagerState, topicVM, scope, userStateVM)
                3 -> LazyExerciseSistemEcua1Two4(modifier, pagerState, topicVM, scope, userStateVM)
                4 -> LazyExerciseSistemEcua1Two5(modifier, pagerState, topicVM, scope, userStateVM)
                5 -> LazyExerciseSistemEcua1Two6(modifier, pagerState, topicVM, scope, userStateVM)
                6 -> LazyExerciseSistemEcua1Two7(modifier, navController, topicVM, userStateVM)
                //4 -> LazyExerciseSistemEcua1Two6(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 7,
        spaceByBoxes = 20.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseSistemEcua1Two1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Two1(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1Two1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    ctx: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if(state.onValueChange == "-1") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if(state.onValueChange.isEmpty()) {
            Toast.makeText(ctx, "Error", Toast.LENGTH_SHORT).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyMedium(text = stringResource(id = R.string.exerciseSistemOne2_one), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_three_dark,
            painterL = R.drawable.ejer_sistemecuaone_three_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        bodyMedium(text = stringResource(id = R.string.exerciseSistemOne2_two), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "(x - 5y) + (3x + 5y) = -11 + 7", modifier = Modifier)
        SpaceH()
        bodyLarge(text = "x = ${state.onValueChange}", modifier = Modifier.align(Alignment.CenterHorizontally))
        OutlinedTextString(
            value = state.onValueChange,
            onValueChange = {
                topicVM.onValueChangeOne(
                    onValue = it
                )
            },
            keyboardType = KeyboardType.Number,
            placeholder = null
        )
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSistemEcua1Two2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Two2(pagerState,topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1Two2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    ctx: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if(state.onValueChange == "2") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if(state.onValueChange.isEmpty()) {
            Toast.makeText(ctx, "Error", Toast.LENGTH_SHORT).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val modi = Modifier.align(Alignment.CenterHorizontally)
        bodyMedium(text = stringResource(id = R.string.exerciseSistemOne2_three), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_three_onepoint_dark,
            painterL = R.drawable.ejer_sistemecuaone_three_onepoint_light,
            modifier = modi
        )
        bodyMedium(text = stringResource(id = R.string.exerciseSistemOne2_four), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "y = ${state.onValueChange}", modifier = modi)
        OutlinedTextString(
            value = state.onValueChange,
            onValueChange = {
                topicVM.onValueChangeOne(
                    onValue = it
                )
            },
            keyboardType = KeyboardType.Number,
            placeholder = null
        )
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSistemEcua1Two3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Two3(pagerState,topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1Two3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    ctx: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if(state.onValueChange == "-1,2" || state.onValueChange == " - 1, 2" || state.onValueChange == "-1, 2") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if(state.onValueChange.isEmpty()) {
            Toast.makeText(ctx, "Error", Toast.LENGTH_SHORT).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val modi = Modifier.align(Alignment.CenterHorizontally)
        bodyMedium(text = stringResource(id = R.string.exerciseSistemOne2_three), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_three_twopoint_dark,
            painterL = R.drawable.ejer_sistemecuaone_three_twopoint_light,
            modifier = modi
        )
        bodyMedium(text = stringResource(id = R.string.exerciseSistemOne2_five), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "(x, y) = (${state.onValueChange})", modifier = modi)
        OutlinedTextString(
            value = state.onValueChange,
            onValueChange = {
                topicVM.onValueChangeOne(
                    onValue = it
                )
            },
            keyboardType = KeyboardType.Number,
            placeholder = null
        )
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

/* @Composable
fun LazyExerciseSistemEcua1Two3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Two3(pagerState,topicVM, scope) }
    }
}

@Composable
fun ExerciseSistemEcua1Two3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val Button1 = remember { mutableStateOf(false) } //correct
    val Button2 = remember { mutableStateOf(false) } //incorrect
    val btn3 = remember { mutableStateOf(false) } //correct
    val btn4 = remember { mutableStateOf(false) } //incorrect
    val btn5 = remember { mutableStateOf(false) } //correct
    val btn6 = remember { mutableStateOf(false) } //incorrect
    val listOne = listOf("x = 2", "x = -2")
    val listTwo = listOf("y = 0", "y = -1/2")
    val listThree = listOf("(x,y) = (2,0)", "(x,y)= (0,2)")
    val recycleModi = Modifier.fillMaxWidth()
    val scope = rememberCoroutineScope()
    fun scroll() {
        scope.launch {
            pagerState.animateScrollToPage(
                nextPage,
                animationSpec = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                )
            )
        }
    }
    LaunchedEffect(key1 = Button1.value || btn4.value || btn6.value) {
        if (Button1.value || btn4.value || btn6.value) {
            delay(1200)
            Button1.value = false
            btn4.value = false
            btn6.value = false
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyMedium(text = stringResource(id = R.string.exerciseSistemOne2_one), modifier = Modifier)
        Image(
            painter = painterResource(id = R.drawable.ejer_sistemecuaone_six),
            contentDescription = "Image",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        bodyMedium(text = stringResource(id = R.string.exerciseSistemOne2_two), modifier = Modifier)
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                checkBtnExersice(
                    onClick = {
                        when (index) {
                            0 -> {
                                Button1.value = true
                                realtimeManager.answerIncorrect()
                            }

                            1 -> Button2.value = true
                        }
                    },
                    enabled = when (index) {
                        0 -> !Button2.value
                        1 -> !Button1.value
                        else -> !Button1.value
                    },
                    checkBorder = when (index) {
                        0 -> Button1.value
                        1 -> Button2.value
                        else -> Button1.value
                    },
                    color = when (index) {
                        0 -> md_theme_light_error
                        1 -> md_theme_light_primary
                        else -> colorAlpha_dark
                    },
                    modifier = when (index) {
                        0 -> recycleModi.weight(1f)
                        1 -> recycleModi.weight(1f)
                        else -> recycleModi.weight(1f)
                    },
                    content = { bodyLarge(text = s, modifier = Modifier) }
                )
            }
        }
        AnimatedVisibility(
            visible = Button2.value,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box {
                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    bodyMedium(
                        text = stringResource(id = R.string.exerciseSistemOne2_four),
                        modifier = Modifier
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ejer_sistemecuaone_seven),
                        contentDescription = "Image",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Row(modifier = recycleModi) {
                        listTwo.forEachIndexed { index, s ->
                            checkBtnExersice(
                                onClick = {
                                    when (index) {
                                        0 -> btn3.value = true
                                        1 -> {
                                            btn4.value = true
                                            realtimeManager.answerIncorrect()
                                        }
                                    }
                                },
                                enabled = when (index) {
                                    0 -> !btn4.value
                                    1 -> !btn3.value
                                    else -> !btn3.value
                                },
                                checkBorder = when (index) {
                                    0 -> btn3.value
                                    1 -> btn4.value
                                    else -> btn3.value
                                },
                                color = when (index) {
                                    0 -> md_theme_light_primary
                                    1 -> md_theme_light_error
                                    else -> colorAlpha_dark
                                },
                                modifier = when (index) {
                                    0 -> recycleModi.weight(1f)
                                    1 -> recycleModi.weight(1f)
                                    else -> recycleModi.weight(1f)
                                },
                                content = { bodyLarge(text = s, modifier = Modifier) }
                            )
                        }
                    }
                }
            }
        }
        AnimatedVisibility(
            visible = btn3.value,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box {
                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    bodyMedium(
                        text = stringResource(id = R.string.exerciseSistemOne2_five),
                        modifier = Modifier
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ejer_sistemecuaone_eight),
                        contentDescription = "Image",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Row(modifier = recycleModi) {
                        listThree.forEachIndexed { index, s ->
                            checkBtnExersice(
                                onClick = {
                                    when (index) {
                                        0 -> btn5.value = true
                                        1 -> {
                                            btn6.value = true
                                            realtimeManager.answerIncorrect()
                                        }
                                    }
                                },
                                enabled = when (index) {
                                    0 -> !btn6.value
                                    1 -> !btn5.value
                                    else -> !btn5.value
                                },
                                checkBorder = when (index) {
                                    0 -> btn5.value
                                    1 -> btn6.value
                                    else -> btn5.value
                                },
                                color = when (index) {
                                    0 -> md_theme_light_primary
                                    1 -> md_theme_light_error
                                    else -> colorAlpha_dark
                                },
                                modifier = when (index) {
                                    0 -> recycleModi.weight(1f)
                                    1 -> recycleModi.weight(1f)
                                    else -> recycleModi.weight(1f)
                                },
                                content = { bodyLarge(text = s, modifier = Modifier) }
                            )
                        }
                    }
                }
            }
        }
        AnimatedVisibility(
            visible = btn5.value,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Button(
                onClick = { scroll() },
                modifier = recycleModi,
                colors = ButtonDefaults.buttonColors(containerColor = colorAlpha_dark)
            ) {
                titleMedium(text = "Siguiente")
            }
        }
    }
} */

@Composable
fun LazyExerciseSistemEcua1Two4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Two4(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1Two4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val state by topicVM.state.collectAsState()
    val listAns = listOf("y = -2", "y = -3")
    val modi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyMedium(text = stringResource(id = R.string.exerciseSistemOne2_one), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_nine_dark,
            painterL = R.drawable.ejer_sistemecuaone_nine_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        bodyMedium(text = stringResource(id = R.string.exerciseSistemOne2_six), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "(-2x - 7y) - (-2x - 5y) = 25 + 19", modifier = Modifier)
        if(state.correct) bodyLarge(
            text = "y = -3",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        Row(modifier = modi) {
            listAns.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 1,
                    modifier = modi.weight(1f),
                    topicVM
                ) {
                     bodyLarge(text = s, modifier = Modifier)
                }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSistemEcua1Two5(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Two5(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1Two5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val state by topicVM.state.collectAsState()
    val listAns = listOf("x = -2", "x = -3")
    val listAnsOne = listOf("x = 1", "x = -4")
    val modi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyMedium(text = stringResource(id = R.string.exerciseSistemOne2_one), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_nine_one_dark,
            painterL = R.drawable.ejer_sistemecuaone_nine_one_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        bodyMedium(text = stringResource(id = R.string.exerciseSistemOne2_seven), modifier = Modifier)
        SpaceH()
        if(state.correct) bodyLarge(
            text = "y = -2",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(modifier = modi) {
            listAns.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 1,
                    modifier = modi.weight(1f),
                    topicVM
                ) {
                    bodyLarge(text = s, modifier = Modifier)
                }
            }
        }
        Row(modifier = modi) {
            listAnsOne.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 3,
                    modifier = modi.weight(1f),
                    topicVM
                ) {
                    bodyLarge(text = s, modifier = Modifier)
                }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSistemEcua1Two6(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Two6(pagerState,topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1Two6(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    ctx: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if(state.onValueChange == "-2,-3" || state.onValueChange == " - 2, -3" || state.onValueChange == "-2, -3") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if(state.onValueChange.isEmpty()) {
            Toast.makeText(ctx, "Error", Toast.LENGTH_SHORT).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val modi = Modifier.align(Alignment.CenterHorizontally)
        bodyMedium(text = stringResource(id = R.string.exerciseSistemOne2_three), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_nine_two_light,
            painterL = R.drawable.ejer_sistemecuaone_nine_two_light,
            modifier = modi
        )
        bodyMedium(text = stringResource(id = R.string.exerciseSistemOne2_five), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "(x,y) = (${state.onValueChange})", modifier = modi)
        OutlinedTextString(
            value = state.onValueChange,
            onValueChange = {
                topicVM.onValueChangeOne(
                    onValue = it
                )
            },
            keyboardType = KeyboardType.Number,
            placeholder = null
        )
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSistemEcua1Two7(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Two7(navController, topicVM, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1Two7(
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val listAns = listOf("Verdadero", "Falso")
    val modi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyMedium(text = stringResource(id = R.string.sistemEcua1Three_one), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_nine_dark,
            painterL = R.drawable.ejer_sistemecuaone_nine_light,
            modifier = align
        )
        bodyLarge(
            text = "(x, y) = (-2, -3)",
            modifier = align
        )
        SpaceH()
        HorizontalDivider()
        bodyLarge(text = stringResource(id = R.string.VoF), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.sistemEcua1Three_two), modifier = Modifier)
        bodyLarge(text = "-2(-2) - 7(-3) = 25", modifier = align)
        bodyLarge(text = "25 = 25", modifier = align)
        bodyMedium(text = stringResource(id = R.string.sistemEcua1Three_three), modifier = align)
        bodyLarge(text = "-2(-2) - 5(-3) = 19", modifier = align)
        bodyLarge(text = "19 = 19", modifier = align)
        SpaceH()
        Row(modifier = modi) {
            listAns.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 1,
                    modifier = modi.weight(1f),
                    topicVM
                ) {
                    bodyLarge(text = s, modifier = Modifier)
                }
            }
        }
        btnNextTopic(onClick = { scroll() }, topicVM, navController, destination = AppScreens.sistemEcua1Three)
    }
}

@Composable
fun LazyExerciseSistemEcua1Two71(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Two71(navController, topicVM) }
    }
}

@Composable
fun ExerciseSistemEcua1Two71(navController: NavController, topicVM: TopicVM) {

    val listOne = listOf("(x,y)=(-2,-3)", "(x,y)=(2,3)")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        Image(
            painter = painterResource(id = R.drawable.ejer_sistemecuaone_eleven),
            contentDescription = "Image",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        btnNextTopic(
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.sistemEcua1Three
        )
    }
}