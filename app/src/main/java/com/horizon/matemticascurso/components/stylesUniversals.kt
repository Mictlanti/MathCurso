package com.horizon.matemticascurso.views.components

import android.widget.Toast
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.sharp.Lightbulb
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.adsContainer.intertitialAdsContainer
import com.horizon.matemticascurso.data.model.FavoriteState
import com.horizon.matemticascurso.module.TopicData
import com.horizon.matemticascurso.ui.theme.abelFont
import com.horizon.matemticascurso.ui.theme.colorAlpha_dark
import com.horizon.matemticascurso.ui.theme.personForBody
import com.horizon.matemticascurso.ui.theme.personForTitle
import com.horizon.matemticascurso.ui.theme.salsaFontFamily
import com.horizon.matemticascurso.ui.theme.ubuntuFontFamily
import com.horizon.matemticascurso.vms.FavoriteVM
import com.horizon.matemticascurso.vms.FavoriteViewModel
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM

object textList {
    val listIncorrect: List<String> =
        listOf(
            "Intentalo de nuevo",
            "Mala suerte",
            "¡Uy! Por poco",
            "¡No te rindas!",
            "Ya casi lo tienes"
        )
    val listCorrect: List<String> =
        listOf(
            "¡Bien hecho!",
            "Comprediste el tema",
            "¡Impresionante!",
            "Pasemos al siguiente",
            "Lo hiciste bien",
            "Me enorgulleces"
        )
}

@Composable
fun TextAbel(
    text: String,
    size: TextUnit = 20.sp,
    fontWeight: FontWeight = FontWeight.W400,
    fontFamily: FontFamily = abelFont,
    color: Color = MaterialTheme.colorScheme.onBackground,
    letterSpacing: TextUnit = 2.3.sp,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = size,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        color = color,
        letterSpacing = letterSpacing,
        modifier = modifier
    )
}

@Composable
fun forTitleorBtn(
    textForTitle: String,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(text = textForTitle, style = style, color = color)
}

@Composable
fun titleLarge(
    text: String,
    fontFamily: FontFamily = personForTitle,
    fontWeight: FontWeight = FontWeight.W700,
    fontSize: TextUnit = 27.sp,
    lineHeight: TextUnit = 42.sp,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = text,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        lineHeight = lineHeight,
        color = color
    )
}

//Esta es para VoF, ejemplo de desarrollo o Btn comprueba
@Composable
fun titleMedium(
    text: String,
    fontFamily: FontFamily = personForTitle,
    fontWeight: FontWeight = FontWeight.W400,
    fontSize: TextUnit = 25.sp,
    lineHeight: TextUnit = 39.sp,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = text,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        lineHeight = lineHeight,
        color = color
    )
}

//Este es para el body y ejercicios
@Composable
fun forBodyorExercise(
    body: String,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(text = body, style = style, color = color)
}

@Composable
fun bodyLarge(
    text: String,
    fontFamily: FontFamily = personForBody,
    fontWeight: FontWeight = FontWeight.W400,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = 25.sp,
    lineHeight: TextUnit = 32.sp,
    color: Color = MaterialTheme.colorScheme.onBackground,
    modifier: Modifier
) {
    Text(
        text = text,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        fontSize = fontSize,
        lineHeight = lineHeight,
        color = color,
        modifier = modifier
    )
}

@Composable
fun bodyMedium(
    text: String,
    fontFamily: FontFamily = personForBody,
    fontWeight: FontWeight = FontWeight.W200,
    fontStyle: FontStyle = FontStyle.Italic,
    fontSize: TextUnit = 18.sp,
    lineHeight: TextUnit = 20.sp,
    color: Color = MaterialTheme.colorScheme.onBackground,
    modifier: Modifier
) {
    Text(
        text = text,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        fontSize = fontSize,
        lineHeight = lineHeight,
        color = color,
        modifier = modifier
    )
}

