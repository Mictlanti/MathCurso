@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge2

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forBodyorExercise
import com.horizon.matemticascurso.views.components.forTitleorBtn
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.ui.theme.Color1
import com.horizon.matemticascurso.ui.theme.Color2
import com.horizon.matemticascurso.ui.theme.colorAlpha_dark
import com.horizon.matemticascurso.ui.theme.md_theme_dark_errorContainer
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EcuaLinealesScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 6 })
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val showExample = remember { mutableStateOf(false) }

    analyticsTrackScreen(name = "ecuaciones lineales", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Ecuaciones lineales",
        topicVM,
        pageContent = {
            /*when (page) {
                0 -> LazyHorizontalBox1B3(modifier = Modifier.fillMaxSize())
                1 -> LazyColumnBox2B3(pagerState, nextPage, modifier = Modifier.fillMaxSize())
                2 -> LazyColumnBox3B3(pagerState, nextPage, modifier = Modifier.fillMaxSize())
                3 -> LazyColumnBox4B3(modifier = Modifier.fillMaxSize())
                4 -> LazyColumnBox5B3(pagerState, nextPage, modifier = Modifier.fillMaxSize())
                5 -> LazyColumnBox6B3(modifier = Modifier.fillMaxSize(), navController)
            } */
        },
        pagerState,
        repeatBoxes = 6,
        spaceByBoxes = 30.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyHorizontalBox1B3(modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box1B3() }
    }
}

@Composable
fun Box1B3() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.padding(bottom = 10.dp)) {
            Column {
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box1B2_zero))
                Spacer(modifier = Modifier.height(10.dp))
                forBodyorExercise(body = stringResource(id = R.string.Box1B2_one))
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejem_ecuali_one),
                    contentDescription = "Image one",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                forBodyorExercise(body = stringResource(id = R.string.Box1B2_two))
                Spacer(modifier = Modifier.height(10.dp))
                Card(colors = CardDefaults.cardColors(containerColor = Color1)) {
                    Text(text = buildAnnotatedString {
                        withStyle(
                            SpanStyle(
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Italic,
                                fontSize = 18.sp,
                                letterSpacing = 1.5.sp,
                                color = Color2
                            )
                        ) { append("Las ecuaciones lineales son las ecuaciones más básicas del álgebra. Tienen la forma ax + b = 0, donde ") }
                        withStyle(
                            SpanStyle(
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Italic,
                                fontSize = 23.sp,
                                letterSpacing = 1.5.sp,
                                color = Color2
                            )
                        ) { append("a y b son números reales y a es diferente de 0.") }
                    }, modifier = Modifier.padding(5.dp))
                }
                Image(
                    painter = painterResource(id = R.drawable.ejem_ecuali_two),
                    contentDescription = "Ejemplo 2"
                )
            }
        }
    }
}

@Composable
fun LazyColumnBox2B3(pagerState: PagerState, nextPage: Int, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box2B3(pagerState, nextPage) }
    }
}

@Composable
fun Box2B3(pagerState: PagerState, nextPage: Int) {

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
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box2B2_one))
                Spacer(modifier = Modifier.height(25.dp))
                forBodyorExercise(body = stringResource(id = R.string.Box2B2_two))
            }
        }
        Row(modifier = Modifier.padding(top = 70.dp)) {
            Button(
                onClick = { Button1.value = !Button1.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button1.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f),
                enabled = !Button2.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value
            ) {
                forTitleorBtn(textForTitle = "a) x = 6\n\nb) x = 0")
            }
            Button(
                onClick = { Button2.value = !Button2.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button2.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button2.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f),
                enabled = !Button1.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value
            ) {
                forBodyorExercise(body = "a) x = 3\n\nb) x = 2")
            }
        }
        Row(modifier = Modifier.padding(vertical = 5.dp)) {
            Button(
                onClick = { Button3.value = !Button3.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button3.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button3.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f),
                enabled = !Button2.value && !Button1.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value
            ) {
                forBodyorExercise(
                    body = "a) x = 7\n\n" +
                            "b) x = 10"
                )
            }
            Button(
                onClick = { Button4.value = !Button4.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button4.value)  Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button4.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f),
                enabled = !Button1.value && !Button3.value && !Button2.value && !IfCorrect.value && !IfIncorrect.value
            ) {
                forTitleorBtn(
                    textForTitle = "a) x = 6\n\n" +
                            "b) x = 6"
                )
            }
        }
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
                    IfCorrect.value -> Color.Green
                    IfIncorrect.value -> md_theme_dark_errorContainer
                    else -> colorAlpha_dark
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

