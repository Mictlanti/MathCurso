@file:OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
fun RaizRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 5 })
    val nextPage = (pagerState.currentPage+1).coerceIn(0, pagerState.pageCount-1)
    val showExample = remember {mutableStateOf(false)}

    analyticsTrackScreen(name = "operaciones con raiz", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Raices",
        topicVM,
        pageContent = { UnavailableScreen() },
        pagerState,
        repeatBoxes = 5,
        spaceByBoxes = 55.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyColumnBox1E1(modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box1E1() }
    }
}

@Composable
fun Box1E1() {
    Column {
        Box {
            Column {
                forBodyorExercise(body = stringResource(id = R.string.Box1E1_one))
                Image(
                    painter = painterResource(id = R.drawable.ejem_radical_one),
                    contentDescription = "Image",
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                forBodyorExercise(body = stringResource(id = R.string.Box1E1_two))
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color1),
                    modifier = Modifier.padding(vertical = 10.dp)
                ) {
                    Column(modifier = Modifier.padding(all = 10.dp)) {
                        forBodyorExercise(body = stringResource(id = R.string.Box1E1_three))
                        Spacer(modifier = Modifier.height(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ejem_radical_two),
                            contentDescription = "Image"
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        forBodyorExercise(body = stringResource(id = R.string.Box1E1_four))
                        Spacer(modifier = Modifier.height(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ejem_radical_three),
                            contentDescription = "Image"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LazyColumnBox2E1(pagerState: PagerState, nextPage: Int, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box2E1(pagerState, nextPage) }
    }
}

@Composable
fun Box2E1(pagerState: PagerState, nextPage: Int) {

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
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box2E1_one))
                Spacer(modifier = Modifier.height(10.dp))
                titleMedium(text = stringResource(id = R.string.desarrollo))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejem_raiz_four),
                    contentDescription = "Image"
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontStyle = FontStyle.Italic,
                            color = Color.White,
                            fontWeight = FontWeight.Black,
                            fontSize = 20.sp
                        )
                    ) { append("Nota: ") }
                    withStyle(
                        SpanStyle(
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Italic,
                            fontSize = 18.sp,
                            color = Color.White,
                            letterSpacing = 1.5.sp
                        )
                    ) { append("Observa que no es posible sumar ni restar radicales con diferentes radicandos.") }
                })
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.ejer_raiz_one),
            contentDescription = "Image"
        )
        Row(modifier = Modifier.padding(top = 35.dp)) {
            Button(
                onClick = { Button1.value = !Button1.value},
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
fun LazyColumnBox3E1(pagerState: PagerState, nextPage: Int, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box3E1(pagerState, nextPage) }
    }
}

@Composable
fun Box3E1(pagerState: PagerState, nextPage: Int) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val IfCorrect = remember { mutableStateOf(false) }
    val IfIncorrect = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color1)
        ) {
            ExceptionTitle(title = stringResource(id = R.string.Box3E1_one))
            forBodyorExercise(body = stringResource(id = R.string.Box3E1_two))
            Spacer(modifier = Modifier.height(5.dp))
            Image(
                painter = painterResource(id = R.drawable.ejem_raiz_five),
                contentDescription = "Image"
            )
        }
        titleMedium(text = stringResource(id = R.string.desarrollo))
        Image(
            painter = painterResource(id = R.drawable.ejem_raiz_six),
            contentDescription = "Image"
        )
        Spacer(modifier = Modifier.height(10.dp))
        forTitleorBtn(textForTitle = stringResource(id = R.string.Box2E1_one))
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.ejer_raiz_two),
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
                    painter = painterResource(id = R.drawable.btntwo_raiz_f),
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
                    painter = painterResource(id = R.drawable.btntwo_raiz_fal),
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
                    painter = painterResource(id = R.drawable.btntwo_raiz_false),
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
                    painter = painterResource(id = R.drawable.btntwo_raiz_v),
                    contentDescription = "Image"
                )
            }
        }
        Box {
            Button(
                onClick = {
                    when {
                        Button1.value -> IfIncorrect.value = !IfIncorrect.value
                        Button2.value -> IfIncorrect.value = !IfIncorrect.value
                        Button3.value -> IfIncorrect.value = !IfIncorrect.value
                        Button4.value -> {
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
fun LazyColumnBox4E1(pagerState: PagerState, nextPage: Int, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box4E1(pagerState, nextPage) }
    }
}

@Composable
fun Box4E1(pagerState: PagerState, nextPage: Int) {

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
                forBodyorExercise(body = stringResource(id = R.string.Box4E1_one))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejem_raiz_seven),
                    contentDescription = "Image"
                )
                Spacer(modifier = Modifier.height(10.dp))
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box2E1_one))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_raiz_three),
                    contentDescription = "Image"
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
                    painter = painterResource(id = R.drawable.btnthree_raiz_f),
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
                    painter = painterResource(id = R.drawable.btnthree_raiz_v),
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
                    painter = painterResource(id = R.drawable.btnthree_raiz_fal),
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
                    painter = painterResource(id = R.drawable.btnthree_raiz_false),
                    contentDescription = "Image"
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
fun Box5E1(navController: NavController) {

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
            Button3.value -> IfCorrect.value = !IfCorrect.value
            Button4.value -> IfIncorrect.value = !IfIncorrect.value
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        forTitleorBtn(textForTitle = stringResource(id = R.string.Box5E1_one))
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.ejer_raiz_eight),
            contentDescription = "Image"
        )
        Row(modifier = Modifier.padding(top = 65.dp)) {
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
                    painter = painterResource(id = R.drawable.btneight_raiz_f),
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
                    painter = painterResource(id = R.drawable.btneight_raiz_fal),
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
                    painter = painterResource(id = R.drawable.btneight_raiz_v),
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
                    painter = painterResource(id = R.drawable.btneight_raiz_false),
                    contentDescription = "Image"
                )
            }
        }
        btnNextTopic(
            ifCorrect = IfCorrect.value,
            ifIncorrect = IfIncorrect.value,
            onClick = { scroll() },
            navController,
            destination = AppScreens.numIrracionales
        )
    }
}*/