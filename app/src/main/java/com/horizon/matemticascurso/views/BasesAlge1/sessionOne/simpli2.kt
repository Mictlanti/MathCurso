@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionOne

import android.annotation.SuppressLint
import android.content.Context
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.horizon.matemticascurso.views.components.forTitleorBtn
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
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun simpli2OneScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 8 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "simplificación session 1", analytics = analytics)
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
                0 -> LazyExerciseSimpli2One1(pagerState, modifier, topicVM, scope, userStateVM)
                1 -> LazyExerciseSimpli2One2(
                    pagerState,
                    modifier,
                    topicVM,
                    scope
                )

                2 -> LazyExerciseSimpli2One3(
                    pagerState,
                    modifier,
                    topicVM,
                    scope
                )

                3 -> LazyExerciseSimpli2One4(
                    pagerState,
                    modifier,
                    topicVM,
                    scope
                )

                4 -> LazyExerciseSimpli2One5(
                    pagerState,
                    modifier,
                    topicVM,
                    scope
                )

                5 -> LazyExerciseSimpli2One6(
                    pagerState,
                    modifier,
                    topicVM,
                    scope,
                    userStateVM
                )

                6 -> LazyExerciseSimpli2One7(
                    pagerState,
                    modifier,
                    topicVM,
                    scope
                )

                7 -> LazyExerciseSimpli2One8(
                    navController,
                    modifier,
                    topicVM
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
fun LazyExerciseSimpli2One1(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSimpli2One1(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
fun ExerciseSimpli2One1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswerOne = listOf("y", "0")
    val listAnswerTwo = listOf("y", "x")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 3)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.desarrollo))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_simplitwo_one_one_dark,
            painterL = R.drawable.ejem_simplitwo_one_one_light,
            modifier = Modifier
        )
        Divider(modifier = recycleModi.height(2.dp))
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_simplitwo_one_one_dark,
            painterL = R.drawable.ejer_simplitwo_one_one_light,
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
                ) { Exponente(base = s, exponente = "5", modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSimpli2One2(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseSimpli2One2(pagerState, topicVM, scope)
        }
    }
}

@Composable
fun ExerciseSimpli2One2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val listExpo = listOf("2", "3", "5")
    fun scroll() {
        if (state.onValueChange == "10") {
            topicVM.animatedScroll(scope, pagerState, isCorrect = true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            listExpo.forEachIndexed { index, e ->
                Exponente(base = "z", exponente = e, modifier = Modifier)
                By(index != 2)
            }
            SpaceW(size = 4.dp)
            Box {
                Row {
                    bodyLarge(text = " = z", modifier = Modifier)
                    Spacer(modifier = Modifier.width(2.dp))
                    bodySmall(text = state.onValueChange, modifier = Modifier)
                }
            }
        }
        bodyLarge(text = stringResource(id = R.string.exponente), modifier = Modifier)
        SpaceH(size = 20.dp)
        OutlinedText(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(onValue = it) },
            placeholder = { Text(text = "z = ") }
        )
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSimpli2One3(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseSimpli2One3(pagerState, topicVM, scope)
        }
    }
}

@Composable
fun ExerciseSimpli2One3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val listExpo = listOf("5", "", "3")
    fun scroll() {
        if (state.onValueChange == "9") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            listExpo.forEachIndexed { index, e ->
                Exponente(base = "a", exponente = e, modifier = Modifier)
                By(index != 2)
            }
            Spacer(modifier = Modifier.width(4.dp))
            Box {
                Row {
                    bodyLarge(text = " = a", modifier = Modifier)
                    Spacer(modifier = Modifier.width(2.dp))
                    bodySmall(text = state.onValueChange, modifier = Modifier)
                }
            }
        }
        bodyLarge(text = stringResource(id = R.string.exponente), modifier = Modifier)
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedText(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(onValue = it) },
            placeholder = { Text(text = "z = ") }
        )
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSimpli2One4(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseSimpli2One4(pagerState, topicVM, scope)
        }
    }
}

@Composable
fun ExerciseSimpli2One4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current,
) {

    val state by topicVM.state.collectAsState()
    val listExpo = listOf("2", "4")
    fun scroll() {
        if (state.onValueChange == "6") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            listExpo.forEach { e ->
                Exponente(base = "a", exponente = e, modifier = Modifier)
                By()
            }
            bodyLarge(text = "b", modifier = Modifier)
            Spacer(modifier = Modifier.width(4.dp))
            Box {
                Row {
                    bodyLarge(text = " = a", modifier = Modifier)
                    Spacer(modifier = Modifier.width(2.dp))
                    bodySmall(text = state.onValueChange, modifier = Modifier)
                }
            }
            bodyLarge(text = "b", modifier = Modifier)
        }
        bodyLarge(text = stringResource(id = R.string.exponente), modifier = Modifier)
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedText(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(onValue = it) },
            placeholder = { Text(text = "z = ") }
        )
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSimpli2One5(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseSimpli2One5(pagerState, topicVM, scope)
        }
    }
}

