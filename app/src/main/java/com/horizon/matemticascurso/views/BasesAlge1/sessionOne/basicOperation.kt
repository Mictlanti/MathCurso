@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionOne

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.OutlinedText
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.alertBtnStyle
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleLarge
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.components.topicsComponents.examplesToExercise.eToBasicOpeSession1
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.SpaceW
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun basicOperationRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 7 })
    val recycleModi = Modifier.fillMaxSize()
    val showExample = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "basic operation session 1", analytics = analytics)
    alertBtnStyle(
        PartiallyExpanded = true,
        showExample = showExample.value,
        onDismissRequest = { showExample.value = false },
        content = { eToBasicOpeSession1() }
    )

    TopBarTopics(
        navController = navController,
        titleTopBar = "Operaciones básicas",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseBasicOpeOne1(
                    modifier = recycleModi,
                    pagerState,
                    topicVM,
                    scope
                )

                1 -> LazyExerciseBasicOpeOne2(
                    modifier = recycleModi,
                    pagerState,
                    topicVM,
                    scope
                )

                2 -> LazyExerciseBasicOpeOne3(
                    modifier = recycleModi,
                    pagerState,
                    topicVM,
                    scope
                )

                3 -> LazyExerciseBasicOpeOne4(
                    modifier = recycleModi,
                    pagerState,
                    topicVM,
                    scope,
                    userStateVM
                )

                4 -> LazyExerciseBasicOpeOne5(
                    modifier = recycleModi,
                    pagerState,
                    topicVM,
                    scope
                )

                5 -> LazyExerciseBasicOpe6(
                    modifier = recycleModi,
                    pagerState,
                    topicVM,
                    scope,
                    userStateVM
                )

                6 -> LazyExerciseBasicOpe7(
                    modifier = recycleModi,
                    navController,
                    topicVM,
                    userStateVM
                )
            }
        },
        pagerState = pagerState,
        repeatBoxes = 7,
        spaceByBoxes = 20.dp,
        showExample = { showExample.value = true }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyExerciseBasicOpeOne1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseBasicOpeOne1(pagerState, topicVM, scope) }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExerciseBasicOpeOne1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val state by topicVM.state.collectAsState()
    fun action() {
        if (
            state.onValueChange == "5"
            && state.onValueChangeTwo == "10t"
            || state.onValueChangeTwo == "10 t"
        ) {
            topicVM.animatedScroll(scope, pagerState, true)
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        titleMedium(text = stringResource(id = R.string.desarrollo))
        bodyLarge(text = "5m + 2m = 7m", modifier = align)
        bodyLarge(text = "9a + a = 10a", modifier = align)
        titleLarge(text = stringResource(id = R.string.sumaMono))
        bodyMedium(text = stringResource(id = R.string.sumaMono_one), modifier = align)
        ExerciseBasicOpe1(
            stateOne = state.onValueChange,
            onValueOne = { topicVM.onValueChangeOne(onValue = it) },
            stateTwo = state.onValueChangeTwo,
            onValueTwo = { topicVM.onValueChangeTwo(onValue = it) },
            onClick = { action() },
            topicVM
        )
        Row {
            titleLarge(text = stringResource(id = R.string.note))
            Column {
                bodyLarge(text = "y, a", modifier = align)
                bodyMedium(text = stringResource(id = R.string.sumaMono_two), modifier = align)
                bodyLarge(text = "1(y), 1(a)", modifier = align)
                bodyMedium(text = stringResource(id = R.string.sumaMono_three), modifier = align)
                bodyLarge(text = "y, a", modifier = align)
            }
        }
    }
}

@Composable
fun ExerciseBasicOpe1(
    stateOne: String,
    onValueOne: (String) -> Unit,
    stateTwo: String,
    onValueTwo: (String) -> Unit,
    onClick: () -> Unit,
    topicVM: TopicVM
) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        bodyLarge(text = stringResource(id = R.string.resuelve), modifier = Modifier)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bodyLarge(text = "A) 2a + 3a = ", modifier = Modifier)
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedText(
                value = stateOne,
                onValueChange = onValueOne,
                placeholder = { Text(text = "Ej. 2") }
            )
            bodyLarge(text = "a", modifier = Modifier)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bodyLarge(text = "B) 4t + 6t = ", modifier = Modifier)
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedTextString(
                value = stateTwo,
                onValueChange = onValueTwo,
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
        }
        BtnCheck(onClick = onClick, topicVM)
    }
}

@Composable
fun LazyExerciseBasicOpeOne2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseBasicOpeOne2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseBasicOpeOne2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    val listBtn = listOf("4x + y", "4xy")
    val recycleModi = Modifier
        .fillMaxWidth()
        .padding(top = 30.dp, bottom = 5.dp)

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.resuelve), modifier = Modifier)
        Spacer(modifier = Modifier.height(20.dp))
        bodyLarge(text = "4x + y = ", modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            listBtn.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { topicVM.checkInt(scope, pagerState, indexCorrect = 1) }, topicVM)
    }
}

