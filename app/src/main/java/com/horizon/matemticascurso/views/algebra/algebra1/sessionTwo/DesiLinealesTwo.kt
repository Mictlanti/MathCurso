@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.sessionTwo

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.horizon.matemticascurso.views.components.ExceptionBody
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forTitleorBtn
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.ui.theme.colorAlpha_dark
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DesigualLinealTwoScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 6 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "desigualdades lineales sesion2", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Desigualdades lineales",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseDesiLinealesTwo1(pagerState, modifier, topicVM, scope)
                1 -> LazyExerciseDesiLinealesTwo2(pagerState, modifier, topicVM, scope)
                2 -> LazyExerciseDesiLinealesTwo3(pagerState, modifier,topicVM, scope)
                3 -> LazyExerciseDesiLinealesTwo4(pagerState, modifier, topicVM, scope)
                4 -> LazyExerciseDesiLinealesTwo5(pagerState, modifier, topicVM, scope)
                5 -> LazyExerciseDesiLinealesTwo6(navController, modifier, topicVM, userStateVM)
            }
        },
        pagerState,
        repeatBoxes = 6,
        spaceByBoxes = 45.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseDesiLinealesTwo1(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealesTwo1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseDesiLinealesTwo1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("x > -6", "x < -6")
    val listAns = listOf("1) -x > 2", "x < -2", "2 ) -2x < -6", "x > 3")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.desarrollo))
        listAns.forEach { s ->
            bodyLarge(text = s, modifier = Modifier.align(Alignment.CenterHorizontally))
        }
        bodyMedium(text = stringResource(id = R.string.Box2Desi_three), modifier = Modifier)
        forTitleorBtn(textForTitle = stringResource(id = R.string.Box2Desi_one))
        SpaceH()
        bodyLarge(text = "-2x > 12", modifier = Modifier.align(Alignment.CenterHorizontally))
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
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
fun LazyExerciseDesiLinealesTwo2(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealesTwo2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseDesiLinealesTwo2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("x > 6", "x < -6")
    val listAns = listOf("1)  -x < 2", "= -x + (-2) < 2 + (-2)", "-x - 2 < 0", "= (x) + -x - 2 < 0 + (x)", "= -2 < x", "Así, x > -2")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        ExceptionBody(body = stringResource(id = R.string.Box4Desi_one))
        titleMedium(text = stringResource(id = R.string.Box4Desi_two))
        listAns.forEach { s -> bodyLarge(text = s, modifier = align) }
        HorizontalDivider()
        bodyLarge(text = stringResource(id = R.string.Box2Desi_one), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "4x - 9 > 7x + 9", modifier = align)
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier =modifier.weight(1f),
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
fun LazyExerciseDesiLinealesTwo3(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealesTwo3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseDesiLinealesTwo3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("x < -2", "x > -2")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2Desi_one), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "3x + 4 > 5x + 8", modifier = align)
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier =  modifier.weight(1f),
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
fun LazyExerciseDesiLinealesTwo4(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealesTwo4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseDesiLinealesTwo4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("x < 1", "x > 5")
    val listTwo = listOf("x < -1", "x < -5")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2Desi_one), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "5 - 2(x + 3) > -3", modifier = align)
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
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
fun LazyExerciseDesiLinealesTwo5(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealesTwo5(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseDesiLinealesTwo5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("x < 1", "x > -3")
    val listTwo = listOf("x > -1", "x < 2")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 3)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2Desi_one), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "2x - (9x + 4) < 3", modifier = align)
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1 ,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = modifier.weight(1f),
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
fun LazyExerciseDesiLinealesTwo6(
    navController: NavController,
    modifier: Modifier,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealesTwo6(navController, topicVM, userStateVM) }
    }
}

@Composable
private fun ExerciseDesiLinealesTwo6(
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val listOne = listOf(
        painterResource(id = R.drawable.res_desilinalestwo_f),
        painterResource(id = R.drawable.res_desilinalestwo_v)
    )
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkFinishInt(2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2Desi_one), modifier = Modifier)
        SpaceH()
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.img_desilinalestwo_one_dark,
            painterL = R.drawable.img_desilinalestwo_one_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                        topicVM
                ) { Image(painter = s, contentDescription = null) }
            }
        }
        btnNextTopic(
            onClick = { check() },
            topicVM,
            navController,
            destination = AppScreens.desigualLinealesThree
        )
    }
}

@Composable
fun Box5C3(navController: NavController) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val IfCorrect = remember { mutableStateOf(false) }
    val IfIncorrect = remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        forTitleorBtn(textForTitle = stringResource(id = R.string.Box2Desi_one))
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.ejem_desione_seven),
            contentDescription = "Image",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(modifier = Modifier.padding(top = 30.dp)) {
            Button(
                onClick = { Button1.value = !Button1.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button1.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button2.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btnone_desione_f),
                    contentDescription = "Image"
                )
            }
            Button(
                onClick = { Button2.value = !Button2.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button2.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button1.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button2.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btnone_desione_fal),
                    contentDescription = "Image"
                )
            }
        }
        Row(modifier = Modifier.padding(vertical = 15.dp)) {
            Button(
                onClick = { Button3.value = !Button3.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button3.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button1.value && !Button2.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button3.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btnone_desione_v),
                    contentDescription = "Image"
                )
            }
            Button(
                onClick = { Button4.value = !Button4.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button4.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button1.value && !Button2.value && !Button3.value && !IfCorrect.value && !IfIncorrect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button4.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btnone_desione_false),
                    contentDescription = "Image"
                )
            }
        }
    }
}