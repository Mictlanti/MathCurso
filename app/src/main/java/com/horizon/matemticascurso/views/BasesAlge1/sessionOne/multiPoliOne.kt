@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionOne

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.width
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
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.alertBtnStyle
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.btnExample
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forBodyorExercise
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.components.topicsComponents.examplesToExercise.eToMultiPoli
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun multiPoliOneScreenRoute(
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

    analyticsTrackScreen(name = "mutiplicación polinomios Sesion1", analytics = analytics)
    alertBtnStyle(
        PartiallyExpanded = true,
        showExample = showExample.value,
        onDismissRequest = { showExample.value = false },
        content = { eToMultiPoli() }
    )

    TopBarTopics(
        navController,
        titleTopBar = "Polinomios",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExampleMultiPoliOne1(modifier, pagerState, nextPage)
                1 -> LazyExerciseMultiPoliOne1(
                    pagerState,
                    modifier,
                    topicVM,
                    scope,userStateVM
                )

                2 -> LazyExerciseMultiPoliOne2(
                    pagerState,
                    modifier,
                    topicVM,
                    scope
                )

                3 -> LazyExerciseMultiPoliOne3(
                    pagerState, modifier,
                    topicVM,
                    scope
                )

                4 -> LazyExerciseMultiPoliOne4(
                    pagerState, modifier,
                    topicVM,
                    scope
                )

                5 -> LazyExerciseMultiPoliOne5(
                    pagerState, modifier,
                    topicVM,
                    scope
                )

                6 -> LazyExerciseMultiPoliOne6(
                    pagerState, modifier,
                    topicVM,
                    scope,
                    userStateVM
                )

                7 -> LazyExerciseMultiPoliOne7(
                    navController = navController,
                    modifier,
                    topicVM,
                    userStateVM
                )
            }
        },
        pagerState,
        repeatBoxes = 8,
        spaceByBoxes = 15.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExampleMultiPoliOne1(modifier: Modifier, pagerState: PagerState, nextPage: Int) {
    LazyColumn(modifier = modifier) {
        item { ExampleMultiPoliOne1(pagerState, nextPage) }
    }
}

