@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.sessionOne

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
import androidx.compose.foundation.layout.width
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
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteCuadrado
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.SpecialExponent
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.SpecialExponenteCuadrado
import com.horizon.matemticascurso.ui.theme.Color1
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.CuadradoPerfectoNegativo
import com.horizon.matemticascurso.views.components.CuadradoPerfectoPositivo
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forBodyorExercise
import com.horizon.matemticascurso.vms.TopicVM
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProducNotaOneScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 6 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "productos notables sesion1", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Productos notables",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseProducNotaOne1(modifier, pagerState, topicVM, scope)
                1 -> LazyExerciseProducNotaOne2(modifier, pagerState, topicVM, scope)
                2 -> LazyExerciseProducNotaOne3(modifier, pagerState, topicVM, scope)
                3 -> LazyExerciseProducNotaOne4(modifier, pagerState, topicVM, scope)
                4 -> LazyExerciseProducNotaOne5(modifier, pagerState, topicVM, scope)
                5 -> LazyExerciseProducNotaOne6(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 6,
        spaceByBoxes = 30.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseProducNotaOne1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaOne1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseProducNotaOne1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnsOne = listOf("2", "")
    val listAnsTwo = listOf(" + ", " - 2")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 3)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyMedium(text = stringResource(id = R.string.Box1C4Notables_one), modifier = Modifier)
        CuadradoPerfectoPositivo()
        bodyLarge(
            text = stringResource(id = R.string.Box1C4Notables_apliformu),
            modifier = Modifier
        )
        SpaceH()
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = recycleModi
        ) {
            Exponente(base = "(x + y)", exponente = "2", modifier = Modifier)
            bodyLarge(text = " = ", modifier = Modifier)
        }
        SpaceH()
        Row(modifier = recycleModi) {
            listAnsOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { ExponenteCuadrado(
                    baseOne = s + "x",
                    exponenOne = "2",
                    next = if(index == 0) " + 2xy" else " - 2xy",
                    baseTwo = " + 2y",
                    exponenTwo = "2",
                    fontSize = 18.sp
                ) }
            }
        }
        Row(modifier = recycleModi) {
            listAnsTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { ExponenteCuadrado(
                    baseOne = "x",
                    exponenOne = "2",
                    next = if(index == 0) " + 2xy + " else " - 2xy + ",
                    baseTwo = s + "y",
                    exponenTwo = "2",
                    fontSize = 20.sp
                ) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseProducNotaOne2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaOne2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseProducNotaOne2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf(" - 2ab + ", " - ab + ")
    val listTwo = listOf("- 2ab - ", "+ 2ab +")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(
            text = stringResource(id = R.string.Box1C4Notables_apliformu),
            modifier = Modifier
        )
        SpaceH()
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
        ) {
            Exponente(base = "(a + b)", exponente = "2", modifier = Modifier)
            bodyLarge(text = " = ", modifier = Modifier)
        }
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = "a",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "b",
                        exponenTwo = "2"
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
                        baseOne = "a",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "b",
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
fun LazyExerciseProducNotaOne3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaOne3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseProducNotaOne3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf(" - 4a - ", " + 4a + ")
    val listTwo = listOf(" + 4a - ", " - 4a + ")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(
            text = stringResource(id = R.string.Box1C4Notables_apliformu),
            modifier = Modifier
        )
        SpaceH()
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
        ) {
            Exponente(base = "(a + 2)", exponente = "2", modifier = Modifier)
            bodyLarge(text = " = ", modifier = Modifier)
        }
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = "a",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "4",
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
                        baseOne = "a",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "4",
                        exponenTwo = ""
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
fun LazyExerciseProducNotaOne4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaOne4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseProducNotaOne4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf(" + 2xy + ", " - 2xy - ")
    val listTwo = listOf(" - xy + ", " - 2xy + ")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        CuadradoPerfectoNegativo()
        bodyLarge(text = stringResource(id = R.string.Box4C4_Produc), modifier = Modifier)
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center
        ) {
            Exponente(base = "(a - b)", exponente = "2", modifier = Modifier)
            bodyLarge(text = " = (a - b)(a - b)", modifier = Modifier)
        }
        ExponenteCuadrado(
            baseOne = "= a",
            exponenOne = "2",
            next = " - ab - ab +",
            baseTwo = "b",
            exponenTwo = "2"
        )
        ExponenteCuadrado(baseOne = "= a", exponenOne = "2", next = " - 2ab + ", baseTwo = "b", exponenTwo = "2")
        bodyLarge(
            text = stringResource(id = R.string.Box1C4Notables_apliformu),
            modifier = Modifier
        )
        SpaceH()
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
        ) {
            Exponente(base = "(x - y)", exponente = "2", modifier = Modifier)
            bodyLarge(text = " = ", modifier = Modifier)
        }
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
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
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { ExponenteCuadrado(
                    baseOne = "x",
                    exponenOne = "2",
                    next = s,
                    baseTwo = "y",
                    exponenTwo = "2"
                ) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseProducNotaOne5(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaOne5(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseProducNotaOne5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf(" - 12x + ", " - 6x + ")
    val listTwo = listOf(" - 6x - ", " - 12x - ")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(
            text = stringResource(id = R.string.Box1C4Notables_apliformu),
            modifier = Modifier
        )
        SpaceH()
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
        ) {
            Exponente(base = "(2x - 3)", exponente = "2", modifier = Modifier)
            bodyLarge(text = " = ", modifier = Modifier)
        }
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = if (index == 0) "4x" else "2x",
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
                        baseOne = "2x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = if (index == 0) "6" else "9",
                        exponenTwo = ""
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
fun LazyExerciseProducNotaOne6(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaOne6(navController, topicVM) }
    }
}

@Composable
private fun ExerciseProducNotaOne6(navController: NavController, topicVM: TopicVM) {

    val listOne = listOf("5", "6")
    val listTwo = listOf(" + 2", " - 2")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkFinishInt(2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(
            text = stringResource(id = R.string.Box1C4Notables_apliformu),
            modifier = Modifier
        )
        SpaceH()
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
        ) {
            SpecialExponent(base = "x", exponente = "3", sndExponent = "2", secondExpo = true, otherB = " - y", otherE = "2")
            bodyLarge(text = " = ", modifier = Modifier)
        }
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    SpecialExponenteCuadrado(
                        baseOne = "x",
                        exponenOne = s,
                        baseNext = " - 2x",
                        exponenteNext = "3",
                        other = true,
                        baseOther = "y",
                        exponenteOther = "2",
                        baseTwo = " + y",
                        exponenTwo = "4",
                        fontSize = 18.sp
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
                    SpecialExponenteCuadrado(
                        baseOne = "x",
                        exponenOne = "6",
                        baseNext = if(index == 0)" - 4x" else " - 2x",
                        exponenteNext = "3",
                        other = true,
                        baseOther = "y",
                        exponenteOther = "2",
                        baseTwo = s + "y",
                        exponenTwo = "4",
                        fontSize = 18.sp
                    )
                }
            }
        }
        btnNextTopic(
            onClick = { check() },
            topicVM,
            navController,
            destination = AppScreens.producNotaTwo
        )
    }
}