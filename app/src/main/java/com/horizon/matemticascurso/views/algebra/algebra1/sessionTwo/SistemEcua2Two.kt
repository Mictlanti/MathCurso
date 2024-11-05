@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.sessionTwo

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.material3.Divider
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
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.algebra.algebra1.sessionThree.listError
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.OutlinedText
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forTitleorBtn
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SistemEcua2TwoScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 8 })
    val showExample = remember { mutableStateOf(false) }
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "sistema ecuaciones 2 sesion2", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Sistema de ecuaciones",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseSistemEcua2Two1(modifier, pagerState, topicVM, scope, userStateVM)
                1 -> LazyExerciseSistemEcua2Two2(modifier, pagerState, topicVM, scope, userStateVM)
                2 -> LazyExerciseSistemEcua2Two3(modifier, pagerState, topicVM, scope, userStateVM)
                3 -> LazyExerciseSistemEcua2Two4(modifier, pagerState, topicVM, scope, userStateVM)
                4 -> LazyExerciseSistemEcua2Two5(modifier, pagerState, topicVM, scope, userStateVM)
                5 -> LazyExerciseSistemEcua2Two6(modifier, pagerState, topicVM, scope, userStateVM)
                6 -> LazyExerciseSistemEcua2Two7(modifier, pagerState, topicVM, scope, userStateVM)
                7 -> LazyExerciseSistemEcua2Two8(modifier, navController, topicVM, userStateVM)
            }
        },
        pagerState,
        repeatBoxes = 8,
        spaceByBoxes = 15.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseSistemEcua2Two1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2Two1(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua2Two1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "-2x + 1" || state.onValueChange == "-2x+1" || state.onValueChange == "- 2x+1") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
            Toast.makeText(context, listError.random(), Toast.LENGTH_LONG).show()
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        forTitleorBtn(textForTitle = stringResource(R.string.contestaCorrec))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuatwo_seven_dark,
            painterL = R.drawable.ejer_sistemecuatwo_seven_light,
            modifier = align
        )
        SpaceH()
        bodyMedium(text = stringResource(id = R.string.Box3C3_three), modifier = Modifier)
        bodyLarge(
            text = "y = ${state.onValueChange}",
            modifier = align
        )
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
fun LazyExerciseSistemEcua2Two2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2Two2(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua2Two2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "1") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
            Toast.makeText(context, listError.random(), Toast.LENGTH_LONG).show()
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        forTitleorBtn(textForTitle = stringResource(R.string.contestaCorrec))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuatwo_seven_dark,
            painterL = R.drawable.ejer_sistemecuatwo_seven_light,
            modifier = align
        )
        bodyLarge(text = "y = -2x + 1", modifier = align)
        SpaceH()
        bodyMedium(text = stringResource(id = R.string.Box3C3_three_one), modifier = Modifier)
        bodyLarge(
            text = "x = ${state.onValueChange}",
            modifier = align
        )
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
fun LazyExerciseSistemEcua2Two3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2Two3(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua2Two3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val listAns = listOf("y = -2x + 1", "Sustituyendo en 2", "5x + 3(-2x + 1) = 2", "x = 1")
    fun scroll() {
        if (state.onValueChange == "1, -1" || state.onValueChange == "1,-1") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
            Toast.makeText(context, listError.random(), Toast.LENGTH_LONG).show()
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        forTitleorBtn(textForTitle = stringResource(R.string.contestaCorrec))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuatwo_seven_dark,
            painterL = R.drawable.ejer_sistemecuatwo_seven_light,
            modifier = align
        )
        listAns.forEach { s ->
            bodyLarge(text = s, modifier = align)
        }
        SpaceH()
        bodyMedium(
            text = stringResource(id = R.string.Box3C3_three_two) + "\nFinalmente, expresa el conjunto solución",
            modifier = Modifier
        )
        bodyLarge(text = "(x,y) = (${state.onValueChange})", modifier = Modifier)
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
fun LazyExerciseSistemEcua2Two4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2Two4(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua2Two4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listOne = listOf("(x,y)=(-1,-3)", "(x,y)=(1,3)")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_ten_dark,
            painterL = R.drawable.ejer_sistemecuaone_ten_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
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
fun LazyExerciseSistemEcua2Two5(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2Two5(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua2Two5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listOne = listOf("Verdadero", "Falso")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.VoF), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuatwo_two_one_dark,
            painterL = R.drawable.ejer_sistemecuatwo_two_one_light,
            modifier = Modifier
        )
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 1,
                    modifier = recycleModi
                        .weight(1f),
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
fun LazyExerciseSistemEcua2Two6(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2Two6(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua2Two6(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswer = listOf("5x-3y=7", "5x+20y=30")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box6C3_two), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box6C3_four_one), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuatwo_eight_dark,
            painterL = R.drawable.ejer_sistemecuatwo_eight_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        bodyMedium(text = stringResource(id = R.string.Box6C3_four_one_one), modifier = Modifier)
        HorizontalDivider()
        SpaceH()
        Row(modifier = modifier) {
            listAnswer.forEachIndexed { index, s ->
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
fun LazyExerciseSistemEcua2Two7(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2Two7(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua2Two7(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswer = listOf("y = 1", "y = -1")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box6C3_two), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box6C3_four_two), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuatwo_eight_one_dark,
            painterL = R.drawable.ejer_sistemecuatwo_eight_one_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        bodyMedium(text = stringResource(id = R.string.Box6C3_four_two_one), modifier = Modifier)
        HorizontalDivider()
        SpaceH()
        bodyLarge(
            text = "(5x + 20y) - (5x - 3y) = 30 - 7",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(modifier = modifier) {
            listAnswer.forEachIndexed { index, s ->
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
fun LazyExerciseSistemEcua2Two8(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2Two8(topicVM, navController, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua2Two8(
    topicVM: TopicVM,
    navController: NavController,
    userStateVM: UserStateVM
) {

    val listAnswer = listOf("(x,y) = (2,1)", "(x,y) = (0,1)")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box6C3_two), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box6C3_four_three), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuatwo_eight_dark,
            painterL = R.drawable.ejer_sistemecuatwo_eight_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        bodyMedium(text = stringResource(id = R.string.Box6C3_four_three_one), modifier = Modifier)
        HorizontalDivider()
        SpaceH()
        Row(modifier = modifier) {
            listAnswer.forEachIndexed { index, s ->
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
            destination = AppScreens.sistemaEcua2Three
        )
    }
}

@Composable
fun LazyExerciseSistemEcua2Two81(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2Two81(navController, topicVM) }
    }
}

@Composable
private fun ExerciseSistemEcua2Two81(navController: NavController, topicVM: TopicVM) {

    val listAnswer = listOf("(x,y) = (-2,2)", "(x,y) = (0,-2)")
    val listAnswerTwo = listOf("(x,y) = (2,-3)", "(x,y) = (2,3)")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        titleMedium(text = stringResource(id = R.string.VoF))
        Image(
            painter = painterResource(id = R.drawable.ejer_sistemecuatwo_ten),
            contentDescription = null,
            modifier = align
        )
        Row(modifier = modifier) {
            listAnswer.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row(modifier = modifier) {
            listAnswerTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        btnNextTopic(
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.sistemaEcua2Three
        )
    }
}