@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionThree

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.examplesToExercise.eToMultiPoli
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteLarge
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.views.components.alertBtnStyle
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun multiPoliThreeScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 5 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "multiplicacion poli session3", analytics = analytics)
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
                0 -> LazyExerciseMultiPoliThree1(modifier, pagerState, topicVM, scope)
                1 -> LazyExerciseMultiPoliThree2(modifier, pagerState, topicVM, scope)
                //2 -> LazyExerciseMultiPoliThree3(modifier, pagerState, topicVM, scope)
                2 -> LazyExerciseMultiPoliThree4(modifier, pagerState, topicVM, scope)
                3 -> LazyExerciseMultiPoliThree5(modifier, pagerState, topicVM, scope, userStateVM)
                4 -> LazyExerciseMultiPoliThree6(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 5,
        spaceByBoxes = 35.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseMultiPoliThree1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliThree1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseMultiPoliThree1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("- 2x", "- x")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        SpaceH()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = recycleModi
        ) {
            bodyLarge(text = "(x - 1)", modifier = Modifier)
            ExponenteLarge(
                b1 = "(x",
                b2 = " - x",
                b3 = " + y",
                e1 = "2",
                e2 = "",
                e3 = "2",
                modifier = Modifier
            )
            bodyLarge(text = ")", modifier = Modifier)
        }
        SpaceH()
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
                        b3 = " + x",
                        e1 = if (index == 0) "3" else "4",
                        e2 = "2",
                        e3 = "",
                        modifier = Modifier
                    )
                    Exponente(
                        base = if (index == 0) " + xy" else " - 2xy",
                        exponente = "2",
                        modifier = Modifier
                    )
                    Exponente(base = " - y", exponente = "2", modifier = Modifier)
                }
            }
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseMultiPoliThree2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliThree2(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseMultiPoliThree2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("6x", "x")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        SpaceH()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = recycleModi
        ) {
            ExponenteLarge(
                b1 = "(2x",
                b2 = " - 3x",
                b3 = " + 5)",
                e1 = "2",
                e2 = "",
                e3 = "",
                modifier = Modifier
            )
            ExponenteLarge(
                b1 = "(3x",
                b2 = " - 2x",
                b3 = " + 1) =",
                e1 = "2",
                e2 = "",
                e3 = "",
                modifier = Modifier
            )
        }
        SpaceH()
        listAnswerOne.forEachIndexed { index, s ->
            ButtonPerson(
                index + 1,
                modifier = recycleModi,
                topicVM
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = recycleModi
                ) {
                    ExponenteLarge(
                        b1 = s,
                        b2 = if (index == 1) " - 13x" else " + 4x",
                        b3 = " + 23x",
                        e1 = "4",
                        e2 = "3",
                        e3 = "2",
                        modifier = Modifier
                    )
                    bodyLarge(text = if (index == 1) " - 13x + 5" else " + 24", modifier = Modifier)
                }
            }
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

