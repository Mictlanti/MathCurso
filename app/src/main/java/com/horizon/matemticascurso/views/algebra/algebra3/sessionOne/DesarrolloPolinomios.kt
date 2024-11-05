@file:OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)

package com.horizon.matemticascurso.views.algebra.algebra3.sessionOne

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.views.components.ExceptionBody
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
fun DesaPolinoScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 6 })
    val nextPage = (pagerState.currentPage+1).coerceIn(0,pagerState.pageCount-1)
    val showExample = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "Desarrollo poli", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Desarrollo polinomios",
        topicVM,
        pageContent = { UnavailableScreen() },
        pagerState,
        repeatBoxes = 6,
        spaceByBoxes = 50.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun Box1E4(pagerState: PagerState, nextPage: Int) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val IfCorrect = remember { mutableStateOf(false) }
    val IfIncorrect = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        forTitleorBtn(textForTitle = stringResource(id = R.string.Box1E4_one))
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.ejer_desapolino_one),
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
                Image(
                    painter = painterResource(id = R.drawable.btnone_desapolino_f),
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
                    painter = painterResource(id = R.drawable.btnone_desapolino_fal),
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
                    painter = painterResource(id = R.drawable.btnone_desapolino_v),
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
                    painter = painterResource(id = R.drawable.btnone_desapolino_false),
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
                        Button3.value -> {
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
fun LazyColumnBox2E4(pagerState: PagerState, nextPage: Int, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box2E4(pagerState, nextPage) }
    }
}

@Composable
fun Box2E4(pagerState: PagerState, nextPage: Int) {

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
                titleMedium(text = stringResource(id = R.string.desarrollo))
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejem_desapolino_one),
                    contentDescription = "Image"
                )
                Spacer(modifier = Modifier.height(20.dp))
                forTitleorBtn(textForTitle = stringResource(id = R.string.Procedimiento))
                Spacer(modifier = Modifier.height(10.dp))
                forBodyorExercise(body = stringResource(id = R.string.Box2E4_one))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejem_desapolino_two),
                    contentDescription = "Image"
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(id = R.string.Box2E4_two),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(25.dp))
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box1E4_one))
                Image(
                    painter = painterResource(id = R.drawable.ejer_desapolino_two),
                    contentDescription = "Image"
                )
            }
        }
        Row(modifier = Modifier.padding(top = 25.dp)) {
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
                    painter = painterResource(id = R.drawable.btntwo_desapolino_f),
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
                    painter = painterResource(id = R.drawable.btntwo_desapolino_fal),
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
                    painter = painterResource(id = R.drawable.btntwo_desapolino_false),
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
                    painter = painterResource(id = R.drawable.btntwo_desapolino_v),
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
fun Box3E4(pagerState: PagerState, nextPage: Int) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val IfCorrect = remember { mutableStateOf(false) }
    val IfIncorrect = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        forTitleorBtn(textForTitle = stringResource(id = R.string.Box3E4))
        Spacer(modifier = Modifier.height(15.dp))
        Card(colors = CardDefaults.cardColors(containerColor = Color1)) {
            Column(modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp)) {
                ExceptionBody(body = stringResource(id = R.string.Box3E4_one))
                Spacer(modifier = Modifier.height(5.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejem_desapolino_three),
                    contentDescription = "Image"
                )
            }
        }
        Box(modifier = Modifier.padding(top = 30.dp)) {
            Column {
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box1E4_two))
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_desapolino_three),
                    contentDescription = "Image",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
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
                Image(
                    painter = painterResource(id = R.drawable.btnthree_desapolino_f),
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
                    painter = painterResource(id = R.drawable.btnthree_desapolino_fal),
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
                    painter = painterResource(id = R.drawable.btnthree_desapolino_false),
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
                    painter = painterResource(id = R.drawable.btnthree_desapolino_v),
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
fun LazyColumnBox4E4(pagerState: PagerState, nextPage: Int, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box4E4(pagerState, nextPage) }
    }
}

@Composable
fun Box4E4(pagerState: PagerState, nextPage: Int) {

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
                titleMedium(text =  stringResource(id = R.string.desarrollo))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejem_desapolino_four),
                    contentDescription = "Image"
                )
                forTitleorBtn(textForTitle =  stringResource(id = R.string.desarrollo))
                Spacer(modifier = Modifier.height(10.dp))
                forBodyorExercise(body = stringResource(id = R.string.Box4E4_one))
                Image(
                    painter = painterResource(id = R.drawable.formu_producnotatwo_one),
                    contentDescription = "Image",
                )
            }
        }
        Box(modifier = Modifier.padding(top = 20.dp)) {
            Column {
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box1E4_two))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_desapolino_four),
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
                    painter = painterResource(id = R.drawable.btnfour_desapolino_v),
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
                    painter = painterResource(id = R.drawable.btnfour_desapolino_f),
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
                    painter = painterResource(id = R.drawable.btnfour_desapolino_fal),
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
                    painter = painterResource(id = R.drawable.btnfour_desapolino_false),
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
fun LazyColumnBox5E4(pagerState: PagerState, nextPage: Int, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box5E4(pagerState, nextPage) }
    }
}

@Composable
fun Box5E4(pagerState: PagerState, nextPage: Int) {

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
                titleMedium(text = stringResource(id = R.string.desarrollo))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejem_desapolino_five),
                    contentDescription = "Image"
                )
                forTitleorBtn(textForTitle = stringResource(id = R.string.Procedimiento))
                Spacer(modifier = Modifier.height(10.dp))
                forBodyorExercise(body = stringResource(id = R.string.Box4E4_one))
                Image(
                    painter = painterResource(id = R.drawable.ejem_producnotatwo_one),
                    contentDescription = "Image",
                )
            }
        }
        Box(modifier = Modifier.padding(top = 20.dp)) {
            Column {
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box1E4_two))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_desapolino_five),
                    contentDescription = "Image"
                )
            }
        }
        Box(modifier = Modifier.padding(top = 30.dp)) {
            Column {
                Button(
                    onClick = { Button1.value = !Button1.value },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (Button1.value) Color.Magenta else colorAlpha_dark
                    ),
                    enabled = !Button2.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value,
                    elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.btnfive_desapolino_f),
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
                        .padding(top = 5.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.btnfive_desapolino_fal),
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
                        .padding(top = 5.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.btnfive_desapolino_v),
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
                        .padding(top = 5.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.btnfive_desapolino_false),
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
                        Button2.value -> IfIncorrect.value = !IfIncorrect.value
                        Button3.value -> {
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
fun Box6E4() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Box {
            Column {
                Text(
                    text = stringResource(id = R.string.finCurso1),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = stringResource(id = R.string.finCurso2),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = stringResource(id = R.string.finCurso3),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}