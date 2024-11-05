@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.sessionOne

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Grafics
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnExample
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forBodyorExercise
import com.horizon.matemticascurso.views.components.forTitleorBtn
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.ui.theme.colorAlpha_dark
import com.horizon.matemticascurso.ui.theme.md_theme_dark_errorContainer
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SistemEcua2OneScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 7 })
    val showExample = remember { mutableStateOf(false) }
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "sistema ecuaciones 2 sesion 1", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Sistema de ecuaiones",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExampleSistemEcua2One1(
                    modifier,
                    pagerState,
                    topicVM,
                    scope,
                    userStateVM
                )

                1 -> LazyExampleSistemEcua2One2(modifier, pagerState, nextPage, userStateVM)
                2 -> LazyExampleSistemEcua2One3(modifier, pagerState, nextPage, userStateVM)
                3 -> LazyExerciseSistemEcua2One1(
                    modifier,
                    pagerState,
                    topicVM,
                    scope,
                    userStateVM
                )

                4 -> LazyExerciseSistemEcua2One2(modifier, pagerState, topicVM, scope, userStateVM)
                5 -> LazyExerciseSistemEcua2One3(modifier, pagerState, topicVM, scope, userStateVM)
                6 -> LazyExerciseSistemEcua2One4(modifier, topicVM, navController, userStateVM)
            }
        },
        pagerState,
        repeatBoxes = 7,
        spaceByBoxes = 20.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExampleSistemEcua2One1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item {
            ExampleSistemEcua2One1(
                pagerState,
                topicVM, scope, userStateVM
            )
        }
    }
}

@Composable
private fun ExampleSistemEcua2One1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val listForma = listOf("6x - 3y = 3", "-3y = -6x + 3", "y = 2x - 1")
    fun scroll() {
        if (state.onValueChange == "2x-4" || state.onValueChange == "2x - 4") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        SpaceH()
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_sistemecuatwo_three_dark,
            painterL = R.drawable.ejem_sistemecuatwo_three_light,
            modifier = align
        )
        bodyMedium(text = stringResource(id = R.string.Box1C3_two), modifier = Modifier)
        SpaceH()
        bodyLarge(text = stringResource(id = R.string.SistemEcua2_one), modifier = Modifier)
        listForma.forEach { s ->
            bodyLarge(text = s, modifier = align)
        }
        HorizontalDivider()
        bodyLarge(text = stringResource(id = R.string.SistemEcua2_two), modifier = Modifier)
        bodyLarge(text = "y = ${state.onValueChange}", modifier = align)
        OutlinedTextString(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(it) },
            keyboardType = KeyboardType.Text,
            placeholder = null
        )
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExampleSistemEcua2One2(
    modifier: Modifier,
    pagerState: PagerState,
    nextPage: Int,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExampleSistemEcua2One2(pagerState, nextPage, userStateVM) }
    }
}

@Composable
private fun ExampleSistemEcua2One2(
    pagerState: PagerState,
    nextPage: Int,
    userStateVM: UserStateVM
) {

    val scope = rememberCoroutineScope()
    val listOther = listOf("y = 2x - 1", "y = 2x - 4")

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyMedium(text = stringResource(id = R.string.Box1C3_three), modifier = Modifier)
        listOther.forEach {
            bodyLarge(text = it, modifier = align)
        }
        bodyMedium(text = stringResource(id = R.string.Box1C3_three_one), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.conjunto_vacio_dark,
            painterL = R.drawable.conjunto_vacio_light,
            modifier = align
        )
        bodyMedium(text = stringResource(id = R.string.SistemEcua2_three), modifier = Modifier)
        Grafics(painterR = R.drawable.ejem_sistemecuatwo_two, modifier = align)
        btnExample(onClick = {
            scope.launch {
                pagerState.animateScrollToPage(
                    nextPage,
                    animationSpec = tween(
                        durationMillis = 2000,
                        easing = LinearEasing
                    )
                )
            }
        })
    }
}

@Composable
fun LazyExampleSistemEcua2One3(
    modifier: Modifier,
    pagerState: PagerState,
    nextPage: Int,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExampleSistemEcua2One3(pagerState, nextPage, userStateVM) }
    }
}

