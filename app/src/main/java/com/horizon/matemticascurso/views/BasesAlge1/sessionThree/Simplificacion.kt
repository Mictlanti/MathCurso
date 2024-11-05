@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionThree

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.btnExample
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forBodyorExercise
import com.horizon.matemticascurso.views.components.forTitleorBtn
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun simplificacionScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val modifier: Modifier = Modifier.fillMaxSize()
    val showExample = remember { mutableStateOf(false) }
    val pagerState = rememberPagerState(pageCount = { 8 })
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "simplificacion session 3", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Operaciones básicas",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> ExampleSimpliOne(modifier, pagerState, nextPage, scope, userStateVM)
                1 -> ExcerciseSimpleOne(pagerState, modifier, topicVM, scope)
                2 -> ExcerciseSimpliTwo(modifier, pagerState, topicVM, scope)
                3 -> ExcersiceSimpliThree(modifier, pagerState, topicVM, scope, userStateVM)
                4 -> ExcersiceSimpliFour(modifier, pagerState, topicVM, scope)
                5 -> ExcersiceSimpliFive(modifier, pagerState, topicVM, scope)
                6 -> ExcersiceSimpliSix(modifier, pagerState, topicVM, scope, userStateVM)
                7 -> ExcersiceSimpliSeven(navController, modifier, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 8,
        spaceByBoxes = 15.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
private fun ExampleSimpliOne(
    modifier: Modifier,
    pagerState: PagerState,
    nextPage: Int,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { BoxSimpli1(pagerState, nextPage, scope, userStateVM) }
    }
}

@Composable
private fun BoxSimpli1(
    pagerState: PagerState,
    nextPage: Int,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    titleMedium(text = stringResource(id = R.string.desarrollo))
    SpaceH()
    ImageAnimation(
        userStateVM,
        painterD = R.drawable.ejem_simpli_one_dark,
        painterL = R.drawable.ejem_simpli_one_light,
        modifier = Modifier
    )
    SpaceH()
    forBodyorExercise(body = stringResource(id = R.string.ScreenLazy_two))
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ExcerciseSimpleOne(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            BoxSimpli2(pagerState, topicVM, scope)
        }
    }
}

@Composable
private fun BoxSimpli2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("7x + y", "x - 7y")
    val listAnswerTwo = listOf("7x - y", "x + y")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(25.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2_one), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "(2x - 3y) + (5x + 2y) = ", modifier = align)
        SpaceH()
        Row(modifier = Modifier.fillMaxWidth()) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            listAnswerTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
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
private fun ExcerciseSimpliTwo(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { BoxSimpli3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun BoxSimpli3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("a + 4b", "2a - b")
    val listAnswerTwo = listOf("a - b", "0")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 3)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2_one), modifier = Modifier)
        SpaceH()
        bodyLarge(
            text = "(2a + 3b) - (2a + 3b) = ",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        Row {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row {
            listAnswerTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
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
private fun ExcersiceSimpliThree(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { BoxSimpli4(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun BoxSimpli4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswerOne = listOf("Veradero", "Falso")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text(text = buildAnnotatedString {
            withStyle(
                SpanStyle(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            ) { append(stringResource(id = R.string.Box3_one)) }
            withStyle(
                SpanStyle(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 18.sp
                )
            ) { append(stringResource(id = R.string.Box3_two)) }
        })
        titleMedium(text = stringResource(id = R.string.Box3_three))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_simpli_two_dark,
            painterL = R.drawable.ejer_simpli_two_light,
            modifier = Modifier
        )
        Row {
            listAnswerOne.forEachIndexed { index, s ->
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
private fun ExcersiceSimpliFour(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { BoxSimpli5(pagerState, topicVM, scope) }
    }
}

@Composable
private fun BoxSimpli5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("2(7a - 2)", "a - 2")
    val listAnswerTwo = listOf("3a - 1", "7(a + 1)")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        forTitleorBtn(textForTitle = stringResource(id = R.string.Box4_one))
        Spacer(modifier = Modifier.height(30.dp))
        bodyLarge(
            text = "(5a - 6) + (9a + 2) =",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row {
            listAnswerTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
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
private fun ExcersiceSimpliFive(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { BoxSimpli6(pagerState, topicVM, scope) }
    }
}

@Composable
private fun BoxSimpli6(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("2(2x + 3z)", "4(2x + z)")
    val listAnswerTwo = listOf("2(x + z)", "4x + z")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box4_one), modifier = Modifier)
        Spacer(modifier = Modifier.height(40.dp))
        bodyLarge(
            text = "(4x - 6y + z) - (-4x - 6y - 3z) = ",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(modifier = recycleModi) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row(modifier = recycleModi) {
            listAnswerTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
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
private fun ExcersiceSimpliSix(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { BoxSimpli7(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun BoxSimpli7(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswerOne =
        listOf(R.drawable.res_simpli_four_two_dark, R.drawable.res_simpli_four_one_dark)
    val listOneLight =
        listOf(R.drawable.res_simpli_four_two_light, R.drawable.res_simpli_four_one_light)
    val listAnswerTwo =
        listOf(R.drawable.res_simpli_three_three_dark, R.drawable.res_simpli_three_four_dark)
    val listTwolight =
        listOf(R.drawable.res_simpli_three_three_light, R.drawable.res_simpli_three_four_light)
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box5_two), modifier = Modifier)
        Spacer(modifier = Modifier.height(30.dp))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_simpli_four_dark,
            painterL = R.drawable.ejer_simpli_four_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(60.dp))
        Row(modifier = recycleModi) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    ImageAnimation(
                        userStateVM,
                        painterD = s,
                        painterL = listOneLight[index],
                        modifier = Modifier
                    )
                }
            }
        }
        Row(modifier = recycleModi) {
            listAnswerTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    ImageAnimation(
                        userStateVM,
                        painterD = s,
                        painterL = listTwolight[index],
                        modifier = Modifier
                    )
                }
            }
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
private fun ExcersiceSimpliSeven(
    navController: NavController,
    modifier: Modifier,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { BoxSimpli8(navController, topicVM) }
    }
}

@Composable
private fun BoxSimpli8(
    navController: NavController,
    topicVM: TopicVM
) {

    val listOne = listOf("x = 2", "x = 0")
    val listTwo = listOf("x = 4", "x = 6")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(3)
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box5_two), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        bodyLarge(text = "2x + 10 -3x + 3 = 4x - 7", modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    bodyLarge(text = s, modifier = Modifier)
                }
            }
        }
        Row(modifier = recycleModi) {
            listTwo.forEachIndexed { index, s ->
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
            destination = AppScreens.transformEcua
        )
    }
}