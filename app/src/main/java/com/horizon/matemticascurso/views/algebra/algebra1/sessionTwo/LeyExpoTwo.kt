@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.sessionTwo

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
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.CardExample
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.SignDivi
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forTitleorBtn
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope

@Composable
fun LeyExpoTwoScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 6 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "ley de exponentes sesion2", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Ley de exponentes",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseLeyExpoTwo1(pagerState, modifier, topicVM, scope)
                1 -> LazyExerciseLeyExpoTwo2(pagerState, modifier, topicVM, scope)
                2 -> LazyExerciseLeyExpoTwo3(pagerState, modifier, topicVM, scope)
                3 -> LazyExerciseLeyExpoTwo4(pagerState, modifier, topicVM, scope, userStateVM)
                4 -> LazyExerciseLeyExpoTwo5(pagerState, modifier, topicVM, scope, userStateVM)
                5 -> LazyExerciseLeyExpoTwo6(modifier, navController, topicVM, userStateVM)
            }
        },
        pagerState,
        repeatBoxes = 6,
        spaceByBoxes = 35.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseLeyExpoTwo1(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoTwo1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseLeyExpoTwo1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("10", "0")
    val listTwo = listOf("1", "ninguna")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 3)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        CardExample(
            titleRes = R.string.Box3A3_one,
            bodyRes = R.string.Box3A3_two,
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = recycleModi
            ) {
                Exponente(base = "a", exponente = "0", modifier = Modifier)
                bodyLarge(text = " = 1", modifier = Modifier)
            }
        }
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        Exponente(base = "10", exponente = "0", modifier = Modifier.align(Alignment.CenterHorizontally))
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
                    modifier = when (index) {
                        0 -> recycleModi.weight(1f)
                        1 -> recycleModi.weight(2f)
                        else -> recycleModi.weight(1f)
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
fun LazyExerciseLeyExpoTwo2(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoTwo2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseLeyExpoTwo2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("1", "x")
    val listTwo = listOf("0", "ninguna")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = recycleModi
        ) {
            Exponente(base = "(x", exponente = "0", modifier = Modifier)
            bodyLarge(text = ")x = ", modifier = Modifier)
        }
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
fun LazyExerciseLeyExpoTwo3(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoTwo3(pagerState,topicVM, scope) }
    }
}

@Composable
private fun ExerciseLeyExpoTwo3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("s", "1")
    val listTwo = listOf("-1", "ninguna")
    val listAns = listOf("0", "-1")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = recycleModi
        ) {
            listAns.forEachIndexed { index, s ->
                Exponente(base = "s", exponente = s, modifier = Modifier)
                if(index == 0) SignDivi() else bodyLarge(text = " = ", modifier = Modifier)
            }
        }
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
fun LazyExerciseLeyExpoTwo4(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoTwo4(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseLeyExpoTwo4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listOne = listOf("5", "-1")
    val listAns = listOf("2", "-3")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        CardExample(titleRes = R.string.Box4A3_one, bodyRes = R.string.Box4A3_two) {
            ImageAnimation(
                userStateVM,
                painterD = R.drawable.ejem_leyexpo_six_dark,
                painterL = R.drawable.ejem_leyexpo_six_light,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        forTitleorBtn(textForTitle = stringResource(id = R.string.Box2A3_one))
        SpaceH()
        Row(modifier = recycleModi, horizontalArrangement = Arrangement.Center) {
            listAns.forEachIndexed { index, s ->
                Exponente(base = "2", exponente = s, modifier = Modifier)
                if(index == 0) SignDivi() else bodyLarge(text = " = ", modifier = Modifier)
            }
        }
        SpaceH()
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    Exponente(base = "2", exponente = s, modifier = Modifier)
                }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseLeyExpoTwo5(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoTwo5(pagerState,topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseLeyExpoTwo5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listOne = listOf(R.drawable.btnfiveteen_leyexpo_f_dark, R.drawable.btnfiveteen_leyexpo_v_dark)
    val listLight = listOf(R.drawable.btnfiveteen_leyexpo_f_light, R.drawable.btnfiveteen_leyexpo_v_light)
    val listTwo = listOf("-1", "ninguna")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = recycleModi
        ) {
            Exponente(base = "t", exponente = "-2", modifier = Modifier)
            bodyLarge(text = " = ", modifier = Modifier)
        }
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    ImageAnimation(
                        userStateVM,
                        painterD = s,
                        painterL = listLight[index],
                        modifier = Modifier
                    )
                }
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
fun LazyExerciseLeyExpoTwo6(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoTwo6(navController, topicVM, userStateVM) }
    }
}

@Composable
private fun ExerciseLeyExpoTwo6(navController: NavController, topicVM: TopicVM, userStateVM: UserStateVM) {

    val listOne = listOf("2", "-2")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkFinishInt(1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        SpaceH()
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.btnfiveteen_leyexpo_f_dark,
            painterL = R.drawable.btnfiveteen_leyexpo_f_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = when (index) {
                        0 -> recycleModi.weight(1f)
                        1 -> recycleModi.weight(1f)
                        else -> recycleModi
                    },
                    topicVM
                ) {
                    Exponente(base = "t", exponente = s, modifier = Modifier)
                }
            }
        }
        btnNextTopic(
            onClick = { check() },
            topicVM,
            navController,
            destination = AppScreens.leyExpoThree
        )
    }
}