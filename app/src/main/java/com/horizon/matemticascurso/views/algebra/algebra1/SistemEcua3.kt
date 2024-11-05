@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1

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
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forBodyorExercise
import com.horizon.matemticascurso.views.components.forTitleorBtn
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.ui.theme.colorAlpha_dark
import com.horizon.matemticascurso.ui.theme.md_theme_dark_errorContainer
import com.horizon.matemticascurso.views.components.UnavailableScreen
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SistemEcua3ScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 6 })
    val showExample = remember { mutableStateOf(false) }
    val nextPage = (pagerState.currentPage+1).coerceIn(0, pagerState.pageCount-1)

    TopBarTopics(
        navController,
        titleTopBar = "Sistema de ecuaciones",
        topicVM,
        pageContent = { UnavailableScreen() },
        pagerState,
        repeatBoxes = 6,
        spaceByBoxes = 45.dp,
        showExample = {  }
    )
}

@Composable
fun LazyColumnBoxC(modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { BoxC() }
    }
}

@Composable
fun BoxC() {
    Column(modifier = Modifier.fillMaxSize()) {
        forBodyorExercise(body = stringResource(id = R.string.Box1C4_one))
        Image(
            painter = painterResource(id = R.drawable.ejem_sistemecuathree_one),
            contentDescription = "Image",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(40.dp))
        forTitleorBtn(textForTitle =  stringResource(id = R.string.Box1C4_two))
    }
}

@Composable
fun LazyColumnBox2C(modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box2C() }
    }
}