@Composable
private fun ExampleSistemEcua2One3(
    pagerState: PagerState,
    nextPage: Int,
    userStateVM: UserStateVM
) {
    val scope = rememberCoroutineScope()
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.desarrollo))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_sistemecuatwo_four_dark,
            painterL = R.drawable.ejem_sistemecuatwo_four_light,
            modifier = Modifier
        )
        HorizontalDivider()
        bodyLarge(text = stringResource(id = R.string.Box3C3_two), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box3C3_three), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box3C3_three_one), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box3C3_three_two), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box3C3_three_three), modifier = Modifier)
        btnExample(onClick = {
            scope.launch {
                pagerState.animateScrollToPage(
                    nextPage,
                    animationSpec = tween(
                        durationMillis = 2000,
                        easing = LinearEasing
                    )
                )
            }
        })
    }
}

@Composable
fun LazyExerciseSistemEcua2One1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2One1(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua2One1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val listAnswerOne = listOf("y = ", state.onValueChange)
    fun scroll() {
        if (state.onValueChange == "-3x+7" || state.onValueChange == "-3x + 7") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box3C3_two), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuatwo_five_dark,
            painterL = R.drawable.ejer_sistemecuatwo_five_light,
            modifier = align
        )
        bodyMedium(text = stringResource(id = R.string.Box3C3_three), modifier = Modifier)
        bodyLarge(text = "3x + y = 7", modifier = align)
        bodyLarge(text = "y = ${state.onValueChange}", modifier = align)
        OutlinedTextString(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(it) },
            keyboardType = KeyboardType.Text,
            placeholder = { Text(text = "y = ") }
        )
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseSistemEcua2One2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2One2(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua2One2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswerOne = listOf("5x - 2y = 8", "5x - 2(-3x + 7) = 8")
    val list = listOf("x = 2", "x = -2")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box3C3_two), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuatwo_five_dark,
            painterL = R.drawable.ejer_sistemecuatwo_five_light,
            modifier = align
        )
        bodyLarge(text = "Despejando \"y\" de 1", modifier = align)
        bodyLarge(text = "y = -3x + 7", modifier = align)
        HorizontalDivider()
        bodyMedium(text = stringResource(id = R.string.Box3C3_three_one), modifier = Modifier)
        listAnswerOne.forEach { s ->
            bodyLarge(text = s, modifier = align)
        }
        Row(modifier = modifier) {
            list.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseSistemEcua2One3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2One3(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua2One3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val list = listOf("(x,y) = (2,1)", "(x,y) = (2,4)")
    val sndList = listOf(
        "Despejando \"y\" de 1",
        "y = -3x + 7",
        "Sustituyendo en 2",
        "5x - 2(-3x + 7) = 8)",
        "x = 2"
    )
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box3C3_two), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuatwo_five_dark,
            painterL = R.drawable.ejer_sistemecuatwo_five_light,
            modifier = align
        )
        sndList.forEach {
            bodyLarge(text = it, modifier = align)
        }
        HorizontalDivider()
        bodyMedium(text = stringResource(id = R.string.Box3C3_three_two), modifier = Modifier)
        Row(modifier = modifier) {
            list.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseSistemEcua2One4(
    modifier: Modifier,
    topicVM: TopicVM,
    navController: NavController,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2One4(topicVM, navController, userStateVM) }
    }
}

@Composable
fun ExerciseSistemEcua2One4(
    topicVM: TopicVM,
    navController: NavController,
    userStateVM: UserStateVM
) {

    val listOne = listOf("Verdadero", "Falso")
    val listAns = listOf(
        "Despejando \"y\" en 2",
        "2x - y = 4",
        "y = 2x - 4",
        "Sustituyendo \"y\" en 1",
        "6x - 3(2x - 4) = 1",
        "6x - 6x + 12 = 1",
        "0 = 11"
    )
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        titleMedium(text = stringResource(id = R.string.VoF))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_sistemecuatwo_three_dark,
            painterL = R.drawable.ejem_sistemecuatwo_three_light,
            modifier = align
        )
        listAns.forEach {
            bodyLarge(text = it, modifier = align)
        }
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.conjunto_vacio_dark,
            painterL = R.drawable.conjunto_vacio_light,
            modifier = align
        )
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        btnNextTopic(onClick = { scroll() }, topicVM, navController, destination = AppScreens.sistemaEcua2Two)
    }
}

@Composable
fun LazyExerciseSistemEcua2One5(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2One5(navController, topicVM) }
    }
}