@Composable
private fun ExampleMultiPoliOne1(pagerState: PagerState, nextPage: Int) {
    val baseOne = listOf("4x", ", -3x", ", 10x")
    val expoOne = listOf("3", "2", "0")
    val scope = rememberCoroutineScope()
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val fillMaxW = Modifier.fillMaxWidth()
        forBodyorExercise(body = stringResource(id = R.string.Box1A4_one))
        Row(
            modifier = fillMaxW,
            horizontalArrangement = Arrangement.Center
        ) {
            baseOne.forEachIndexed { index, s ->
                Exponente(base = s, exponente = expoOne[index], modifier = Modifier)
            }
        }
        forBodyorExercise(body = stringResource(id = R.string.Box1A4_two))
        Row(
            modifier = fillMaxW,
            horizontalArrangement = Arrangement.Center
        ) {
            val baselist = listOf("4x", "-x", "y")
            val expoList = listOf("3", "2", "")
            baselist.forEachIndexed { index, s ->
                Exponente(base = s, exponente = expoList[index], modifier = Modifier)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        forBodyorExercise(body = stringResource(id = R.string.Box1A4_three))
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
fun LazyExerciseMultiPoliOne1(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliOne1(pagerState, topicVM, scope, userStateVM) }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ExerciseMultiPoliOne1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val state by topicVM.state.collectAsState()
    val recycleModi = Modifier.fillMaxWidth()
    val context = LocalContext.current
    fun scroll() {
        if (state.onValueChange == "bx - by" || state.onValueChange == "bx-by") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty() || state.onValueChangeTwo.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val alignment = Modifier.align(Alignment.CenterHorizontally)
        titleMedium(text = stringResource(id = R.string.desarrollo))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_multipoli_three_dark,
            painterL = R.drawable.ejem_multipoli_three_light,
            modifier = Modifier
        )
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        bodyLarge(text = "(a + b)(x - y) =", modifier = alignment)
        SpaceH()
        Row(
            modifier = recycleModi,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            bodyLarge(text = "(a + b)(x - y) =", modifier = alignment)
            bodyLarge(text = "ax - ay + ", modifier = Modifier)
            bodyLarge(text = state.onValueChange, modifier = Modifier)
        }
        SpaceH()
        OutlinedTextString(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(onValue = it) },
            keyboardType = KeyboardType.Text,
            placeholder = null
        )
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseMultiPoliOne2(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliOne2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseMultiPoliOne2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val state by topicVM.state.collectAsState()
    val recycleModi = Modifier.fillMaxWidth()
    val context = LocalContext.current
    fun scroll() {
        if (state.onValueChange == "ac" && state.onValueChangeTwo == "ad") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty() || state.onValueChangeTwo.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val alignment = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "(a + b)(c + d) = ", modifier = alignment)
        SpaceH()
        Row(
            modifier = recycleModi,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedTextString(
                value = state.onValueChange,
                onValueChange = { topicVM.onValueChangeOne(onValue = it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
            bodyLarge(text = " + ", modifier = Modifier)
            OutlinedTextString(
                value = state.onValueChangeTwo,
                onValueChange = { topicVM.onValueChangeTwo(onValue = it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
            Spacer(modifier = Modifier.width(5.dp))
            bodyLarge(text = "+ bc + bd", modifier = Modifier)
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseMultiPoliOne3(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliOne3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseMultiPoliOne3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("2ac + 4ad + bc + 2bd ", "2ac + 2ad + bc + bd")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val alignment = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        bodyLarge(text = "(2a + b)(c + 2d) = ", modifier = alignment)
        Box(modifier = recycleModi) {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                listAnswerOne.forEachIndexed { index, s ->
                    ButtonPerson(
                        index + 1,
                        modifier = recycleModi,
                        topicVM
                    ) { bodyLarge(text = s, modifier = Modifier) }
                }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseMultiPoliOne4(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliOne4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseMultiPoliOne4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("25ax - 5xb - 5ay + by", "5ax + 5by - 5ay + by")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val alignment = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        bodyLarge(text = "(5x - y)(5a - b) = ", modifier = alignment)
        Box(modifier = recycleModi) {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                listAnswerOne.forEachIndexed { index, s ->
                    ButtonPerson(
                        index + 1,
                        modifier = Modifier,
                        topicVM
                    ) { bodyLarge(text = s, modifier = Modifier) }
                }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseMultiPoliOne5(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliOne5(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseMultiPoliOne5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("ab-b-b+1", "ab-a-b+1")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val alignment = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        SpaceH(size = 10.dp)
        bodyLarge(text = "(b - 1)(a - 1) = ", modifier = alignment)
        SpaceH(size = 10.dp)
        Row(modifier = recycleModi) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseMultiPoliOne6(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliOne6(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseMultiPoliOne6(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswerOne = listOf(" + ax + xy + ay", " + ax - xy - ay")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.desarrollo))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_multipoli_four_dark,
            painterL = R.drawable.ejem_multipoli_four_light,
            modifier = Modifier
        )
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        bodyLarge(
            text = "(x - y)(x + a) = ",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        listAnswerOne.forEachIndexed { index, s ->
            ButtonPerson(
                index + 1,
                modifier = recycleModi,
                topicVM
            ) {
                Exponente(base = "x", exponente = "2", modifier = Modifier)
                bodyLarge(text = s, modifier = Modifier)
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseMultiPoliOne7(
    navController: NavController,
    modifier: Modifier,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliOne7(navController, topicVM, userStateVM) }
    }
}

@Composable
private fun ExerciseMultiPoliOne7(
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val listAnswerOne = listOf("ab - ax - bx + x", "x")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.desarrollo))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_multipoli_four_dark,
            painterL = R.drawable.ejem_multipoli_four_light,
            modifier = Modifier
        )
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        bodyLarge(
            text = "(a - x)(b - x) = ",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        listAnswerOne.forEachIndexed { index, s ->
            ButtonPerson(
                index + 1,
                modifier = recycleModi,
                topicVM
            ) {
                Exponente(base = s, exponente = "2", modifier = Modifier)
                if(index == 1) bodyLarge(text = " + ax - bx - ab", modifier = Modifier)
            }
        }
        btnNextTopic(
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.multiPoliTwo
        )
    }
}