@Composable
fun Box2C() {
    Column(modifier = Modifier.fillMaxSize()) {
        titleMedium(text = stringResource(id = R.string.Box2C4_one))
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.ejem_sistemecuathree_two),
            contentDescription = "Image",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        forTitleorBtn(textForTitle = stringResource(id = R.string.Box2C4_two))
        Spacer(modifier = Modifier.height(10.dp))
        forBodyorExercise(body = stringResource(id = R.string.Box2C4_three))
        Image(
            painter = painterResource(id = R.drawable.ejem_sistemecuathree_three),
            contentDescription = "Image",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        forBodyorExercise(body = stringResource(id = R.string.Box2C4_four))
        Image(
            painter = painterResource(id = R.drawable.ejem_sistemecuathree_four),
            contentDescription = "Image",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        forBodyorExercise(body = stringResource(id = R.string.Box2C4_five))
    }
}

@Composable
fun Box3C(pagerState: PagerState, nextPage: Int) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val IfCorrect = remember { mutableStateOf(false) }
    val IfIncorrect = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.padding(bottom = 120.dp)) {
            Column {
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box3C4_one))
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_sistemecuathree_one),
                    contentDescription = "Image",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
        Row {
            Button(
                onClick = { Button1.value = !Button1.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button1.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button2.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                forTitleorBtn(textForTitle = "(x,y,z)=(5,1,-6)")
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
                forTitleorBtn(textForTitle = "(x,y,z)=(-2,1, 3)")
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
                forTitleorBtn(textForTitle = "(x,y,z) = (5,4,3)")
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
                forTitleorBtn(textForTitle = "(x,y,z)=(-5,4,6)")
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
fun LazyColumnBox4C(pagerState: PagerState, nextPage: Int, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { Box4C(pagerState, nextPage) }
    }
}

@Composable
fun Box4C(pagerState: PagerState, nextPage: Int) {

    val ButtonV = remember { mutableStateOf(false) }
    val ButtonF = remember { mutableStateOf(false) }
    val ColorIncorrect = remember { mutableStateOf(false) }
    val ColorCorrect = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column {
        Box {
            Column {
                titleMedium(text =  stringResource(id = R.string.VoF))
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_sistemecuathree_two),
                    contentDescription = "Image",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
        Row(modifier = Modifier.padding(top = 20.dp)) {
            Button(
                onClick = { ButtonV.value = !ButtonV.value },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (ButtonV.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (ButtonV.value) 10.dp else 0.dp),
                enabled = !ButtonF.value && !ColorCorrect.value && !ColorIncorrect.value
            ) {
                forTitleorBtn(textForTitle = "Verdadero")
            }
            Button(
                onClick = { ButtonF.value = !ButtonF.value },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (ButtonF.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (ButtonF.value) 10.dp else 0.dp),
                enabled = !ButtonV.value && !ColorCorrect.value && !ColorIncorrect.value
            ) {
                forTitleorBtn(textForTitle = "Falso")
            }
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    when {
                        ButtonF.value -> ColorIncorrect.value = !ColorIncorrect.value
                        ButtonV.value -> {
                            ColorCorrect.value = !ColorCorrect.value
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
                        ColorIncorrect.value -> md_theme_dark_errorContainer
                        ColorCorrect.value -> Color.Green
                        else -> colorAlpha_dark
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                titleMedium(
                    text = when {
                        ColorIncorrect.value -> "Sigue intentando"
                        ColorCorrect.value -> "¡Bien hecho!"
                        else -> "Compueba la respuesta"
                    }
                )
            }
        }
    }
}

@Composable
fun Box5C(pagerState: PagerState, nextPage: Int) {

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
                forTitleorBtn(textForTitle = stringResource(id = R.string.Box5C4_one))
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.ejer_sistemecuathree_three),
                    contentDescription = "Image",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
        Row(modifier = Modifier.padding(top = 40.dp)) {
            Button(
                onClick = { Button1.value = !Button1.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button1.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button2.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                forBodyorExercise(body = "A)(x,y,z)=(3,3,2)\n" +
                        "B)(x,y,z)=(1,-2,1)")
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
                forBodyorExercise(body = "A)(x,y,z)=(3,1,1)\n" +
                        "B)(x,y,z)=(2,5,3)")
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
                forBodyorExercise(body = "A)(x,y,z)=(-1,0,1)\n" +
                        "B)(x,y,z)=(-2,0,6)")
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
                forBodyorExercise(body = "A)(x,y,z)=(3,2,-1)\n" +
                        "B)(x,y,z)=(2,5,3)")
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

/*@Composable
fun LazyColumnBox6C(modifier: Modifier, navController: NavController){
    LazyColumn(modifier = modifier) {
        item { Box6C(navController) }
    }
}

@Composable
fun Box6C(navController: NavController) {

    val ButtonV = remember { mutableStateOf(false) }
    val ButtonF = remember { mutableStateOf(false) }
    val ColorIncorrect = remember { mutableStateOf(false) }
    val ColorCorrect = remember { mutableStateOf(false) }
    fun scroll(){
        when {
            ButtonF.value -> ColorIncorrect.value = !ColorIncorrect.value
            ButtonV.value -> ColorCorrect.value = !ColorCorrect.value
        }
    }

    Column {
        Box {
            Column {
                titleMedium(text = stringResource(id = R.string.VoF))
                Image(
                    painter = painterResource(id = R.drawable.ejer_sistemecuathree_four),
                    contentDescription = "Image",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
        Row(modifier = Modifier.padding(top = 20.dp)) {
            Button(
                onClick = { ButtonV.value = !ButtonV.value },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (ButtonV.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (ButtonV.value) 10.dp else 0.dp),
                enabled = !ButtonF.value && !ColorCorrect.value && !ColorIncorrect.value
            ) {
                forTitleorBtn(textForTitle = "Verdadero")
            }
            Button(
                onClick = { ButtonF.value = !ButtonF.value },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (ButtonF.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (ButtonF.value) 10.dp else 0.dp),
                enabled = !ButtonV.value && !ColorIncorrect.value && !ColorCorrect.value
            ) {
                forBodyorExercise(body = "Falso")
            }
        }
        btnNextTopic(
            ifCorrect = ColorCorrect.value,
            ifIncorrect = ColorIncorrect.value,
            onClick = { scroll() },
            navController,
            destination = AppScreens.desarrolloPoli
        )
    }
} */