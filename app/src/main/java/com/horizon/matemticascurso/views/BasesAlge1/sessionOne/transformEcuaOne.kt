@file:OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionOne

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
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.CardDouble
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.ui.theme.colorAlpha_dark
import com.horizon.matemticascurso.ui.theme.md_theme_dark_errorContainer
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnExample
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forBodyorExercise
import com.horizon.matemticascurso.views.components.forTitleorBtn
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun tranforScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    analyticsTrackScreen(name = "Transforma ecua", analytics = analytics)

    val pagerState = rememberPagerState(pageCount = { 6 })
    val showExample = remember { mutableStateOf(false) }
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val recycleModi = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    TopBarTopics(
        navController,
        titleTopBar = "Tranformación",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExampleTranformEcuaOne1(pagerState, nextPage, userStateVM)
                1 -> LazyExerciseTransformEcuaOne1(recycleModi, pagerState, topicVM, scope)
                2 -> LazyExerciseTransformEcuaOne2(
                    pagerState,
                    recycleModi,
                    topicVM,
                    scope
                )

                3 -> LazyExerciseTransformEcuaOne3(
                    pagerState,
                    recycleModi,
                    topicVM,
                    scope,
                    userStateVM
                )

                4 -> LazyExerciseTransformEcuaOne4(
                    recycleModi,
                    pagerState,
                    topicVM,
                    scope
                )

                5 -> LazyExerciseTransformEcuaOne5(recycleModi, navController, topicVM, userStateVM)
            }
        },
        pagerState,
        repeatBoxes = 6,
        spaceByBoxes = 25.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExampleTranformEcuaOne1(
    pagerState: PagerState,
    nextPage: Int,
    userStateVM: UserStateVM
) {
    LazyColumn {
        item { ExampleTranformEcuaOne1(pagerState, nextPage, userStateVM) }
    }
}