@Composable
fun LazyColumnBox3B3(pagerState: PagerState, nextPage: Int, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box3B3(pagerState, nextPage) }
    }
}

@Composable
fun Box3B3(pagerState: PagerState, nextPage: Int) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val False = remember { mutableStateOf(false) }
    val True = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            Column {
                titleMedium(text = stringResource(id = R.string.VoF))
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_ecuali_one),
                    contentDescription = "Ejercicio 1"
                )
            }
        }
        Row(modifier = Modifier.padding(top = 120.dp)) {
            Button(
                onClick = { Button1.value = !Button1.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button1.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                enabled = !Button2.value && !True.value && !False.value,
                modifier = Modifier.weight(1f)
            ) {
                forTitleorBtn(textForTitle = "Verdadero")
            }
            Button(
                onClick = { Button2.value = !Button2.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button2.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button2.value) 10.dp else 0.dp),
                enabled = !Button1.value && !True.value && !False.value,
                modifier = Modifier.weight(1f)
            ) {
                forTitleorBtn(textForTitle = "Falso")
            }
        }
        Button(
            onClick = {
                when {
                    Button1.value -> False.value = !False.value
                    Button2.value -> {
                        True.value = !True.value
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
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor =
                when {
                    False.value -> md_theme_dark_errorContainer
                    True.value -> Color.Green
                    else -> colorAlpha_dark
                }
            ),
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
        ) {
            titleMedium(
                text = when {
                    False.value -> "Intentalo nuevamente"
                    True.value -> "¡Bien hecho!"
                    else -> "Comprueba tu respuesta"
                }
            )
        }
    }
}

@Composable
fun LazyColumnBox4B3(modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box4B3() }
    }
}

@Composable
fun Box4B3() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            Column {
                forBodyorExercise(body = stringResource(id = R.string.Box4B2_one))
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejem_ecuali_three),
                    contentDescription = "Ejemplo dos",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(15.dp))
                forBodyorExercise(body = stringResource(id = R.string.Box4B2_two))
            }
        }
    }
}

@Composable
fun LazyColumnBox5B3(pagerState: PagerState, nextPage: Int, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box5B3(pagerState, nextPage) }
    }
}