@Composable
fun ExerciseSistemEcua2One5(navController: NavController, topicVM: TopicVM) {

    var activeButtonIndex by remember { mutableIntStateOf(0) }
    val listOne = listOf("(x,y) = (3,4) ", "(x,y) = (6,2)")
    val ifCorrect = remember { mutableStateOf(false) }
    val ifIncorrect = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(R.string.contestaCorrec), modifier = Modifier)
        Image(
            painter = painterResource(id = R.drawable.ejer_sistemecuatwo_six),
            contentDescription = "Image",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        btnNextTopic(
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.sistemaEcua2Two
        )
    }
}

@Composable
fun Box7C2(pagerState: PagerState, nextPage: Int) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val IfCorrect = remember { mutableStateOf(false) }
    val IfIncorrect = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            Column {
                forTitleorBtn(textForTitle = stringResource(R.string.Box5C3_one))
                Spacer(modifier = Modifier.height(50.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_sistemecuatwo_eight_dark),
                    contentDescription = "Image",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
        Row(modifier = Modifier.padding(top = 80.dp)) {
            Button(
                onClick = { Button1.value = !Button1.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button1.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button2.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                forTitleorBtn(
                    textForTitle = "A) (x,y)=(2,-1)\n" +
                            "B) (x,y)=(1,-2)"
                )
            }
            Button(
                onClick = { Button2.value = !Button2.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button2.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button1.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button2.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.vacio_btn2),
                    contentDescription = "Image",
                )
            }
        }
        Row(modifier = Modifier.padding(vertical = 15.dp)) {
            Button(
                onClick = { Button3.value = !Button3.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button3.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button1.value && !Button2.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button3.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                forTitleorBtn(
                    textForTitle = "A)(x,y) = (2,1)\n" +
                            "B)(x,y)=(0,-2)"
                )
            }
            Button(
                onClick = { Button4.value = !Button4.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button4.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button1.value && !Button2.value && !Button3.value && !IfCorrect.value && !IfIncorrect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button4.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.vacio_btn4),
                    contentDescription = "Image"
                )
            }
        }
        Box {
            Button(
                onClick = {
                    when {
                        Button1.value -> IfIncorrect.value = !IfIncorrect.value
                        Button2.value -> IfIncorrect.value = !IfIncorrect.value
                        Button3.value -> {
                            IfCorrect.value = !IfCorrect.value
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

                        Button4.value -> IfIncorrect.value = !IfIncorrect.value
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = when {
                        IfIncorrect.value -> md_theme_dark_errorContainer
                        IfCorrect.value -> Color.Green
                        else -> colorAlpha_dark
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                titleMedium(
                    text = when {
                        IfIncorrect.value -> "Sigue intentando"
                        IfCorrect.value -> "¡Bien hecho!"
                        else -> "Comprueba la respuesta"
                    }
                )
            }
        }
    }
}

@Composable
fun LazyColumnBox8C2(modifier: Modifier, navController: NavController) {
    LazyColumn(modifier = modifier) {
        item { Box8C2(navController) }
    }
}

@Composable
fun Box8C2(navController: NavController) {

    val ButtonV = remember { mutableStateOf(false) }
    val ButtonF = remember { mutableStateOf(false) }
    val ColorIncorrect = remember { mutableStateOf(false) }
    val ColorCorrect = remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            Column {
                titleMedium(text = stringResource(id = R.string.VoF))
                Spacer(modifier = Modifier.height(10.dp))
                forBodyorExercise(body = stringResource(id = R.string.Box8C3_one))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_sistemecuatwo_nine_dark),
                    contentDescription = "Image",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
        Row(modifier = Modifier.padding(top = 20.dp)) {
            Button(
                onClick = { ButtonV.value = !ButtonV.value },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (ButtonV.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (ButtonV.value) 10.dp else 0.dp),
                enabled = !ButtonF.value && !ColorIncorrect.value && !ColorCorrect.value
            ) {
                forTitleorBtn(textForTitle = "Verdadero")
            }
            Button(
                onClick = { ButtonF.value = !ButtonF.value },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (ButtonF.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (ButtonF.value) 10.dp else 0.dp),
                enabled = !ButtonV.value && !ColorCorrect.value && !ColorIncorrect.value
            ) {
                forTitleorBtn(textForTitle = "Falso")
            }
        }
    }
}