@Composable
fun LazyExerciseBasicOpeOne3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExcersiceBasicOpeOne3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExcersiceBasicOpeOne3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "5x" && state.onValueChangeTwo == "0") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        titleLarge(text = stringResource(id = R.string.sumaMono))
        Spacer(modifier = Modifier.height(10.dp))
        titleMedium(text = stringResource(id = R.string.desarrollo))
        bodyLarge(
            text = "5m - 2m = 5m + (-2m) = 3m",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        bodyMedium(text = stringResource(id = R.string.sumaMono_three_one), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        bodyLarge(text = stringResource(id = R.string.resuelve), modifier = Modifier)
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            bodyLarge(text = "A) 5x - 0 = ", modifier = Modifier)
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedTextString(
                value = state.onValueChange,
                onValueChange = { topicVM.onValueChangeOne(onValue = it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            bodyLarge(text = "B) -y + y =", modifier = Modifier)
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedText(
                value = state.onValueChangeTwo,
                onValueChange = { topicVM.onValueChangeTwo(onValue = it) },
                placeholder = null
            )
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseBasicOpeOne4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseBasicOpeOne4(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseBasicOpeOne4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val image1 = R.drawable.operation_basic_one_f_light
    val image2 = R.drawable.operation_basic_one_v_light
    val listBtn = listOf(image1, image2)
    val listDark =
        listOf(R.drawable.operation_basic_one_f_dark, R.drawable.operation_basic_one_v_dark)
    val recycleModi = Modifier
        .fillMaxWidth()
        .padding(top = 30.dp, bottom = 5.dp)

    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.resuelve), modifier = Modifier)
        Spacer(modifier = Modifier.height(20.dp))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.operation_basic_one_light,
            painterL = R.drawable.operation_basic_one_dark,
            modifier = Modifier
                .size(width = 190.dp, height = 65.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            listBtn.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    ImageAnimation(
                        userStateVM,
                        painterD = s,
                        painterL = listDark[index],
                        modifier = Modifier
                    )
                }
            }
        }
        BtnCheck(onClick = { check() }, topicVM)
    }
}

@Composable
fun LazyExerciseBasicOpeOne5(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseBasicOpeOne5(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseBasicOpeOne5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val state by topicVM.state.collectAsState()
    val fillWidth = Modifier.fillMaxWidth()
    fun scroll() {
        if (state.onValueChange == "7x" && state.onValueChangeTwo == "5a") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        titleLarge(text = stringResource(id = R.string.sumaMono))
        Spacer(modifier = Modifier.height(10.dp))
        bodyLarge(text = stringResource(id = R.string.resuelve), modifier = Modifier)
        Row(
            modifier = fillWidth,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            bodyLarge(text = "B) 5a - 2a + 3a - a = ", modifier = Modifier)
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedTextString(
                value = state.onValueChange,
                onValueChange = { topicVM.onValueChangeOne(onValue = it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
private fun LazyExerciseBasicOpe6(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseBasicOpe6(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseBasicOpe6(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val state by topicVM.state.collectAsState()
    val fillMaxWidth = Modifier.fillMaxWidth()
    fun scroll() {
        if (state.onValueChange == "-x-2" || state.onValueChangeTwo == "-x - 2" && state.onValueChangeThree == "-4y") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        bodyLarge(text = stringResource(id = R.string.resuelve), modifier = Modifier)
        Row(
            modifier = fillMaxWidth,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageAnimation(
                userStateVM,
                painterD = R.drawable.basic_operation_two_dark,
                painterL = R.drawable.basic_operation_two_light,
                modifier = Modifier.size(width = 210.dp, height = 70.dp)
            )
            SpaceW(size = 10.dp)
            OutlinedTextString(
                value = state.onValueChange,
                onValueChange = { topicVM.onValueChangeOne(onValue = it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
        }
        Row(
            modifier = fillMaxWidth,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageAnimation(
                userStateVM,
                painterD = R.drawable.basic_operation_four_dark,
                painterL = R.drawable.basic_operation_four_light,
                modifier = Modifier.size(width = 210.dp, height = 70.dp)
            )
            SpaceW(size = 10.dp)
            OutlinedTextString(
                value = state.onValueChangeTwo,
                onValueChange = { topicVM.onValueChangeTwo(onValue = it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseBasicOpe7(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseBasicOpe7(navController, topicVM, userStateVM) }
    }
}

@Composable
private fun ExerciseBasicOpe7(
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val listBtn = listOf("Verdadero", "Falso")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkFinishInt(1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Spacer(modifier = Modifier.height(20.dp))
        titleMedium(text = stringResource(id = R.string.VoF))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.basic_operation_five_dark,
            painterL = R.drawable.basic_operation_five_light,
            modifier = Modifier
        )
        Row(modifier = recycleModi) {
            listBtn.forEachIndexed { index, s ->
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
            destination = AppScreens.basicOperationTwo
        )
    }
}