@Composable
fun ExampleTranformEcuaOne1(
    pagerState: PagerState,
    nextPage: Int,
    userStateVM: UserStateVM
) {
    val scope = rememberCoroutineScope()
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyMedium(
            text = stringResource(id = R.string.exampleOneTransforEcua),
            modifier = Modifier
        )
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.trans_ejem_one_two_dark,
            painterL = R.drawable.trans_ejem_one_two_light,
            modifier = align
        )
        bodyMedium(
            text = stringResource(id = R.string.itemsLazy_eight),
            modifier = Modifier
        )
        bodyLarge(text = "ax - b = c", modifier = align)
        bodyMedium(text = stringResource(id = R.string.itemsLazy_nine), modifier = Modifier)
        bodyLarge(text = "(ax - b)+(b) = c + (b)", modifier = align)
        bodyMedium(text = stringResource(id = R.string.itemsLazy_ten), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.trans_ejem_one_three_dark,
            painterL = R.drawable.trans_ejem_one_three_light,
            modifier = align
        )
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
fun LazyExerciseTransformEcuaOne1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseTransformEcuaOne1(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseTransformEcuaOne1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listCards = listOf(
        "x - y = a\n(-y)+ x -y=a+ (-y) \nx = a - y",
        "x - y = a\n(y) + x - y = a + (y)\nx = a + y"
    )

    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(
            text = stringResource(id = R.string.ExerciseTransformEcuaOne1_one),
            modifier = align
        )
        listCards.forEachIndexed { index, s ->
            CardDouble(
                topicVM,
                activeBtn = index + 1
            ) {
                bodyLarge(text = s, modifier = Modifier.padding(20.dp))
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseTransformEcuaOne2(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseTransformEcuaOne2(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseTransformEcuaOne2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAOne = listOf("(-a-b)(a+b)x=(c)(-a-b)", "(1/a+b)(a+b)x = (c)(1/a+b)")
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(
            text = stringResource(id = R.string.ExerciseTransformEcuaOne1_two),
            modifier = align
        )
        SpaceH()
        bodyLarge(text = "(a + b)x = c", modifier = align)
        SpaceH()
        listAOne.forEachIndexed { index, s ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                ButtonPerson(
                    activeButtonIndex = index + 1,
                    modifier = Modifier.fillMaxWidth(),
                    topicVM
                ) {
                    bodyLarge(text = s, modifier = Modifier)
                }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseTransformEcuaOne3(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseTransformEcuaOne3(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
fun ExerciseTransformEcuaOne3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listOptions =
        listOf(R.drawable.btntwo_transformecua_two_dark, R.drawable.btnone_transformecua_two_dark)
    val listLight =
        listOf(R.drawable.btntwo_transformecua_two_light, R.drawable.btnone_transformecua_two_light)

    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(
            text = stringResource(id = R.string.ExerciseTransformEcuaOne1_two),
            modifier = align
        )
        SpaceH()
        bodyLarge(text = "bx - c = a", modifier = align)
        SpaceH()
        listOptions.forEachIndexed { index, any ->
            ButtonPerson(
                index + 1,
                modifier = Modifier.fillMaxWidth(),
                topicVM
            ) {
                ImageAnimation(
                    userStateVM,
                    painterD = any,
                    painterL = listLight[index],
                    modifier = Modifier
                )
            }
            SpaceH()
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseTransformEcuaOne4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseTransformEcuaOne4(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseTransformEcuaOne4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOptions = listOf("Verdadero", "Falso")
    val listAnswer =
        listOf("(a + b)x = -a -b", "x = - (a + b) / a + b", "x = - (a + b / a + b)", "x = -1")

    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.VoF))
        SpaceH(size = 15.dp)
        listAnswer.forEach { s ->
            bodyLarge(
                text = s,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            listOptions.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseTransformEcuaOne5(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseTransformEcuaOne5(navController, topicVM, userStateVM) }
    }
}

@Composable
fun ExerciseTransformEcuaOne5(
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val listOptions = listOf("Verdadero", "Falso")
    fun scroll() {
        topicVM.checkFinishInt(2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.VoF))
        Spacer(modifier = Modifier.height(15.dp))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_trans_three_dark,
            painterL = R.drawable.ejem_trans_three_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            listOptions.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        btnNextTopic(
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.transformEcuaTwo
        )
    }
}

//Todas las funciones composable de abajo irán a una segunda sesión de tranformación de ecua.
@Composable
fun LazyColumnBoxA5(pagerState: PagerState, nextPage: Int, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        item { BoxA5(pagerState, nextPage) }
    }
}

@Composable
fun BoxA5(pagerState: PagerState, nextPage: Int) {

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
                    ) { append("Recuerda que en transformación de ecuaciones puedes despejar cualquier letra, tanto a x como a a, b, c, d...") }
                })
                Spacer(modifier = Modifier.height(30.dp))
                forBodyorExercise(body = stringResource(id = R.string.BoxA5_one))
                Spacer(modifier = Modifier.height(25.dp))
                forBodyorExercise(body = stringResource(id = R.string.BoxA5_two))
                Spacer(modifier = Modifier.height(15.dp))
                forBodyorExercise(body = stringResource(R.string.BoxA5_three))
            }
        }
        Row(modifier = Modifier.padding(top = 50.dp)) {
            Button(
                onClick = { Button1.value = !Button1.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button1.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button2.value && !Button3.value && !Button4.value && !IfCorrect.value && !IfIncorrect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                forBodyorExercise(body = "a = 12\n\nd = a + bc")
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
                forBodyorExercise(body = "a = 2\n\nd = a-b/c")
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
                forBodyorExercise(body = "a = 6\n\nd = a - bc")
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
                forBodyorExercise(body = "a = 4\n\nd= a - cb")
            }
        }
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

@Composable
fun LazyBoxA6(modifier: Modifier, navController: NavController) {
    LazyColumn(modifier = modifier) {
        item { BoxA6(navController) }
    }
}

@Composable
fun BoxA6(navController: NavController) {
    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val ButtonCorect = remember { mutableStateOf(false) }
    val ButtonIncorect = remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                forTitleorBtn(textForTitle = stringResource(id = R.string.BoxA6_one))
                Spacer(modifier = Modifier.height(10.dp))
                Image(painter = painterResource(id = R.drawable.area), contentDescription = "Image")
                Spacer(modifier = Modifier.height(10.dp))
                forBodyorExercise(body = stringResource(id = R.string.BoxA6_two))
                Spacer(modifier = Modifier.height(10.dp))
                forBodyorExercise(body = stringResource(id = R.string.BoxA6_three))
            }
        }
        Row(modifier = Modifier.padding(top = 30.dp)) {
            Button(
                onClick = { Button1.value = !Button1.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button1.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button3.value && !Button2.value && !Button4.value && !ButtonCorect.value && !ButtonIncorect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                forTitleorBtn(textForTitle = "A = 100\n\nb = 5")
            }
            Button(
                onClick = { Button2.value = !Button2.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button2.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button3.value && !Button1.value && !Button4.value && !ButtonCorect.value && !ButtonIncorect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button2.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                forTitleorBtn(textForTitle = "A = 30\n\nb = 15")
            }
        }
        Row(modifier = Modifier.padding(vertical = 10.dp)) {
            Button(
                onClick = { Button3.value = !Button3.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button3.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button1.value && !Button2.value && !Button4.value && !ButtonCorect.value && !ButtonIncorect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button3.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                forTitleorBtn(textForTitle = "A = 10\n\nb = 12")
            }
            Button(
                onClick = { Button4.value = !Button4.value },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (Button4.value) Color.Magenta else colorAlpha_dark
                ),
                enabled = !Button1.value && !Button3.value && !Button2.value && !ButtonCorect.value && !ButtonIncorect.value,
                elevation = ButtonDefaults.buttonElevation(if (Button4.value) 10.dp else 0.dp),
                modifier = Modifier.weight(1f)
            ) {
                forTitleorBtn(textForTitle = "A = 50\n\nb = 4")
            }
        }
    }
}