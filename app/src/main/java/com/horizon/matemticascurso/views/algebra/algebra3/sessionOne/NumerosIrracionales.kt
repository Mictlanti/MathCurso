@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra3.sessionOne

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.horizon.matemticascurso.views.components.ExceptionBody
import com.horizon.matemticascurso.views.components.ExceptionTitle
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forBodyorExercise
import com.horizon.matemticascurso.views.components.forTitleorBtn
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.ui.theme.Color1
import com.horizon.matemticascurso.ui.theme.colorAlpha_dark
import com.horizon.matemticascurso.ui.theme.md_theme_dark_errorContainer
import com.horizon.matemticascurso.views.components.UnavailableScreen
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NumIrraScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 4 })
    val nextPage = (pagerState.currentPage+1).coerceIn(0,pagerState.pageCount-1)
    val showExample = remember { mutableStateOf(false) }

    analyticsTrackScreen(name = "numeros irraciones", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Numeros irracionales",
        topicVM,
        pageContent = { UnavailableScreen() },
        pagerState,
        repeatBoxes = 4,
        spaceByBoxes = 65.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyColumnBox1E2(pagerState: PagerState, nextPage: Int, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box1E2(pagerState, nextPage) }
    }
}

@Composable
fun Box1E2(pagerState: PagerState, nextPage: Int) {

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
                forBodyorExercise(body = stringResource(id = R.string.Box1E2_one))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejem_numirra_one),
                    contentDescription = "Image"
                )
                Spacer(modifier = Modifier.height(10.dp))
                forBodyorExercise(body = stringResource(id = R.string.Box1E2_two))
            }
        }
        Box {
            Column {
                Spacer(modifier = Modifier.height(15.dp))
                titleMedium(text = stringResource(id = R.string.desarrollo))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejem_numirra_two),
                    contentDescription = "Image"
                )
                Spacer(modifier = Modifier.height(10.dp))
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box2E1_one))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_numirra_one),
                    contentDescription = "Image"
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        Box(modifier = Modifier.padding(vertical = 10.dp)) {
            Column {
                Button(
                    onClick = { Button1.value = !Button1.value },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (Button1.value) Color.Magenta else colorAlpha_dark
                    ),
                    enabled = !Button2.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value,
                    elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.btnone_numirra_f),
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
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.btnone_numirra_v),
                        contentDescription = "Image"
                    )
                }
                Button(
                    onClick = { Button3.value = !Button3.value },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (Button3.value) Color.Magenta else colorAlpha_dark
                    ),
                    enabled = !Button1.value && !Button2.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value,
                    elevation = ButtonDefaults.buttonElevation(if (Button3.value) 10.dp else 0.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.btnone_numirra_fal),
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
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.btnone_numirra_false),
                        contentDescription = "Image"
                    )
                }
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
                        IfIncorrect.value -> md_theme_dark_errorContainer
                        IfCorrect.value -> Color.Green
                        else -> colorAlpha_dark
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                titleMedium(
                    text = when {
                        IfIncorrect.value -> "Sigue intentando"
                        IfCorrect.value -> "¡Bien hecho!"
                        else -> "Comprueba la respuesta"
                    }
                )
            }
        }
    }
}

@Composable
fun LazycolumnBox2E2(pagerState: PagerState, nextPage: Int, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box2E2(pagerState, nextPage) }
    }
}

