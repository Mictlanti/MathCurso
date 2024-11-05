@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.sessionThree

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
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.By
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.OutlinedText
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LeyExpoThreeScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 4 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "ley exponentes sesion3", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Ley de exponentes",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseLeyExpoThree1(modifier, pagerState, topicVM, scope, userStateVM)
                1 -> LazyExerciseLeyExpoThree2(modifier, pagerState, topicVM, scope)
                2 -> LazyExerciseLeyExpoThree3(modifier, pagerState, topicVM, scope, userStateVM)
                3 -> LazyExerciseLeyExpoThree4(modifier, topicVM, navController, userStateVM)
            }
        },
        pagerState,
        repeatBoxes = 4,
        spaceByBoxes = 50.dp,
        showExample = { showExample.value = true },
        widthBoxes = 30.dp
    )
}

@Composable
fun LazyExerciseLeyExpoThree1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoThree1(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseLeyExpoThree1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listOne = listOf("13", "11")
    val listTwo = listOf("a", "0")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_leyexpo_seventeen_dark,
            painterL = R.drawable.ejer_leyexpo_seventeen_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { Exponente(base = "a", exponente = s, modifier = Modifier) }
            }
        }
        Row(modifier = recycleModi) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = when (index) {
                        0 -> recycleModi.weight(1f)
                        1 -> recycleModi.weight(2f)
                        else -> recycleModi
                    },
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseLeyExpoThree2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoThree2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseLeyExpoThree2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("-2", "6")
    val listAns = listOf("-3", "-4", "5")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = recycleModi,
            verticalAlignment = Alignment.CenterVertically
        ) {
            listAns.forEachIndexed { index, s ->
                Exponente(base = "a", exponente = s, modifier = Modifier)
                if (index == 2) bodyLarge(text = " = ", modifier = Modifier) else By()
            }
        }
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    Exponente(base = "a", exponente = s, modifier = Modifier)
                }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseLeyExpoThree3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoThree3(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseLeyExpoThree3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listOne = listOf("0", "ninguna")
    val listTwo = listOf("10", "9")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_leyexpo_eighteen_dark,
            painterL = R.drawable.ejer_leyexpo_eighteen_light,
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
        Row(modifier = recycleModi) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    Exponente(base = "a", exponente = s, modifier = Modifier)
                }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseLeyExpoThree4(
    modifier: Modifier,
    topicVM: TopicVM,
    navController: NavController,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoThree4(topicVM, navController, userStateVM) }
    }
}

@Composable
private fun ExerciseLeyExpoThree4(
    topicVM: TopicVM,
    navController: NavController,
    userStateVM: UserStateVM
) {

    val listOne = listOf("Verdadero", "Falso")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkFinishInt(1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.VoF))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_leyexpo_twenty_dark,
            painterL = R.drawable.ejer_leyexpo_twenty_light,
            modifier = Modifier
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
            onClick = { check() },
            topicVM,
            navController,
            destination = AppScreens.producNotaOne
        )
    }
}

@Composable
fun LazyExerciseLeyExpoThree5(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseLeyExpoThree5(
                navController,
                topicVM
            )
        }
    }
}

@Composable
fun ExerciseLeyExpoThree5(
    navController: NavController,
    topicVM: TopicVM,
    context: Context = LocalContext.current
) {

    val listOne = listOf(
        painterResource(id = R.drawable.ejer_leyexpo_twentyone),
        painterResource(id = R.drawable.ejer_leyexpo_twentytwo)
    )
    val state by topicVM.state.collectAsState()
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        if (state.onValueChange == "1" && state.onValueChangeTwo == "-4") {
            topicVM.checkFinishString(true)
        } else if (state.onValueChange.isEmpty() || state.onValueChangeTwo.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.checkFinishString(false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.desarrollo))
        Image(
            painter = painterResource(id = R.drawable.ejem_leyexpo_seven),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        listOne.forEachIndexed { index, painter ->
            Row(modifier = recycleModi, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Image(painter = painter, contentDescription = null)
                when (index) {
                    0 -> OutlinedText(
                        value = state.onValueChange,
                        onValueChange = { topicVM.onValueChangeOne(it) },
                        placeholder = null
                    )

                    1 -> OutlinedTextString(
                        value = state.onValueChangeTwo,
                        onValueChange = { topicVM.onValueChangeTwo(it) },
                        keyboardType = KeyboardType.Text,
                        placeholder = null
                    )
                }
            }
        }
        btnNextTopic(
            onClick = { check() },
            topicVM,
            navController,
            destination = AppScreens.producNotaOne
        )
    }
}