@Composable
fun Box5B3(pagerState: PagerState, nextPage: Int) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val ButtonV = remember { mutableStateOf(false) }
    val ButtonF = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.padding(bottom = 40.dp)) {
            Column {
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box5B2_one))
                Image(
                    painter = painterResource(id = R.drawable.ejer_ecuali_two),
                    contentDescription = "Ejercicio 2",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 30.dp, top = 20.dp)
                )
                forBodyorExercise(body = stringResource(id = R.string.Box5B2_two))
            }
        }
        Row(modifier = Modifier.padding(bottom = 5.dp)) {
            Button(
                onClick = { Button1.value = !Button1.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button1.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                enabled = !Button2.value && !Button3.value && !Button4.value && !ButtonF.value && !ButtonV.value,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.res_ecuali_two_one),
                    contentDescription = "Respuesta1"
                )
            }
            Button(
                onClick = { Button2.value = !Button2.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button2.value)  Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button2.value) 10.dp else 0.dp),
                enabled = !Button1.value && !Button3.value && !Button4.value && !ButtonF.value && !ButtonV.value,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.res_ecuali_two_two),
                    contentDescription = "Respuesta1"
                )
            }
        }
        Row(modifier = Modifier.padding(bottom = 5.dp)) {
            Button(
                onClick = { Button3.value = !Button3.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button3.value)  Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button3.value) 10.dp else 0.dp),
                enabled = !Button2.value && !Button1.value && !Button4.value && !ButtonF.value && !ButtonV.value,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.res_ecuali_two_three),
                    contentDescription = "Respuesta1"
                )
            }
            Button(
                onClick = { Button4.value = !Button4.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button4.value)  Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button4.value) 10.dp else 0.dp),
                enabled = !Button1.value && !Button3.value && !Button2.value && !ButtonF.value && !ButtonV.value,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.res_ecuali_two_four),
                    contentDescription = "Respuesta1"
                )
            }
        }
        Button(
            onClick = {
                when {
                    Button1.value -> {
                        ButtonV.value = !ButtonV.value
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
                    Button2.value -> ButtonF.value = !ButtonF.value
                    Button3.value -> ButtonF.value = !ButtonF.value
                    Button4.value -> ButtonF.value = !ButtonF.value
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = when {
                    ButtonV.value -> Color.Green
                    ButtonF.value -> md_theme_dark_errorContainer
                    else -> colorAlpha_dark
                }
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            titleMedium(
                text = when {
                    ButtonF.value -> "Intentalo nuevamente"
                    ButtonV.value -> "¡Bien hecho!"
                    else -> "Comprueba tu respesta"
                }
            )
        }
    }
}

/*@Composable
fun LazyColumnBox6B3(modifier: Modifier, navController: NavController) {
    LazyColumn(modifier = modifier) {
        item { Box6B3(navController) }
    }
}

@Composable
fun Box6B3(navController: NavController) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val ButtonV = remember { mutableStateOf(false) }
    val ButtonF = remember { mutableStateOf(false) }
    fun scroll() { when {
            Button1.value -> ButtonF.value = !ButtonF.value
            Button2.value -> ButtonF.value = !ButtonF.value
            Button3.value -> {
                ButtonV.value = !ButtonV.value
            }
            Button4.value -> ButtonF.value = !ButtonF.value
        } }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.padding(bottom = 60.dp)) {
            Column {
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box6B2_one))
                Spacer(modifier = Modifier.height(25.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_ecuali_three),
                    contentDescription = "Ejercicio 3",
                )
            }
        }
        Row(modifier = Modifier.padding(bottom = 10.dp)) {
            Button(
                onClick = { Button1.value = !Button1.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button1.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                enabled = !Button2.value && !Button3.value && !Button4.value && !ButtonF.value && !ButtonV.value,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.res_ecuali_three_one),
                    contentDescription = "Respuesta1"
                )
            }
            Button(
                onClick = { Button2.value = !Button2.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button2.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button2.value) 10.dp else 0.dp),
                enabled = !Button1.value && !Button3.value && !Button4.value && !ButtonF.value && !ButtonV.value,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.res_ecuali_three_two),
                    contentDescription = "Respuesta1"
                )
            }
        }
        Row(modifier = Modifier.padding(bottom = 10.dp)) {
            Button(
                onClick = { Button3.value = !Button3.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button3.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button3.value) 10.dp else 0.dp),
                enabled = !Button2.value && !Button1.value && !Button4.value && !ButtonF.value && !ButtonV.value,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.res_ecuali_three_three),
                    contentDescription = "Respuesta1"
                )
            }
            Button(
                onClick = { Button4.value = !Button4.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button4.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button4.value) 10.dp else 0.dp),
                enabled = !Button1.value && !Button3.value && !Button2.value && !ButtonF.value && !ButtonV.value,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.res_ecuali_three_four),
                    contentDescription = "Respuesta1"
                )
            }
        }
        btnNextTopic(
            onClick = { scroll() },
            navController,
            destination = AppScreens.facto3One
        )
    }
} */