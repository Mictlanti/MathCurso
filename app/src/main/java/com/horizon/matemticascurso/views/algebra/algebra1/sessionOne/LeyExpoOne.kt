@file:OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)

package com.horizon.matemticascurso.views.algebra.algebra1.sessionOne

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.By
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.CardExample
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.SignDivi
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.SpecialExponent
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.ExceptionBody
import com.horizon.matemticascurso.views.components.ExceptionTitle
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnExample
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LeyExpoOneScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 10 })
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val modifier = Modifier.fillMaxSize()
    val showExample = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "ley de exponentes session1", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Ley de exponentes",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExampleLeyExpoOne1(modifier, pagerState, nextPage, scope)
                1 -> LazyExerciseLeyExpoOne1(pagerState, modifier, topicVM, scope)
                2 -> LazyExerciseLeyExpoOne2(
                    modifier = modifier,
                    pagerState,
                    topicVM, scope
                )

                3 -> LazyExerciseLeyExpoOne3(
                    modifier = modifier,
                    pagerState,
                    topicVM, scope
                )

                4 -> LazyExerciseLeyExpoOne4(
                    modifier = modifier,
                    pagerState,
                    topicVM, scope
                )

                5 -> LazyExerciseLeyExpoOne5(
                    modifier = modifier,
                    pagerState,
                    topicVM, scope
                )

                6 -> LazyExerciseLeyExpoOne6(
                    modifier = modifier,
                    pagerState,
                    topicVM, scope
                )

                7 -> LazyExerciseLeyExpoOne7(
                    modifier = modifier,
                    pagerState,
                    topicVM,
                    scope,
                    userStateVM
                )

                8 -> LazyExerciseLeyExpoOne8(modifier, pagerState, topicVM, scope)
                9 -> LazyExerciseLeyExpoOne9(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 10,
        spaceByBoxes = 8.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExampleLeyExpoOne1(
    modifier: Modifier,
    pagerState: PagerState,
    nextPage: Int,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExampleLeyExpoOne1(pagerState, nextPage, scope) }
    }
}

@Composable
private fun ExampleLeyExpoOne1(pagerState: PagerState, nextPage: Int, scope: CoroutineScope) {

    val listExpo = listOf("m", "n", "m + n")

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val alignment = Modifier.align(Alignment.CenterHorizontally)
        Spacer(modifier = Modifier.height(20.dp))
        bodyMedium(text = stringResource(id = R.string.Box1A3_one), modifier = alignment)
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary)
        ) {
            Column(
                modifier = Modifier.padding(all = 15.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                ExceptionTitle(title = stringResource(id = R.string.Box1A3_two))
                ExceptionBody(body = stringResource(id = R.string.Box1A3_three))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    listExpo.forEachIndexed { index, s ->
                        Exponente(
                            base = "a",
                            exponente = s,
                            modifier = Modifier
                        )
                        if (index == 1) bodyLarge(
                            text = " = ",
                            modifier = Modifier
                        ) else if (index == 0) By()
                    }
                }
            }
        }
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
}