@Composable
fun bodySmall(
    text: String,
    fontFamily: FontFamily = personForBody,
    fontWeight: FontWeight = FontWeight.W200,
    fontStyle: FontStyle = FontStyle.Italic,
    fontSize: TextUnit = 14.sp,
    lineHeight: TextUnit = 20.sp,
    color: Color = MaterialTheme.colorScheme.onBackground,
    modifier: Modifier
) {
    Text(
        text = text,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        fontSize = fontSize,
        lineHeight = lineHeight,
        color = color,
        modifier = modifier
    )
}

@Composable
fun ExceptionBody(
    body: String,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = body,
        style = style,
        color = color
    )
}

@Composable
fun ExceptionTitle(
    title: String,
    style: TextStyle = MaterialTheme.typography.headlineMedium,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = title,
        style = style,
        color = color
    )
}

@Composable
fun headLineMediumWidthModi(
    title: String,
    fontFamily: FontFamily = ubuntuFontFamily,
    fontWeight: FontWeight = FontWeight.SemiBold,
    fontSize: TextUnit = 25.sp,
    letterSpacing: TextUnit = 1.6.sp,
    fontStyle: FontStyle = FontStyle.Normal,
    color: Color = MaterialTheme.colorScheme.onBackground,
    modifier: Modifier
) {
    Text(
        text = title,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        letterSpacing = letterSpacing,
        fontStyle = fontStyle,
        color = color,
        modifier = modifier
    )
}

@Composable
fun headLineLargeHome(
    title: String,
    fontStyle: FontStyle = FontStyle.Normal,
    fontFamily: FontFamily = salsaFontFamily,
    fontSize: TextUnit = 32.sp,
    fontWeight: FontWeight = FontWeight.W600,
    letterSpacing: TextUnit = 2.1.sp,
    lineHeight: TextUnit = 40.sp,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = title,
        fontStyle = fontStyle,
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight,
        letterSpacing = letterSpacing,
        lineHeight = lineHeight,
        color = color
    )
}

@Composable
fun headLineSmallHome(
    title: String,
    fontStyle: FontStyle = FontStyle.Normal,
    fontFamily: FontFamily = salsaFontFamily,
    fontWeight: FontWeight = FontWeight.W400,
    fontSize: TextUnit = 17.sp,
    lineHeight: TextUnit = 20.sp,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = title,
        fontStyle = fontStyle,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        lineHeight = lineHeight,
        color = color
    )
}

@Composable
fun headLineMediumHomeWidthColor(
    textBtns: String,
    fontFamily: FontFamily = ubuntuFontFamily,
    fontWeight: FontWeight = FontWeight.ExtraLight,
    fontSize: TextUnit = 23.sp,
    fontStyle: FontStyle = FontStyle.Normal,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Text(
        text = textBtns,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        fontStyle = fontStyle,
        color = color
    )
}

@Composable
fun ButtonPerson(
    activeButtonIndex: Int,
    modifier: Modifier,
    topicVM: TopicVM,
    color2: Color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.2f),
    color1: Color = MaterialTheme.colorScheme.primary,
    content: @Composable() (RowScope.() -> Unit)
) {
    val state by topicVM.state.collectAsState()
    Button(
        onClick = { topicVM.activeBtnIndex(activeBtn = activeButtonIndex) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (state.activeBtnIndex == activeButtonIndex) color1 else color2
        ),
        elevation = ButtonDefaults.buttonElevation(if (state.activeBtnIndex == activeButtonIndex) 10.dp else 0.dp),
        modifier = modifier,
        content = content
    )
}

@Composable
fun BtnCheck(
    onClick: () -> Unit,
    topicVM: TopicVM,
    colorCorrect: Color = Color.Green,
    colorInco: Color = colorAlpha_dark,
    elseColor: Color = MaterialTheme.colorScheme.primaryContainer
) {

    val state by topicVM.state.collectAsState()

    Button(
        onClick = { onClick() },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor =
            when {
                state.correct -> colorCorrect
                state.incorrect -> colorInco
                else -> elseColor
            }
        )
    ) {
        titleMedium(
            text = when {
                 state.incorrect-> textList.listIncorrect.random()
                 state.correct -> textList.listCorrect.random()
                else -> "Comprueba tu respuesta"
            }
        )
    }
}