@Composable
private fun ExerciseSimpli2One5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val listNo = listOf("2", "3")
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
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            listNo.forEachIndexed { index, s ->
                bodyLarge(text = s, modifier = Modifier)
                Exponente(base = "b", exponente = "2", modifier = Modifier)
                By(index == 0)
            }
            Spacer(modifier = Modifier.width(4.dp))
            bodyLarge(text = " = 6", modifier = Modifier)
            Box {
                Row {
                    bodyLarge(text = "b", modifier = Modifier)
                    Spacer(modifier = Modifier.width(2.dp))
                    bodySmall(text = state.onValueChange, modifier = Modifier)
                }
            }
        }
        SpaceH()
        bodyLarge(text = stringResource(id = R.string.exponente), modifier = Modifier)
        OutlinedText(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(onValue = it) },
            placeholder = { Text(text = "b = ") }
        )
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSimpli2One6(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSimpli2One6(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSimpli2One6(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswerOne = listOf(" = (-3a)(-3a)(-3a) = ", " = - (3a)(3a)(3a) = ")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.desarrollo))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_simplimonopoli_one_dark,
            painterL = R.drawable.ejem_simplimonopoli_one_light,
            modifier = Modifier
        )
        Divider(modifier = recycleModi)
        bodyLarge(text = stringResource(id = R.string.Box1B1_one), modifier = Modifier)
        Exponente(base = "(-3a)", exponente = "3", modifier = Modifier.align(Alignment.CenterHorizontally))
        Box {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                listAnswerOne.forEachIndexed { index, s ->
                    ButtonPerson(
                        index + 1,
                        modifier = recycleModi,
                        topicVM
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            bodyLarge(text = s, modifier = Modifier)
                            Exponente(base = "- 27a", exponente = "3", modifier = Modifier)
                        }
                    }
                }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSimpli2One7(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSimpli2One7(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseSimpli2One7(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("-2", "4")
    val listBase = listOf("a", "b", "c")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        SpaceH()
        Exponente(
            base = "(-2abc)",
            exponente = "2",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        Row(modifier = recycleModi) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        bodyLarge(text = s, modifier = Modifier)
                        SpaceW(size = 3.dp)
                        listBase.forEach { s ->
                            Exponente(base = s, exponente = "2", modifier = Modifier)
                        }
                    }
                }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSimpli2One8(
    navController: NavController,
    modifier: Modifier,
    topicVM: TopicVM,
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSimpli2One8(navController, topicVM) }
    }
}

@Composable
private fun ExerciseSimpli2One8(
    navController: NavController,
    topicVM: TopicVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val listAnswerOne = listOf(state.onValueChange, state.onValueChangeTwo, state.onValueChangeThree)
    val listbase = listOf(" = x", "y", "z")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        if (state.onValueChange == "3" && state.onValueChangeTwo == "3" && state.onValueChangeThree == "3") {
            topicVM.checkFinishString(true)
        } else if (state.onValueChange.isEmpty() || state.onValueChangeTwo.isEmpty() || state.onValueChangeThree.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.checkFinishString(false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val padding = Modifier.padding(top = 15.dp)
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        Row(
            modifier = recycleModi,
            horizontalArrangement = Arrangement.spacedBy(
                2.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            Exponente(base = "(xyz)", exponente = "3", modifier = Modifier.align(Alignment.CenterVertically))
            listbase.forEachIndexed { index, s ->
                Exponente(base = s, exponente = listAnswerOne[index], modifier = Modifier)
            }
        }
        bodyLarge(text = stringResource(id = R.string.exponente), modifier = Modifier)
        Row(
            modifier = recycleModi,
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally)
        ) {
            listAnswerOne.forEachIndexed { index, s ->
                OutlinedText(
                    value = s,
                    onValueChange = {
                        when (index) {
                            0 -> topicVM.onValueChangeOne(onValue = it)
                            1 -> topicVM.onValueChangeTwo(onValue = it)
                            2 -> topicVM.onValueChangeThree(onValue = it)
                        }
                    },
                    placeholder = {
                        Text(
                            text = when (index) {
                                0 -> "x ="
                                1 -> "y ="
                                2 -> "z ="
                                else -> ""
                            }
                        )
                    }
                )
            }
        }
        btnNextTopic(
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.simpli2Two
        )
    }
}

@Composable
fun LazyColumnBox4B1(pagerState: PagerState, nextPage: Int, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box4B1(pagerState, nextPage) }
    }
}