@Composable
fun LazyExerciseLeyExpoOne1(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoOne1(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseLeyExpoOne1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listExpo = listOf("2", "3", "2 + 3", "5")
    val listOne = listOf("5", "4")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.desarrollo))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = recycleModi
        ) {
            listExpo.forEachIndexed { index, s ->
                Exponente(base = "a", exponente = s, modifier = Modifier)
                if (index == 0) By() else if (index == 1) bodyLarge(
                    text = " = ",
                    modifier = Modifier
                ) else if (index == 2) bodyLarge(
                    text = " = ",
                    modifier = Modifier
                )
            }
        }
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        SpaceH()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            val sndlist = listOf("", "4")
            sndlist.forEachIndexed { index, s ->
                Exponente(base = "a", exponente = s, modifier = Modifier)
                if (index == 0) By() else if (index == 1) bodyLarge(
                    text = " = ",
                    modifier = Modifier
                )
            }
        }
        SpaceH()
        Row {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { Exponente(base = "a", exponente = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseLeyExpoOne2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoOne2(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseLeyExpoOne2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAns = listOf("3", "4")
    val listOne = listOf("7", "12")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        SpaceH()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = recycleModi
        ) {
            listAns.forEachIndexed { index, s ->
                Exponente(
                    base = "x",
                    exponente = s,
                    modifier = Modifier
                )
                if (index == 0) By() else if (index == 1) bodyLarge(
                    text = " = ",
                    modifier = Modifier
                )
            }
        }
        SpaceH()
        Row {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { Exponente(base = "x", exponente = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseLeyExpoOne3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoOne3(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseLeyExpoOne3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("-24", "2")
    val listAns = listOf("-4", "3", "2")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = recycleModi
        ) {
            listAns.forEachIndexed { index, s ->
                Exponente(base = "s", exponente = s, modifier = Modifier)
                if (index == 2) bodyLarge(text = " = ", modifier = Modifier) else By()
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { Exponente(base = "s", exponente = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseLeyExpoOne4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoOne4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseLeyExpoOne4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("-7", "-1")
    val listTwo = listOf("-5", "-12")
    val listAns = listOf("m", "n", "m - n")
    val sndListAns = listOf("-4", "3")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        CardExample(
            titleRes = R.string.Box1A3_four,
            bodyRes = R.string.Box1A3_five,
            formula = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = recycleModi
                ) {
                    listAns.forEachIndexed { index, s ->
                        Exponente(base = "a", exponente = "s", modifier = Modifier)
                        if (index == 0) SignDivi() else if (index == 1) bodyLarge(
                            text = " = ",
                            modifier = Modifier

                        )
                    }
                }
            }
        )
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        Row(
            modifier = recycleModi,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            sndListAns.forEachIndexed { index, s ->
                Exponente(
                    base = "s",
                    exponente = s,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                if (index == 0) SignDivi() else bodyLarge(text = " = ", modifier = Modifier)
            }
        }
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { Exponente(base = "s", exponente = s, modifier = Modifier) }
            }
        }
        Row(modifier = recycleModi) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { Exponente(base = "s", exponente = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseLeyExpoOne5(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoOne5(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseLeyExpoOne5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("3", "6")
    val listAns = listOf("9", "3")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        SpaceH()
        Row(
            modifier = recycleModi,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            listAns.forEachIndexed { index, s ->
                Exponente(base = "y", exponente = s, modifier = Modifier)
                if (index == 0) SignDivi() else bodyLarge(text = " = ", modifier = Modifier)
            }
        }
        SpaceH()
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { Exponente(base = "y", exponente = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseLeyExpoOne6(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoOne6(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseLeyExpoOne6(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("0", "x")
    val listAns = listOf("2", "3", "")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        SpaceH()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = recycleModi
        ) {
            listAns.forEachIndexed { index, s ->
                Exponente(base = "x", exponente = s, modifier = Modifier)
                if (index == 0) SignDivi() else if (index == 1) By() else bodyLarge(
                    text = " = ",
                    modifier = Modifier
                )
            }
        }
        SpaceH()
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
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
fun LazyExerciseLeyExpoOne7(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoOne7(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseLeyExpoOne7(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listOne = listOf("8", "6")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        CardExample(
            titleRes = R.string.Box1A3_six,
            bodyRes = R.string.Box1A3_seven,
            formula = {
                ImageAnimation(
                    userStateVM,
                    painterD = R.drawable.ejem_leyexpo_producpotencia_dark,
                    painterL = R.drawable.ejem_leyexpo_producpotencia_light,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        )
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        SpecialExponent(base = "x", exponente = "2", sndExponent = "3")
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { Exponente(base = "x", exponente = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseLeyExpoOne8(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoOne8(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseLeyExpoOne8(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("6", "8")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        SpaceH()
        SpecialExponent(base = "x", exponente = "4", sndExponent = "2")
        SpaceH()
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { Exponente(base = "x", exponente = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseLeyExpoOne9(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseLeyExpoOne9(navController, topicVM) }
    }
}

@Composable
fun ExerciseLeyExpoOne9(navController: NavController, topicVM: TopicVM) {

    val listOne = listOf("7", "")
    val listOneOne = listOf("8", "25")
    val listTwo = listOf("2", "10")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkFinishInt(4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2A3_one), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        SpecialExponent(
            base = "x",
            exponente = "2",
            sndExponent = "3",
            secondExpo = true,
            otherB = "y",
            otherE = "3"
        )
        SpaceH()
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) {
                    Row {
                        Exponente(base = "x", exponente = s, modifier = Modifier)
                        Exponente(base = "y", exponente = listOneOne[index], modifier = Modifier)
                    }
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
                    Row {
                        Exponente(base = "x", exponente = s, modifier = Modifier)
                        Exponente(base = "y", exponente = "10", modifier = Modifier)
                    }
                }
            }
        }
        btnNextTopic(
            onClick = { check() },
            topicVM,
            navController,
            destination = AppScreens.leyExpoTwo
        )
    }
}