/*@Composable
fun LazyExerciseMultiPoliThree3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliThree3(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseMultiPoliThree3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val Button1 = remember { mutableStateOf(false) } //correct
    val Button2 = remember { mutableStateOf(false) } //incorrect
    val btn3 = remember { mutableStateOf(false) } //correct
    val btn4 = remember { mutableStateOf(false) } //incorrect
    val btn5 = remember { mutableStateOf(false) } //incorrect
    val btn6 = remember { mutableStateOf(false) } //correct
    val btn7 = remember { mutableStateOf(false) } //incorrect
    val btn8 = remember { mutableStateOf(false) } //correct
    fun scroll() {
        scope.launch {
            pagerState.animateScrollToPage(
                (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1),
                animationSpec = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                )
            )
        }
    }
    LaunchedEffect(key1 = Button2.value || btn4.value || btn6.value || btn7.value) {
        if (Button2.value || btn4.value || btn5.value) {
            delay(1000)
            Button2.value = false
            btn4.value = false
            btn5.value = false
            btn7.value = false
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ejer_multipolithree_three),
            contentDescription = "Image",
        )
        Spacer(modifier = Modifier.height(50.dp))
        forTitleorBtn(
            textForTitle = stringResource(id = R.string.reescribe)
        )
        Row(modifier = Modifier.padding(top = 15.dp)) {
            checkBtnExersice(
                onClick = { Button1.value = true },
                enabled = !Button2.value,
                checkBorder = Button1.value,
                color = md_theme_light_primary, //Color for correct
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                content = {
                    bodyMedium(text = "(x+1)(x+1)(x+1)=", modifier = Modifier)
                }
            )
            checkBtnExersice(
                onClick = {
                    Button2.value = true
                },
                enabled = !Button1.value,
                checkBorder = Button2.value,
                color = md_theme_dark_errorContainer, //Color for incorrect
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                content = {
                    bodyLarge(text = "3(x+1)=", modifier = Modifier)
                }
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        if (Button1.value) {
            Column {
                forTitleorBtn(textForTitle = stringResource(id = R.string.desaCorrecta))
                Spacer(modifier = Modifier.height(20.dp))
                checkBtnExersice(
                    onClick = { btn3.value = true },
                    enabled = !btn4.value,
                    checkBorder = btn3.value,
                    color = md_theme_light_primary,
                    modifier = Modifier.fillMaxWidth(),
                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.btnthree_one_multipolithree_v),
                            contentDescription = "image"
                        )
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                checkBtnExersice(
                    onClick = {
                        btn4.value = true
                    },
                    enabled = !btn3.value,
                    checkBorder = btn4.value,
                    color = md_theme_dark_errorContainer,
                    modifier = Modifier.fillMaxWidth(),
                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.btnthree_one_multipolithree_f),
                            contentDescription = "image"
                        )
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        if (btn3.value) {
            Column {
                forTitleorBtn(textForTitle = stringResource(id = R.string.desaCorrecta))
                Row(modifier = Modifier.padding(top = 20.dp)) {
                    checkBtnExersice(
                        onClick = { btn5.value = true },
                        enabled = !btn6.value,
                        checkBorder = btn5.value,
                        color = md_theme_light_primary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp)
                            .weight(1f),
                        content = {
                            Image(
                                painter = painterResource(id = R.drawable.btnthree_two_multipolithree_v),
                                contentDescription = "image"
                            )
                        }
                    )
                    checkBtnExersice(
                        onClick = {
                            btn6.value = true
                        },
                        enabled = !btn5.value,
                        checkBorder = btn6.value,
                        color = md_theme_dark_errorContainer,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp)
                            .weight(1f),
                        content = {
                            Image(
                                painter = painterResource(id = R.drawable.btnthree_two_multipolithree_f),
                                contentDescription = "image"
                            )
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        if (btn5.value) {
            Column {
                forTitleorBtn(textForTitle = stringResource(id = R.string.desaCorrecta))
                Row(modifier = Modifier.padding(top = 20.dp)) {
                    checkBtnExersice(
                        onClick = {
                            btn7.value = true
                        },
                        enabled = !btn8.value,
                        checkBorder = btn7.value,
                        color = md_theme_dark_errorContainer,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp)
                            .weight(1f),
                        content = {
                            Image(
                                painter = painterResource(id = R.drawable.btnthree_two_multipolithree_f),
                                contentDescription = "image"
                            )
                        }
                    )
                    checkBtnExersice(
                        onClick = { btn8.value = true },
                        enabled = !btn7.value,
                        checkBorder = btn8.value,
                        color = md_theme_light_primary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp)
                            .weight(1f),
                        content = {
                            Image(
                                painter = painterResource(id = R.drawable.btnthree_three_multipolithree_v),
                                contentDescription = "image"
                            )
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        if (btn8.value) {
            Button(
                onClick = { scroll() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = colorAlpha_dark)
            ) {
                titleMedium(text = "Siguiente")
            }
        }
    }
} */

@Composable
fun LazyExerciseMultiPoliThree4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliThree4(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseMultiPoliThree4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("x", "2x")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        Exponente(base = "(x + 1)(x + 2)", exponente = "2", modifier = Modifier.align(Alignment.CenterHorizontally))
        listAnswerOne.forEachIndexed { index, s ->
            ButtonPerson(
                index + 1,
                modifier = recycleModi,
                topicVM
            ) {
                ExponenteLarge(
                    b1 = s,
                    b2 = if (index == 0) " + 5x" else " + 4x",
                    b3 = if (index == 0) "  + 8x + 4" else " + 5x + 2",
                    e1 = "3",
                    e2 = "2",
                    e3 = "",
                    modifier = Modifier
                )
            }
        }
        BtnCheck(
            onClick = { scroll() },
            topicVM
        )
    }
}

@Composable
fun LazyExerciseMultiPoliThree5(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliThree5(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
fun ExerciseMultiPoliThree5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswerOne =
        listOf(R.drawable.btnfive_multipolithree_fal_dark, R.drawable.btnfive_multipolithree_v_dark)
    val listLightA = listOf(
        R.drawable.btnfive_multipolithree_fal_light,
        R.drawable.btnfive_multipolithree_v_light
    )
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_multipolithree_five_dark,
            painterL = R.drawable.ejer_multipolithree_five_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        listAnswerOne.forEachIndexed { index, s ->
            ButtonPerson(
                index + 1,
                modifier = recycleModi,
                topicVM
            ) {
                ImageAnimation(
                    userStateVM,
                    painterD = s,
                    painterL = listLightA[index],
                    modifier = Modifier
                )
            }
        }
        BtnCheck(
            onClick = { scroll() },
            topicVM
        )
    }
}

@Composable
fun LazyExerciseMultiPoliThree6(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseMultiPoliThree6(navController, topicVM) }
    }
}

@Composable
fun ExerciseMultiPoliThree6(navController: NavController, topicVM: TopicVM) {

    val listAnswerOne = listOf("x", "x")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val alignment = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2A4_two), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "(x - 2)(x - 1)(x + 2)(x + 1) =", modifier = alignment)
        SpaceH()
        listAnswerOne.forEachIndexed { index, s ->
            ButtonPerson(
                index + 1,
                modifier = recycleModi,
                topicVM
            ) {
                ExponenteLarge(
                    b1 = s,
                    b2 = " - 5x",
                    b3 = if (index == 1) " + 4" else " + x + 4",
                    e1 = "4",
                    e2 = if (index == 0) "3" else "2",
                    e3 = "",
                    modifier = Modifier
                )
            }
        }
        btnNextTopic(
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.puntosDePlanoOne
        )
    }
}