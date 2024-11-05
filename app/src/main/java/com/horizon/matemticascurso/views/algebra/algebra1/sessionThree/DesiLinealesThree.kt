@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.sessionThree

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.ScreenEnabled
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DesigualLinealThreeScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 1 })
    val showExample = remember { mutableStateOf(false) }
    val nextPage = (pagerState.currentPage+1).coerceIn(0, pagerState.pageCount-1)
    val modifier = Modifier.fillMaxSize()

    analyticsTrackScreen(name = "desigualdades lineales sesion3", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Desigualdades lineales",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> ScreenEnabled(modifier)
            }
        },
        pagerState,
        repeatBoxes = 5,
        spaceByBoxes = 45.dp,
        showExample = { showExample.value = true }
    )
}

/*@Composable
fun LazyExerciseDesiLinealesThree1(pagerState: PagerState, nextPage: Int, modifier: Modifier){
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealesThree1(pagerState, nextPage) }
    }
}

@Composable
private fun ExerciseDesiLinealesThree1(pagerState: PagerState, nextPage: Int) {

    var activeButtonIndex by remember { mutableIntStateOf(0) }
    val ifIncorrect = remember { mutableStateOf(false) }
    val listOne = listOf("x < -5", "x > 5")
    val ifCorrect = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxWidth()
    val scope = rememberCoroutineScope()
    fun check() {
        if (activeButtonIndex == 1) {
            ifCorrect.value = true
            scope.launch {
                pagerState.animateScrollToPage(
                    nextPage,
                    animationSpec = tween(
                        durationMillis = 2000,
                        easing = LinearEasing
                    )
                )
            }
        } else if (activeButtonIndex == 2) {
            ifIncorrect.value = true
        }
    }
    LaunchedEffect(key1 = ifIncorrect.value) {
        if (ifIncorrect.value) {
            delay(1200)
            ifIncorrect.value = false
            activeButtonIndex = 0
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2Desi_one), modifier = Modifier)
        bodyLarge(text = "3x(x -1)-(x - 4) < x - 3", modifier = align)
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    onClick = {
                        when (index) {
                            0 -> activeButtonIndex = 1
                            1 -> activeButtonIndex = 2
                        }
                    },
                    checkActiveBtn = when (index) {
                        0 -> activeButtonIndex == 1
                        1 -> activeButtonIndex == 2
                        else -> activeButtonIndex == 0
                    },
                    modifier = when (index) {
                        0 -> modifier.weight(1f)
                        1 -> modifier.weight(1f)
                        else -> modifier
                    }
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { check() },
            ifCorrect = ifCorrect.value,
            ifIncorrect = ifIncorrect.value
        )
    }
}

@Composable
fun LazyExerciseDesiLinealesThree2(pagerState: PagerState, nextPage: Int, modifier: Modifier){
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealesThree2(pagerState, nextPage) }
    }
}

@Composable
private fun ExerciseDesiLinealesThree2(pagerState: PagerState, nextPage: Int) {

    var activeButtonIndex by remember { mutableIntStateOf(0) }
    val ifIncorrect = remember { mutableStateOf(false) }
    val listOne = listOf(painterResource(id = R.drawable.res_desilinealesthree_v), painterResource(id = R.drawable.res_desilinealesthree_f))
    val ifCorrect = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxWidth()
    val scope = rememberCoroutineScope()
    fun check() {
        if (activeButtonIndex == 1) {
            ifCorrect.value = true
            scope.launch {
                pagerState.animateScrollToPage(
                    nextPage,
                    animationSpec = tween(
                        durationMillis = 2000,
                        easing = LinearEasing
                    )
                )
            }
        } else if (activeButtonIndex == 2) {
            ifIncorrect.value = true
        }
    }
    LaunchedEffect(key1 = ifIncorrect.value) {
        if (ifIncorrect.value) {
            delay(1200)
            ifIncorrect.value = false
            activeButtonIndex = 0
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2Desi_one), modifier = Modifier)
        Image(
            painter = painterResource(id = R.drawable.img_desilinealesthree_one),
            contentDescription = null,
            modifier = align
        )
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    onClick = {
                        when (index) {
                            0 -> activeButtonIndex = 1
                            1 -> activeButtonIndex = 2
                        }
                    },
                    checkActiveBtn = when (index) {
                        0 -> activeButtonIndex == 1
                        1 -> activeButtonIndex == 2
                        else -> activeButtonIndex == 0
                    },
                    modifier = when (index) {
                        0 -> modifier.weight(1f)
                        1 -> modifier.weight(1f)
                        else -> modifier
                    }
                ) { Image(painter = s, contentDescription = null) }
            }
        }
        BtnCheck(
            onClick = { check() },
            ifCorrect = ifCorrect.value,
            ifIncorrect = ifIncorrect.value
        )
    }
}

@Composable
fun LazyExerciseDesiLinealesThree3(pagerState: PagerState, nextPage: Int, modifier: Modifier){
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealesThree3(pagerState, nextPage) }
    }
}

@Composable
private fun ExerciseDesiLinealesThree3(pagerState: PagerState, nextPage: Int) {

    var activeButtonIndex by remember { mutableIntStateOf(0) }
    val ifIncorrect = remember { mutableStateOf(false) }
    val listOne = listOf("x > 2", "x < 7")
    val ifCorrect = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxWidth()
    val scope = rememberCoroutineScope()
    fun check() {
        if (activeButtonIndex == 1) {
            ifCorrect.value = true
            scope.launch {
                pagerState.animateScrollToPage(
                    nextPage,
                    animationSpec = tween(
                        durationMillis = 2000,
                        easing = LinearEasing
                    )
                )
            }
        } else if (activeButtonIndex == 2) {
            ifIncorrect.value = true
        }
    }
    LaunchedEffect(key1 = ifIncorrect.value) {
        if (ifIncorrect.value) {
            delay(1200)
            ifIncorrect.value = false
            activeButtonIndex = 0
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2Desi_one), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.desiLinealesThree_one), modifier = align)
        bodyLarge(text = "Sol. ¿? < 2x", modifier = align)
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    onClick = {
                        when (index) {
                            0 -> activeButtonIndex = 1
                            1 -> activeButtonIndex = 2
                        }
                    },
                    checkActiveBtn = when (index) {
                        0 -> activeButtonIndex == 1
                        1 -> activeButtonIndex == 2
                        else -> activeButtonIndex == 0
                    },
                    modifier = when (index) {
                        0 -> modifier.weight(1f)
                        1 -> modifier.weight(1f)
                        else -> modifier
                    }
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { check() },
            ifCorrect = ifCorrect.value,
            ifIncorrect = ifIncorrect.value
        )
    }
}

@Composable
fun LazyExerciseDesiLinealesThree4(pagerState: PagerState, nextPage: Int, modifier: Modifier, ViewModel: FieldViewModel){
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealesThree4(pagerState, nextPage, ViewModel) }
    }
}

@Composable
private fun ExerciseDesiLinealesThree4(
    pagerState: PagerState,
    nextPage: Int,
    ViewModel: FieldViewModel,
    context: Context = LocalContext.current
) {

    val state by ViewModel.state.collectAsState()
    val ifIncorrect = remember { mutableStateOf(false) }
    val ifCorrect = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    fun check() {
        if (state.textFieldOne == "x>2" || state.textFieldOne == "x > 2") {
            ifCorrect.value = true
            scope.launch {
                pagerState.animateScrollToPage(
                    nextPage,
                    animationSpec = tween(
                        durationMillis = 2000,
                        easing = LinearEasing
                    )
                )
            }
            ViewModel.onUserInput()
        } else if (state.textFieldOne.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, listError.random(), Toast.LENGTH_SHORT).show()
            ifIncorrect.value = true
        }
    }
    LaunchedEffect(key1 = ifIncorrect.value) {
        if (ifIncorrect.value) {
            delay(1200)
            ifIncorrect.value = false
            ViewModel.onUserInput()
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2Desi_one), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.desiLinealesThree_two), modifier = align)
        bodyMedium(text = stringResource(id = R.string.writeHere), modifier = Modifier)
        bodyLarge(text = state.textFieldOne, modifier = align)
        OutlinedTextString(
            value = state.textFieldOne,
            onValueChange = { ViewModel.updateTextField(firstText = it) },
            keyboardType = KeyboardType.Text,
            placeholder = { Text(text = "Ej. x>2") }
        )
        BtnCheck(
            onClick = { check() },
            ifCorrect = ifCorrect.value,
            ifIncorrect = ifIncorrect.value
        )
    }
}

@Composable
fun LazyExerciseDesiLinealesThree5(modifier: Modifier, ViewModel: FieldViewModel, navController: NavController) {
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealesThree5(navController, ViewModel) }
    }
}

@Composable
private fun ExerciseDesiLinealesThree5(
    navController: NavController,
    ViewModel: FieldViewModel,
    context: Context = LocalContext.current
) {

    val state by ViewModel.state.collectAsState()
    val ifIncorrect = remember { mutableStateOf(false) }
    val ifCorrect = remember { mutableStateOf(false) }
    fun check() {
        if (state.textFieldOne == "x>-7" || state.textFieldOne == "x > -7") {
            ifCorrect.value = true
            ViewModel.onUserInput()
        } else if (state.textFieldOne.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, listError.random(), Toast.LENGTH_SHORT).show()
            ifIncorrect.value = true
        }
    }
    LaunchedEffect(key1 = ifIncorrect.value) {
        if (ifIncorrect.value) {
            delay(1200)
            ifIncorrect.value = false
            ViewModel.onUserInput()
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2Desi_one), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.desiLinealesThree_three), modifier = align)
        bodyMedium(text = stringResource(id = R.string.writeHere), modifier = Modifier)
        bodyLarge(text = state.textFieldOne, modifier = align)
        OutlinedTextString(
            value = state.textFieldOne,
            onValueChange = { ViewModel.updateTextField(firstText = it) },
            keyboardType = KeyboardType.Text,
            placeholder = { Text(text = "Ej. x>2") }
        )
        btnNextTopic(
            ifCorrect = ifCorrect.value,
            ifIncorrect = ifIncorrect.value,
            onClick = { check() },
            navController ,
            destination = AppScreens.producNotaOne
        )
    }
}*/