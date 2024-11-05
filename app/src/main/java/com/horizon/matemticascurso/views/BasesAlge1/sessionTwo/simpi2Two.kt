@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionTwo

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
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
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.OutlinedText
import com.horizon.matemticascurso.views.components.alertBtnStyle
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodySmall
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.components.topicsComponents.examplesToExercise.eToSimpliSession1
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.By
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.SpaceW
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun simpli2TwoScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 7 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "simplificacion session 2", analytics = analytics)
    alertBtnStyle(
        PartiallyExpanded = true,
        showExample = showExample.value,
        onDismissRequest = { showExample.value = false },
        content = { eToSimpliSession1() }
    )

    TopBarTopics(
        navController,
        titleTopBar = "Simplificación",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseSimpli2Two1(modifier, pagerState, topicVM, scope, userStateVM)
                1 -> LazyExerciseSimpli2Two2(modifier, pagerState, topicVM, scope, userStateVM)
                2 -> LazyExerciseSimpli2Two3(modifier, pagerState, topicVM, scope)
                3 -> LazyExerciseSimpli2Two4(modifier, pagerState, topicVM, scope, userStateVM)
                4 -> LazyExerciseSimpli2Two5(modifier, pagerState, topicVM, scope, userStateVM)
                5 -> LazyExerciseSimpli2Two6(modifier, pagerState, topicVM, scope, userStateVM)
                6 -> LazyExerciseSimpli2Two7(modifier, navController, topicVM, userStateVM)
            }
        },
        pagerState,
        repeatBoxes = 8,
        spaceByBoxes = 25.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseSimpli2Two1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSimpli2Two1(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
fun ExerciseSimpli2Two1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current,
) {

    val state by topicVM.state.collectAsState()
    val listExpo = listOf(state.onValueChange, state.onValueChangeTwo, state.onValueChangeThree)
    val listBase = listOf("a", "b", "c")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        if (state.onValueChange == "-36" && state.onValueChangeTwo == "2" && state.onValueChangeThree == "3") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty() || state.onValueChangeTwo.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.desarrollo))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_simplimonopoli_two_two_dark,
            painterL = R.drawable.ejem_simplimonopoli_two_two_light,
            modifier = Modifier
        )
        Divider(modifier = Modifier.height(3.dp))
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        Row(
            modifier = recycleModi,
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            bodyLarge(text = "(3ab)(-6b)(2abc) =", modifier = Modifier)
            listBase.forEachIndexed { index, s ->
                Exponente(base = s, exponente = listExpo[index], modifier = Modifier)
            }
        }
        bodyLarge(text = stringResource(id = R.string.exponente), modifier = Modifier)
        Row(
            modifier = recycleModi,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            listExpo.forEachIndexed { index, s ->
                OutlinedText(
                    value = s,
                    onValueChange = {
                        when (index) {
                            0 -> topicVM.onValueChangeOne(it)
                            1 -> topicVM.onValueChangeTwo(it)
                            2 -> topicVM.onValueChangeThree(it)
                        }
                    },
                    placeholder = null
                )
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSimpli2Two2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSimpli2Two2(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
fun ExerciseSimpli2Two2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswerOne =
        listOf(R.drawable.btnone_simplitwo_two_f_dark, R.drawable.btnone_simplitwo_two_v_dark)
    val listOneDark =
        listOf(R.drawable.btnone_simplitwo_two_f_light, R.drawable.btnone_simplitwo_two_v_light)
    val listAnswerTwo =
        listOf(R.drawable.btnone_simplitwo_two_fal_dark, R.drawable.btnone_simplitwo_two_false_dark)
    val listTwoDark = listOf(
        R.drawable.btnone_simplitwo_two_fal_light,
        R.drawable.btnone_simplitwo_two_false_light
    )
    val listbaseOne = listOf("3", "2", "4")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        SpaceH()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = recycleModi
        ) {
            listbaseOne.forEachIndexed { indexOne, s ->
                val listBaseTwo = listOf("x", "y", "z")
                val listExpoTwo = listOf("3", "2", "", "3", "5", "4", "", "", "2")
                bodyLarge(text = s, modifier = Modifier)
                listBaseTwo.forEachIndexed { indexTwo, b ->
                    Exponente(
                        base = b, exponente = listExpoTwo[when (indexOne) {
                            0 -> indexTwo
                            1 -> indexTwo + 3
                            2 -> indexTwo + 6
                            else -> indexTwo
                        }], modifier = Modifier
                    )
                }
                By(indexOne != 2)
                if (indexOne == 2) bodyLarge(text = " = ", modifier = Modifier)
            }
        }
        SpaceH()
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
                        painterL = listOneDark[index],
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
                        painterL = listTwoDark[index],
                        modifier = Modifier
                    )
                }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSimpli2Two3(
    modifier: Modifier, pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSimpli2Two3(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseSimpli2Two3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        val listBase = listOf("a", "b")
        val listExpo = listOf("2", "3")
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = recycleModi
        ) {
            bodyLarge(text = "(3", modifier = Modifier)
            listBase.forEachIndexed { index, s ->
                Exponente(
                    base = s,
                    exponente = listExpo[index],
                    modifier = Modifier
                )
            }
            Exponente(base = ")", exponente = "4", modifier = Modifier)
        }
        SpaceW()
        Row(modifier = recycleModi) {
            val listans = listOf("81a", "12a")
            val listExpoAns = listOf("8", "12")
            listans.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    val sndExpo = listOf("12", "9")
                    Row {
                        Exponente(base = s, exponente = listExpoAns[index], modifier = Modifier)
                        Exponente(base = "b", exponente = sndExpo[index], modifier = Modifier)
                    }
                }
            }
        }
        SpaceW()
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSimpli2Two4(
    modifier: Modifier, pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSimpli2Two4(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
fun ExerciseSimpli2Two4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswerOne = listOf("Verdadero", "Falso")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.VoF))
        SpaceH()
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_simplimonopoli_two_four_dark,
            painterL = R.drawable.ejer_simplimonopoli_two_four_light,
            modifier = Modifier
        )
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
fun LazyExerciseSimpli2Two5(
    modifier: Modifier, pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSimpli2Two5(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
fun ExerciseSimpli2Two5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswerOne = listOf("Verdadero", "Falso")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.VoF))
        Spacer(modifier = Modifier.height(10.dp))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_simplimonopoli_two_five_dark,
            painterL = R.drawable.ejer_simplimonopoli_two_five_light,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(20.dp))
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
fun LazyExerciseSimpli2Two6(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSimpli2Two6(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
fun ExerciseSimpli2Two6(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current,
) {

    val state by topicVM.state.collectAsState()
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        if (state.onValueChange == "-64" && state.onValueChangeTwo == "6" && state.onValueChangeThree == "18") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty() || state.onValueChangeTwo.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        Row(
            modifier = recycleModi,
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            ImageAnimation(
                userStateVM,
                painterD = R.drawable.ejer_simplimonopoli_two_six_dark,
                painterL = R.drawable.ejer_simplimonopoli_two_six_light,
                modifier = Modifier
            )
            Box(modifier = Modifier.padding(top = 15.dp)) {
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    bodyLarge(text = state.onValueChange, modifier = Modifier)
                    bodyLarge(text = "a", modifier = Modifier)
                    bodySmall(text = state.onValueChangeTwo, modifier = Modifier)
                    bodyLarge(text = "b", modifier = Modifier)
                    bodySmall(text = state.onValueChangeThree, modifier = Modifier)
                }
            }
        }
        bodyLarge(text = stringResource(id = R.string.exponente), modifier = Modifier)
        Row(
            modifier = recycleModi,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            OutlinedText(
                value = state.onValueChange,
                onValueChange = { topicVM.onValueChangeOne(onValue = it) },
                placeholder = null
            )
            OutlinedText(
                value = state.onValueChangeTwo,
                onValueChange = { topicVM.onValueChangeTwo(onValue = it) },
                placeholder = { Text(text = "a") }
            )
            OutlinedText(
                value = state.onValueChangeThree,
                onValueChange = { topicVM.onValueChangeThree(onValue = it) },
                placeholder = { Text(text = "b") }
            )
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSimpli2Two7(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSimpli2Two7(navController, topicVM, userStateVM) }
    }
}

@Composable
fun ExerciseSimpli2Two7(navController: NavController, topicVM: TopicVM, userStateVM: UserStateVM) {

    val listAnswerOne = listOf(
        painterResource(id = R.drawable.btnseven_simplitwo_two_f),
        painterResource(id = R.drawable.btnseven_simplitwo_two_v)
    )
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.VoF), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_simplimonopoli_two_seven_dark,
            painterL = R.drawable.ejer_simplimonopoli_two_seven_light,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = recycleModi) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { Image(painter = s, contentDescription = null) }
            }
        }
        btnNextTopic(
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.simpli2Three
        )
    }
}