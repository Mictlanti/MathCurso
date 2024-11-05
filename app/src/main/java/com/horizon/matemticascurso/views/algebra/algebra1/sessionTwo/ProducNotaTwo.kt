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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.DiferenciaCuadrados
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteCuadrado
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forTitleorBtn
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.ui.theme.Color1
import com.horizon.matemticascurso.views.components.FormulaDiferenciaCuadrados
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProducNotaTwoScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 6 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "productos notables sesion2", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Productos notables",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseProducNotaTwo1(modifier, pagerState, topicVM, scope)
                1 -> LazyExerciseProducNotaTwo2(modifier, pagerState, topicVM, scope)
                2 -> LazyExerciseProducNotaTwo3(modifier, pagerState, topicVM, scope, userStateVM)
                3 -> LazyExerciseProducNotaTwo4(modifier, pagerState, topicVM, scope)
                4 -> LazyExerciseProducNotaTwo5(modifier, pagerState, topicVM, scope)
                5 -> LazyExerciseProducNotaTwo6(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 6,
        spaceByBoxes = 45.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseProducNotaTwo1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaTwo1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseProducNotaTwo1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("- 48 + ", " - 12 +")
    val listTwo = listOf(" - 12 - ", " - 48 + ")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        val start = Modifier.align(Alignment.Start)
        titleMedium(text = stringResource(id = R.string.desarrollo))
        Exponente(base = "3(x - 5)", exponente = "2", modifier = start)
        Row(
            modifier = modifier, 
            horizontalArrangement = Arrangement.Center
        ){
            ExponenteCuadrado(
                baseOne = "= 3(x",
                exponenOne = "2",
                next = " - 10x +",
                baseTwo = "25",
                exponenTwo = ""
            )
            bodyLarge(text = ")", modifier = Modifier)
        }
        ExponenteCuadrado(
            baseOne = "= 3x",
            exponenOne = "2",
            next = " - 30x + ",
            baseTwo = "75",
            exponenTwo = ""
        )
        bodyLarge(text = stringResource(id = R.string.Box7C4_Desa), modifier = start)
        SpaceH()
        Exponente(base = "4(2x - 3)", exponente = "2", modifier = Modifier)
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { 
                    ExponenteCuadrado(
                        baseOne = "16x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "9",
                        exponenTwo = ""
                    )
                }
            }
        }
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { 
                    ExponenteCuadrado(
                        baseOne = "4x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = if (index == 0) "9" else "12",
                        exponenTwo = "",
                        fontSize = 20.sp
                    )
                }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseProducNotaTwo2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaTwo2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseProducNotaTwo2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf(" - 20 +", " + 20 - ")
    val listTwo = listOf(" + 10 -", " - 10 -")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box7C4_Desa), modifier = Modifier)
        SpaceH()
        Exponente(base = "2(-x - 5)", exponente = "2", modifier = Modifier.align(Alignment.CenterHorizontally))
        SpaceH()
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { 
                    ExponenteCuadrado(
                        baseOne = "2x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "50",
                        exponenTwo = "",
                        fontSize = 23.sp
                    )
                }
            }
        }
        Row(modifier = recycleModi) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { 
                    ExponenteCuadrado(
                        baseOne = "-x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "25",
                        exponenTwo = "",
                        fontSize = 23.sp
                    )
                }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseProducNotaTwo3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaTwo3(pagerState, topicVM, scope, userStateVM) }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ExerciseProducNotaTwo3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listOne = listOf(" + 2 - ", " - 2x + ")
    val listTwo = listOf(" - 2 + ", " - 2x +")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        forTitleorBtn(textForTitle = stringResource(id = R.string.Box7C4_Desa))
        SpaceH()
        ImageAnimation(
            userStateVM,
            painterD =  R.drawable.ejer_producnota_nine_dark,
            painterL =  R.drawable.ejer_producnota_nine_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = "x",
                        exponenOne = "3",
                        next = s,
                        baseTwo = "x",
                        exponenTwo = ""
                    )
                }
            }
        }
        Row(modifier = recycleModi) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = "x",
                        exponenOne = "3",
                        next = s,
                        baseTwo = "x",
                        exponenTwo = if (index == 0) "" else "-1"
                    )
                }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseProducNotaTwo4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaTwo4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseProducNotaTwo4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf(" + y", " - y")
    val listTwo = listOf(" - 2xy + ", " + 2xy + ")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        FormulaDiferenciaCuadrados()
        bodyLarge(
            text = stringResource(id = R.string.Box1C4Notables_apliformu),
            modifier = Modifier
        )
        SpaceH()
        bodyLarge(text = "(x - y)(x + y)", modifier = Modifier.align(Alignment.CenterHorizontally))
        SpaceH()
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { 
                    DiferenciaCuadrados(
                        baseOne = "x",
                        exponenteOne = "2",
                        baseTwo = s,
                        exponenTwo = "2"
                    )
                }
            }
        }
        Row(modifier = recycleModi) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { 
                    ExponenteCuadrado(
                        baseOne = "x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "y",
                        exponenTwo = "2"
                    )
                }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseProducNotaTwo5(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaTwo5(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseProducNotaTwo5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf(" - 9y", " + 9y")
    val listTwo = listOf(" - 3y", " - 6y")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        forTitleorBtn(textForTitle = stringResource(id = R.string.Box7C4_Desa))
        SpaceH()
        bodyLarge(
            text = "(5x - 3y)(5x + 3y) = ",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    DiferenciaCuadrados(
                        baseOne = "25x",
                        exponenteOne = "2",
                        baseTwo = s,
                        exponenTwo = "2"
                    )
                }
            }
        }
        Row(modifier = recycleModi) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    DiferenciaCuadrados(
                        baseOne = "5x",
                        exponenteOne = "2",
                        baseTwo = s,
                        exponenTwo = "2"
                    )
                }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseProducNotaTwo6(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaTwo6(navController, topicVM) }
    }
}

@Composable
private fun ExerciseProducNotaTwo6(navController: NavController, topicVM: TopicVM) {

    val listOne = listOf(" - 4", " + 2")
    val listTwo = listOf(" - 2", " - 4")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkFinishInt(4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box7C4_Desa), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "(-x - 2)(-x + 2) = ", modifier = Modifier.align(Alignment.CenterHorizontally))
        SpaceH()
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    DiferenciaCuadrados(baseOne = "2x", exponenteOne = if(index == 0)"" else "2", baseTwo = s, exponenTwo = "")
                }
            }
        }
        Row(modifier = recycleModi) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    DiferenciaCuadrados(
                        baseOne = "x",
                        exponenteOne = "2",
                        baseTwo = s,
                        exponenTwo = ""
                    )
                }
            }
        }
        btnNextTopic(
            onClick = { check() },
            topicVM,
            navController,
            destination = AppScreens.producNotaThree
        )
    }
}