@Composable
fun Box2E2(pagerState: PagerState, nextPage: Int) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val IfCorrect = remember { mutableStateOf(false) }
    val IfIncorrect = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column {
        Box {
            Column {
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box2E2_one))
                Spacer(modifier = Modifier.height(10.dp))
                Card(colors = CardDefaults.cardColors(containerColor = Color1)) {
                    Column(modifier = Modifier.padding(all = 5.dp)) {
                        ExceptionTitle(title = stringResource(id = R.string.Box2E2_two))
                        Spacer(modifier = Modifier.height(5.dp))
                        ExceptionBody(body = stringResource(id = R.string.Box2E2_three))
                        Spacer(modifier = Modifier.height(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ejem_numirra_three),
                            contentDescription = "Image"
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        ExceptionBody(body = stringResource(id = R.string.Box2E2_four))
                        Image(
                            painter = painterResource(id = R.drawable.ejem_numirra_four),
                            contentDescription = "Image"
                        )
                    }
                }
            }
        }
        Box {
            Column(modifier = Modifier.padding(bottom = 10.dp)) {
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box2E1_one))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_numirra_two),
                    contentDescription = "Image",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
        Row(modifier = Modifier.padding(top = 35.dp)) {
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
                    painter = painterResource(id = R.drawable.btnone_raiz_v),
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
                    painter = painterResource(id = R.drawable.btnone_raiz_f),
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
                    painter = painterResource(id = R.drawable.btnone_raiz_fal),
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
                    painter = painterResource(id = R.drawable.btnone_raiz_false),
                    contentDescription = "Image"
                )
            }
        }
        Box {
            Button(
                onClick = {
                    when {
                        Button1.value -> {
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
                        Button2.value -> IfIncorrect.value = !IfIncorrect.value
                        Button3.value -> IfIncorrect.value = !IfIncorrect.value
                        Button4.value -> IfIncorrect.value = !IfIncorrect.value
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = when {
                        IfIncorrect.value -> md_theme_dark_errorContainer
                        IfCorrect.value -> Color.Green
                        else -> colorAlpha_dark
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                titleMedium(
                    text = when {
                        IfIncorrect.value -> "Sigue intentando"
                        IfCorrect.value -> "¡Bien hecho!"
                        else -> "Comprueba la respuesta"
                    }
                )
            }
        }
    }
}

@Composable
fun Box3E2(pagerState: PagerState, nextPage: Int) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val IfCorrect = remember { mutableStateOf(false) }
    val IfIncorrect = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        titleMedium(text = stringResource(id = R.string.desarrollo))
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.ejem_numirra_five),
            contentDescription = "Image"
        )
        Spacer(modifier = Modifier.height(10.dp))
        forTitleorBtn(textForTitle = stringResource(id = R.string.Box2E1_one))
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.ejer_numirra_three),
            contentDescription = "Image"
        )
        Row(modifier = Modifier.padding(top = 55.dp)) {
            Button(
                onClick = { Button1.value = !Button1.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button1.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button2.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                forTitleorBtn(textForTitle = "A) 1\nB) -1\nC) -8")
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
                forTitleorBtn(textForTitle = "A) 0\nB) 1\nC) 8")
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
                forTitleorBtn(textForTitle = "A) 3\nB) -1\nC) 5")
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
                forTitleorBtn(textForTitle = "A) 1\nB) 5\nC) 3")
            }
        }
        Box {
            Button(
                onClick = {
                    when {
                        Button1.value -> {
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
                        Button2.value -> IfIncorrect.value = !IfIncorrect.value
                        Button3.value -> IfIncorrect.value = !IfIncorrect.value
                        Button4.value -> IfIncorrect.value = !IfIncorrect.value
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = when {
                        IfIncorrect.value -> md_theme_dark_errorContainer
                        IfCorrect.value -> Color.Green
                        else -> colorAlpha_dark
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                titleMedium(
                    text = when {
                        IfIncorrect.value -> "Sigue intentando"
                        IfCorrect.value -> "¡Bien hecho!"
                        else -> "Comprueba la respuesta"
                    }
                )
            }
        }
    }
}

/*@Composable
fun Box4E2(navController: NavController) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val IfCorrect = remember { mutableStateOf(false) }
    val IfIncorrect = remember { mutableStateOf(false) }
    fun scroll() {
        when {
            Button1.value -> IfIncorrect.value = !IfIncorrect.value
            Button2.value -> IfIncorrect.value = !IfIncorrect.value
            Button3.value -> IfIncorrect.value = !IfIncorrect.value
            Button4.value -> IfCorrect.value = !IfCorrect.value
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        forTitleorBtn(textForTitle = stringResource(id = R.string.Box2E1_one))
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.ejer_numirra_four),
            contentDescription = "Image"
        )
        Row(modifier = Modifier.padding(top = 35.dp)) {
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
                    painter = painterResource(id = R.drawable.btnfour_numirra_f),
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
                    painter = painterResource(id = R.drawable.btnfour_numirra_fal),
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
                    painter = painterResource(id = R.drawable.btnfour_numirra_false),
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
                    painter = painterResource(id = R.drawable.btnfour_numirra_v),
                    contentDescription = "Image"
                )
            }
        }
        btnNextTopic(
            onClick = { scroll() },
            toi
            navController,
            destination = AppScreens.sistemaEcua3
        )
    }
} */