@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionTwo

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.alertBtnStyle
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.components.topicsComponents.examplesToExercise.eToMultiPoli
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteLarge
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun multiPoliTwoScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {
    val pagerState = rememberPagerState(pageCount = { 5 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "multiplicacion poli sesion2", analytics = analytics)
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
                0 -> LazyExerciseMultiPoliTwo1(pagerState, modifier, topicVM, scope, userStateVM)
                1 -> LazyExerciseMultiPoliTwo2(pagerState, modifier, topicVM, scope)
                2 -> LazyExerciseMultiPoliTwo3(pagerState, modifier, topicVM, scope)
                3 -> LazyExerciseMultiPoliTwo4(pagerState, modifier, topicVM, scope)
                4 -> LazyExerciseMultiPoliTwo5(modifier, navController, topicVM, userStateVM)
            }
        },
        pagerState,
        repeatBoxes = 5,
        spaceByBoxes = 40.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseMultiPoliTwo1(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliTwo1(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseMultiPoliTwo1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswerOne = listOf(" - 5xy", " + 13xy")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val alignment = Modifier.align(Alignment.CenterHorizontally)
        titleMedium(text = stringResource(id = R.string.desarrollo))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_multipoli_four_dark,
            painterL = R.drawable.ejem_multipoli_four_light,
            modifier = Modifier
        )
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "(3x + 4y)(x + 3y) =", modifier = alignment)
        SpaceH()
        listAnswerOne.forEachIndexed { index, s ->
            ButtonPerson(
                index + 1,
                modifier = recycleModi,
                topicVM
            ) {
                ExponenteLarge(
                    b1 = "3x",
                    b2 = s,
                    b3 = " + 12y",
                    e1 = "2",
                    e2 = "",
                    e3 = "2",
                    modifier = Modifier
                )
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseMultiPoliTwo2(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliTwo2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseMultiPoliTwo2(pagerState: PagerState, topicVM: TopicVM, scope: CoroutineScope) {

    val listAnswerOne = listOf(" + 5xy", " + 3xy")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val alignment = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "(2x - y)(x + 2y) =", modifier = alignment)
        SpaceH()
        listAnswerOne.forEachIndexed { index, s ->
            ButtonPerson(
                index + 1,
                modifier = recycleModi,
                topicVM
            ) {
                ExponenteLarge(
                    b1 = "2x",
                    b2 = s,
                    b3 = " - 2y",
                    e1 = "2",
                    e2 = "",
                    e3 = "2",
                    modifier = Modifier
                )
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseMultiPoliTwo3(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliTwo3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseMultiPoliTwo3(pagerState: PagerState, topicVM: TopicVM, scope: CoroutineScope) {

    val listAnswerOne = listOf("Verdadero", "Falso")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.VoF))
        SpaceH()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = recycleModi
        ) {
            bodyLarge(text = "(x + 2)", modifier = Modifier)
            ExponenteLarge(
                b1 = "(x",
                b2 = " + 2x",
                b3 = " + 2)",
                e1 = "2",
                e2 = "",
                e3 = "",
                modifier = Modifier
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            ExponenteLarge(
                b1 = "= x",
                b2 = " + 2x",
                b3 = " + 2x",
                e1 = "3",
                e2 = "2",
                e3 = "",
                modifier = Modifier
            )
            ExponenteLarge(
                b1 = " + 2x",
                b2 = " + 4x",
                b3 = " + 4",
                e1 = "2",
                e2 = "",
                e3 = "",
                modifier = Modifier
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = recycleModi
        ) {
            ExponenteLarge(
                b1 = "= x",
                b2 = " + 4x",
                b3 = " + 6x",
                e1 = "3",
                e2 = "2",
                e3 = "",
                modifier = Modifier
            )
            bodyLarge(text = " + 4", modifier = Modifier)
        }
        SpaceH()
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
fun LazyExerciseMultiPoliTwo4(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliTwo4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseMultiPoliTwo4(pagerState: PagerState, topicVM: TopicVM, scope: CoroutineScope) {

    val listAnswerOne = listOf(" - 6x", "+ 4x ")
    val secndList = listOf(" + 20x", " - 12x")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        Row(modifier = recycleModi, horizontalArrangement = Arrangement.Center) {
            bodyLarge(text = "(x - 2)", modifier = Modifier)
            ExponenteLarge(
                b1 = "(x",
                b2 = "- 4x",
                b3 = " + 12",
                e1 = "2",
                e2 = "",
                e3 = "",
                modifier = Modifier
            )
            bodyLarge(text = ")", modifier = Modifier)
        }
        listAnswerOne.forEachIndexed { index, s ->
            ButtonPerson(
                index + 1,
                modifier = recycleModi,
                topicVM
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ExponenteLarge(
                        b1 = "x",
                        b2 = s,
                        b3 = secndList[index],
                        e1 = "3",
                        e2 = "2",
                        e3 = "",
                        modifier = Modifier
                    )
                    bodyLarge(text = " - 24", modifier = Modifier)
                }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseMultiPoliTwo5(modifier: Modifier, navController: NavController, topicVM: TopicVM, userStateVM: UserStateVM) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliTwo5(navController, topicVM, userStateVM) }
    }
}

@Composable
private fun ExerciseMultiPoliTwo5(navController: NavController, topicVM: TopicVM, userStateVM: UserStateVM) {

    val listAnswerOne = listOf(R.drawable.btnfour_multipolitwo_f_dark, R.drawable.btnfour_multipolitwo_fal_dark)
    val listDark = listOf(R.drawable.btnfour_multipolitwo_f_light, R.drawable.btnfour_multipolitwo_fal_light)
    val listAnswerTwo = listOf("0", "Ninguna")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        Row(modifier = recycleModi, horizontalArrangement = Arrangement.Center) {
            bodyLarge(text = "(x - 1)", modifier = Modifier)
            ExponenteLarge(
                b1 = "(x",
                b2 = "- 2x",
                b3 = " + y",
                e1 = "3",
                e2 = "",
                e3 = "2",
                modifier = Modifier
            )
            bodyLarge(text = ")", modifier = Modifier)
        }
        listAnswerOne.forEachIndexed { index, s ->
            ButtonPerson(
                index + 1,
                modifier = recycleModi,
                topicVM
            ) { ImageAnimation(
                userStateVM,
                painterD = s,
                painterL = listDark[index],
                modifier = Modifier
            ) }
        }
        Row(modifier = recycleModi) {
            listAnswerTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    bodyLarge(text = s, modifier = Modifier)
                }
            }
        }
        btnNextTopic(
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.multiPoliThree
        )
    }
}