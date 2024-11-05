@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionThree

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.components.topicsComponents.examplesToExercise.eToSimpliSession3
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.SignDivi
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun simpli2ThreeScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 6 })
    val modifier = Modifier.fillMaxSize()
    val showExample = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "basic operation sesion 3", analytics = analytics)
    alertBtnStyle(
        PartiallyExpanded = true,
        showExample = showExample.value,
        onDismissRequest = { showExample.value = false },
        content = { eToSimpliSession3() }
    )

    TopBarTopics(
        navController,
        titleTopBar = "Simplificación",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseSimpli2Three1(
                    modifier,
                    pagerState,
                    topicVM,
                    scope,
                    userStateVM
                )

                1 -> LazyExerciseSimpli2three2(
                    pagerState, modifier,
                    topicVM,
                    scope
                )

                2 -> LazyExerciseSimpli2three3(
                    pagerState,
                    modifier,
                    topicVM,
                    scope,
                    userStateVM
                )

                3 -> LazyExerciseSimpli2three4(
                    pagerState, modifier,
                    topicVM,
                    scope,
                    userStateVM
                )

                4 -> LazyExerciseSimpli2Three5(
                    modifier,
                    pagerState,
                    topicVM,
                    scope,
                    userStateVM
                )

                5 -> LazyExerciseSimpli2three6(
                    modifier,
                    navController,
                    topicVM,
                    userStateVM
                )
            }
        },
        pagerState,
        repeatBoxes = 6,
        spaceByBoxes = 30.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseSimpli2Three1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseSimpli2Three1(
                pagerState, topicVM, scope, userStateVM
            )
        }
    }
}

@Composable
fun ExerciseSimpli2Three1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current,
) {

    val state by topicVM.state.collectAsState()
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        if (state.onValueChange == "4") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.desarrollo))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_simplimonopoli_four_dark,
            painterL = R.drawable.ejem_simplimonopoli_four_light,
            modifier = Modifier
        )
        Divider(modifier = recycleModi.height(1.dp))
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        Row(
            modifier = recycleModi,
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            ImageAnimation(
                userStateVM,
                painterD = R.drawable.ejer_simplitwo_three_one_dark,
                painterL = R.drawable.ejer_simplitwo_three_one_light,
                modifier = Modifier
            )
            Exponente(base = "a", exponente = state.onValueChange, modifier = Modifier)
        }
        bodyLarge(text = stringResource(id = R.string.exponente), modifier = Modifier)
        OutlinedText(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(onValue = it) },
            placeholder = null
        )
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSimpli2three2(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSimpli2three2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseSimpli2three2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf(
        painterResource(id = R.drawable.btnonepru_simplitwo_one_v),
        painterResource(id = R.drawable.btntwo_simplitwo_three_f)
    )
    val expoExample = listOf("4", "3")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 3)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.desaCorrecta), modifier = Modifier)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            expoExample.forEachIndexed { index, s ->
                Exponente(base = "a", exponente = s, modifier = Modifier)
                if (index == 0) SignDivi() else bodyLarge(text = " = ", modifier = Modifier)
            }
        }
        Row(modifier = recycleModi) {
            val expoOne = listOf("5", "7")
            expoOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { Exponente(base = "a", exponente = s, modifier = Modifier) }
            }
        }
        Row(modifier = recycleModi) {
            val baseOne = listOf("a", "0")
            baseOne.forEachIndexed { index, s ->
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
fun LazyExerciseSimpli2three3(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseSimpli2three3(
                pagerState,
                topicVM,
                scope,
                userStateVM
            )
        }
    }
}

@Composable
private fun ExerciseSimpli2three3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        if (state.onValueChange == "3") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyMedium(
            text = stringResource(id = R.string.excersicethreeSimpliTwo),
            modifier = Modifier
        )
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_simplimonopoli_five_dark,
            painterL = R.drawable.ejem_simplimonopoli_five_light,
            modifier = Modifier
        )
        Divider(modifier = recycleModi)
        bodyLarge(text = stringResource(id = R.string.desaCorrecta), modifier = Modifier)
        Row(
            modifier = recycleModi,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            val exponen = listOf("5", "2")
            exponen.forEachIndexed { index, s ->
                Exponente(base = "a", exponente = s, modifier = Modifier)
                if (index == 0) SignDivi() else bodyLarge(text = " = ", modifier = Modifier)
            }
            Exponente(base = "a", exponente = state.onValueChange, modifier = Modifier)
        }
        bodyLarge(text = stringResource(id = R.string.exponente), modifier = Modifier)
        Row(modifier = recycleModi) {
            OutlinedText(
                value = state.onValueChange,
                onValueChange = { topicVM.onValueChangeOne(onValue = it) },
                placeholder = null
            )
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseSimpli2three4(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSimpli2three4(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSimpli2three4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswerOne = listOf("x", "0")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.desaCorrecta), modifier = Modifier)
        SpaceH()
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_simplitwo_three_seven_dark,
            painterL = R.drawable.ejer_simplitwo_three_seven_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
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
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseSimpli2Three5(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseSimpli2three5(
                pagerState,
                topicVM,
                scope,
                userStateVM
            )
        }
    }
}

@Composable
private fun ExerciseSimpli2three5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val baseList = listOf("x", "y")
    val expoLis = listOf(state.onValueChange, state.onValueChangeTwo)
    val outlines = listOf(state.onValueChange, state.onValueChangeTwo)
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        if (state.onValueChange == "3") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.desaCorrecta), modifier = Modifier)
        Row(modifier = recycleModi) {
            ImageAnimation(
                userStateVM,
                painterD = R.drawable.ejer_simplitwo_three_five_dark,
                painterL = R.drawable.ejer_simplitwo_three_five_light,
                modifier = Modifier
            )
            baseList.forEachIndexed { index, s ->
                Exponente(base = s, exponente = expoLis[index], modifier = Modifier)
            }
        }
        bodyLarge(text = stringResource(id = R.string.exponente), modifier = Modifier)
        Row(modifier = recycleModi) {
            outlines.forEachIndexed { index, s ->
                OutlinedText(
                    value = s,
                    onValueChange = {
                        if (index == 0) topicVM.onValueChangeOne(onValue = it)
                        else if (index == 1) topicVM.onValueChangeTwo(onValue = it)
                    },
                    placeholder = {
                        Text(
                            text = when (index) {
                                0 -> "x"
                                1 -> "y"
                                else -> ""
                            }
                        )
                    }
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseSimpli2three6(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSimpli2three6(navController, topicVM, userStateVM) }
    }
}

@Composable
private fun ExerciseSimpli2three6(navController: NavController, topicVM: TopicVM, userStateVM: UserStateVM) {

    val listAnswerOne = listOf("Verdadero", "Falso")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.VoF))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_simplitwo_three_six_dark,
            painterL = R.drawable.ejer_simplitwo_three_six_light,
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
        btnNextTopic(
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.multiPoliOne
        )
    }
}