@Composable
fun btnNextTopic(
    onClick: () -> Unit,
    topicVM: TopicVM,
    navController: NavController,
    destination: AppScreens
) {
    val state by topicVM.state.collectAsState()
    if (state.finishAds) {
        intertitialAdsContainer(navController = navController, destination = destination, topicVM)
    } else {
        BtnCheck(onClick = onClick, topicVM)
    }
}

@Composable
fun OutlinedText(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable() (() -> Unit)?
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        maxLines = 1,
        textStyle = TextStyle(fontSize = 17.sp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        placeholder = placeholder,
        modifier = Modifier
            .size(width = 80.dp, height = 60.dp)
            .border(width = 1.dp, color = Color.Transparent)
    )
}

@Composable
fun OutlinedTextString(
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType,
    placeholder: @Composable() (() -> Unit)?
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        maxLines = 1,
        textStyle = TextStyle(fontSize = 17.sp),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Done
        ),
        placeholder = placeholder,
        modifier = Modifier
            .size(width = 80.dp, height = 60.dp)
            .border(width = 1.dp, color = Color.Transparent)
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun TopAppBarExercise(
    repeatBoxes: Int,
    spaceByBoxes: Dp,
    pagerState: PagerState,
    onClick: () -> Unit,
    onClickFav: () -> Unit,
    widthBoxes: Dp
) {
    val fillMaxWidth = Modifier.fillMaxWidth()

    CenterAlignedTopAppBar(
        title = {
            Box(
                modifier = fillMaxWidth.padding(horizontal = 5.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Row(
                    modifier = fillMaxWidth,
                    horizontalArrangement = Arrangement.spacedBy(spaceByBoxes),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(repeatBoxes) {
                        val color = if (pagerState.currentPage == it) MaterialTheme.colorScheme.onBackground else Color.Gray.copy(alpha = 0.5f)
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(height = 3.dp, width = widthBoxes)
                                .background(color)
                        )
                    }
                }
            }
        },
        navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back"
                )
            }
        },
        actions = {
                IconButton(onClick = { onClickFav() }) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "lifes",
                        tint = Color.Red
                    )
                }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.background)
    )
}

/*@Composable
fun DashboardScreen(viewModel: UserStateVM) {

    val state by viewModel.state.collectAsState()
    val animatedLifes by animateIntAsState(targetValue = state.lives, label = "Lives")

    DashboardContent(animatedLifes)
} */

@Composable
fun DashboardContent(lifes: Int) {
    // Tu contenido de la pantalla del dashboard
    Text(
        text = "$lifes",
        color = Color.Red,
        fontSize = 15.sp
    )
}

@Composable
fun btnExample(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        //colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary),
        modifier = Modifier.fillMaxWidth()
    ) {
        bodyLarge(text = "¨Página siguiente", modifier = Modifier)
    }
}

@Composable
fun ScreenEnabled(modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Error,
            contentDescription = "Screen enabled",
            modifier = Modifier.size(250.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        headLineLargeHome(title = "Sesión no disponible")
        bodyMedium(text = "Pronto encontrarás disponible esta sesión", modifier = Modifier)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun alertBtnStyle(
    PartiallyExpanded: Boolean,
    showExample: Boolean,
    onDismissRequest: () -> Unit,
    content: @Composable() (LazyItemScope.() -> Unit)
) {

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = PartiallyExpanded
    )

    if (showExample) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = onDismissRequest,
            scrimColor = Color.Black.copy(alpha = 0.5f),
            containerColor = MaterialTheme.colorScheme.background,
            dragHandle = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BottomSheetDefaults.DragHandle()
                    bodyLarge(
                        text = stringResource(id = R.string.exampleOneBO),
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.size(15.dp))
                    Divider()
                }
            },
            content = {
                LazyColumn(modifier = Modifier.padding(top = 25.dp, bottom = 45.dp)) {
                    item { content() }
                }
            }
        )
    }
}

@Composable
fun SpaceH(size: Dp = 20.dp) {
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun SpaceW(size: Dp = 20.dp) {
    Spacer(modifier = Modifier.width(size))
}