@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.sessionThree

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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.OutlinedText
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.forTitleorBtn
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope

val listError = listOf("Ej. 3,2", "Intenta poniendo una coma")

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SistemEcua2ThreeScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 4 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "sistema ecuaciones 2 sesion3", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Sistema de ecuaciones",
        topicVM,
        pageContent =  { page ->
            when (page) {
                0 -> LazyExerciseSistemEcua2Three1(modifier, pagerState, topicVM, scope, userStateVM)
                1 ->  LazyExerciseSistemEcua2Three2(modifier, pagerState, topicVM, scope, userStateVM)
                2 ->  LazyExerciseSistemEcua2Three3(modifier, pagerState, topicVM, scope, userStateVM)
                3 ->  LazyExerciseSistemEcua2Three4(modifier, navController, topicVM, userStateVM)
            }
        },
        pagerState,
        repeatBoxes = 4,
        spaceByBoxes = 60.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseSistemEcua2Three1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2Three1(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
fun ExerciseSistemEcua2Three1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "6, 2" || state.onValueChange == "6,2") {
            topicVM.animatedScroll(scope, pagerState, true)
        }
        else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        }
        else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        forTitleorBtn(textForTitle = stringResource(R.string.contestaCorrec))
        Spacer(modifier = Modifier.height(20.dp))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuatwo_three_one_dark,
            painterL = R.drawable.ejer_sistemecuatwo_three_one_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
        bodyLarge(
            text = "(x,y) = (${state.onValueChange})",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        OutlinedText(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(it) },
            placeholder = null
        )
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseSistemEcua2Three2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2Three2(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
fun ExerciseSistemEcua2Three2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "1, 2" || state.onValueChange == "1,2") {
            topicVM.animatedScroll(scope, pagerState, true)
        }
        else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        }
        else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        forTitleorBtn(textForTitle = stringResource(R.string.contestaCorrec))
        Spacer(modifier = Modifier.height(20.dp))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuatwo_three_two_dark,
            painterL = R.drawable.ejer_sistemecuatwo_three_two_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
        bodyLarge(
            text = "(x,y) = (${state.onValueChange})",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        OutlinedText(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(it) },
            placeholder = null
        )
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseSistemEcua2Three3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2Three3(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua2Three3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "3, 2" || state.onValueChange == "3,2") {
            topicVM.animatedScroll(scope, pagerState, true)
        }
        else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        }
        else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        forTitleorBtn(textForTitle = stringResource(R.string.contestaCorrec))
        Spacer(modifier = Modifier.height(20.dp))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuatwo_three_three_dark,
            painterL = R.drawable.ejer_sistemecuatwo_three_three_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        bodyLarge(
            text = "(x,y) = (${state.onValueChange})",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        OutlinedText(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(it) },
            placeholder = null
        )
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseSistemEcua2Three4(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua2Three4(navController, topicVM, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua2Three4(
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val listAnswer = listOf("Verdadero", "Falso")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        titleMedium(text = stringResource(id = R.string.VoF))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuatwo_nine_dark,
            painterL = R.drawable.ejer_sistemecuatwo_nine_light,
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
        btnNextTopic(onClick = { scroll() }, topicVM,
            navController,
            destination = AppScreens.desigualLineales
        )
    }
}