@Composable
fun Box4B1(pagerState: PagerState, nextPage: Int) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val IfCorrect = remember { mutableStateOf(false) }
    val IfIncorrect = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            Column {
                titleMedium(text = stringResource(id = R.string.desarrollo))
                Spacer(modifier = Modifier.height(15.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejem_simplimonopoli_four_dark),
                    contentDescription = "Image",
                )
                Spacer(modifier = Modifier.height(15.dp))
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box1B1_one))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_simplimonopoli_four),
                    contentDescription = "Image",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
        Row(modifier = Modifier.padding(top = 40.dp)) {
            Button(
                onClick = { Button1.value = !Button1.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button1.value) Color.Magenta else MaterialTheme.colorScheme.primary
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f),
                enabled = !Button2.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btnfour_simplimonopoli_f),
                    contentDescription = "Image",
                    modifier = Modifier.size(width = 150.dp, height = 100.dp)
                )
            }
            Button(
                onClick = { Button2.value = !Button2.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button2.value) Color.Magenta else MaterialTheme.colorScheme.primary
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button2.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f),
                enabled = !Button1.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btnfour_simplimonopoli_v),
                    contentDescription = "Image",
                    modifier = Modifier.size(width = 150.dp, height = 100.dp)
                )
            }
        }
        Row(modifier = Modifier.padding(vertical = 5.dp)) {
            Button(
                onClick = { Button3.value = !Button3.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button3.value) Color.Magenta else MaterialTheme.colorScheme.primary
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button3.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f),
                enabled = !Button2.value && !Button1.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btnfour_simplimonopoli_fal),
                    contentDescription = "Image",
                    modifier = Modifier.size(width = 150.dp, height = 100.dp)
                )
            }
            Button(
                onClick = { Button4.value = !Button4.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button4.value) Color.Magenta else MaterialTheme.colorScheme.primary
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button4.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f),
                enabled = !Button1.value && !Button3.value && !Button2.value && !IfCorrect.value && !IfIncorrect.value
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btnfour_simplimonopoli_false),
                    contentDescription = "Image",
                    modifier = Modifier.size(width = 150.dp, height = 100.dp)
                )
            }
        }
        Box {
            Button(
                onClick = {
                    when {
                        Button1.value -> IfIncorrect.value = !IfIncorrect.value
                        Button2.value -> {
                            IfCorrect.value = !IfCorrect.value
                            scope.launch {
                                pagerState.animateScrollToPage(
                                    nextPage,
                                    animationSpec = tween(
                                        durationMillis = 2000,
                                        easing = LinearEasing
                                    )
                                )
                            }
                        }

                        Button3.value -> IfIncorrect.value = !IfIncorrect.value
                        Button4.value -> IfIncorrect.value = !IfIncorrect.value
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = when {
                        IfCorrect.value -> Color.Green
                        IfIncorrect.value -> MaterialTheme.colorScheme.primary
                        else -> MaterialTheme.colorScheme.primary
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                titleMedium(
                    text = when {
                        IfCorrect.value -> "¡Bien hecho!"
                        IfIncorrect.value -> "Intentalo nuevamente"
                        else -> "Comprueba la respuesta"
                    }
                )
            }
        }
    }
}

@Composable
fun LazyColumnBox5B1(modifier: Modifier, navController: NavController) {
    LazyColumn(modifier = modifier) {
        item { Box5B1(navController) }
    }
}

@Composable
fun Box5B1(navController: NavController) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val IfCorrect = remember { mutableStateOf(false) }
    val IfIncorrect = remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box1B1_one))
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_simplimonopoli_five),
                    contentDescription = "Image",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
        Row(modifier = Modifier.padding(top = 80.dp)) {
            Button(
                onClick = { Button1.value = !Button1.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button1.value) Color.Magenta else MaterialTheme.colorScheme.primary
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f),
                enabled = !Button2.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btnfive_simplimonopoli_v),
                    contentDescription = "Image",
                    modifier = Modifier.size(width = 150.dp, height = 100.dp)
                )
            }
            Button(
                onClick = { Button2.value = !Button2.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button2.value) Color.Magenta else MaterialTheme.colorScheme.primary
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button2.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f),
                enabled = !Button1.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btnfive_simplimonopoli_f),
                    contentDescription = "Image",
                    modifier = Modifier.size(width = 150.dp, height = 100.dp)
                )
            }
        }
        Row(modifier = Modifier.padding(vertical = 5.dp)) {
            Button(
                onClick = { Button3.value = !Button3.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button3.value) Color.Magenta else MaterialTheme.colorScheme.primary
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button3.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f),
                enabled = !Button2.value && !Button1.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btnfive_simplimonopoli_fal),
                    contentDescription = "Image",
                    modifier = Modifier.size(width = 150.dp, height = 100.dp)
                )
            }
            Button(
                onClick = { Button4.value = !Button4.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button4.value) Color.Magenta else MaterialTheme.colorScheme.primary
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button4.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f),
                enabled = !Button1.value && !Button3.value && !Button2.value && !IfCorrect.value && !IfIncorrect.value
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btnfive_simplimonopoli_false),
                    contentDescription = "Image",
                    modifier = Modifier.size(width = 150.dp, height = 100.dp)
                )
            }
        }
    }
}