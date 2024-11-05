package com.horizon.matemticascurso.components.topicsComponents.exerciseComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.horizon.matemticascurso.components.topicsComponents.topicsComponents.RobotoMono
import com.horizon.matemticascurso.views.components.ExceptionBody
import com.horizon.matemticascurso.views.components.ExceptionTitle
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.SpaceW
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodySmall
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM

@Composable
fun CardDouble(topicVM: TopicVM, activeBtn: Int, content: @Composable ((ColumnScope.() -> Unit))) {

    val state by topicVM.state.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                onClick = { topicVM.activeBtnIndex(activeBtn) },
                shape = MaterialTheme.shapes.small,
                colors = CardDefaults.cardColors(
                    containerColor = if (state.activeBtnIndex == activeBtn) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary
                ),
                border = if (state.activeBtnIndex == activeBtn) BorderStroke(
                    1.dp,
                    MaterialTheme.colorScheme.onBackground
                ) else null,
                modifier = Modifier
                    .size(50.dp)
                    .weight(1f)
            ) {

            }
            SpaceW(size = 15.dp)
            Card(
                onClick = { topicVM.activeBtnIndex(activeBtn) },
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f),
                content = content
            )
        }
    }
}

@Composable
fun ImageAnimation(
    userStateVM: UserStateVM,
    painterD: Int,
    painterL: Int,
    modifier: Modifier
) {
    val indexMode = userStateVM.state.collectAsState().value.indexColor
    if (indexMode == 0 || indexMode == 1 || indexMode == 2) {
        Image(
            painter = painterResource(id = painterL),
            contentDescription = null,
            modifier = modifier
        )
    } else {
        Image(
            painter = painterResource(id = painterD),
            contentDescription = null,
            modifier = modifier
        )
    }
}

@Composable
fun Exponente(
    base: String,
    exponente: String,
    modifier: Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = 25.sp
) {
    Box(modifier = modifier) {
        Row {
            bodyLarge(text = base, modifier = Modifier, color = color, fontSize = fontSize)
            SpaceW(size = 3.dp)
            bodySmall(
                text = exponente,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(bottom = 3.dp),
                color = color
            )
        }
    }
}

@Composable
fun ExponenteLarge(
    b1: String,
    b2: String,
    b3: String,
    e1: String,
    e2: String,
    e3: String,
    modifier: Modifier
) {

    val list = listOf(b1, b2, b3)
    val listTwo = listOf(e1, e2, e3)

    Box(modifier = modifier) {
        Row {
            list.forEachIndexed { index, s ->
                bodyLarge(text = s, modifier = Modifier)
                SpaceW(size = 3.dp)
                bodySmall(
                    text = listTwo[index],
                    fontWeight = FontWeight.W400,
                    modifier = Modifier.padding(bottom = 3.dp)
                )
            }
        }
    }
}

@Composable
fun By(call: Boolean = true) {
    if (call) {
        SpaceW(size = 3.dp)
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = MaterialTheme.shapes.extraLarge
                )
                .size(3.dp)
        )
        SpaceW(size = 3.dp)
    }
}

@Composable
fun SignDivi() {
    Box(
        modifier = Modifier
            .size(23.dp)
            .padding(horizontal = 7.dp)
            .padding(top = 5.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            By()
            SpaceH(size = 4.dp)
            Divider(color = MaterialTheme.colorScheme.onBackground)
            SpaceH(size = 4.dp)
            By()
        }
    }
}

@Composable
fun Grafics(
    painterR: Int,
    modifier: Modifier = Modifier.padding(20.dp),
    color: Color = Color.Black.copy(alpha = 0.2f)
) {
    Box(
        modifier = Modifier
            .background(
                color = color,
                shape = MaterialTheme.shapes.extraLarge
            )
    ) {
        Image(
            painter = painterResource(id = painterR),
            contentDescription = null,
            modifier = modifier
        )
    }
}

@Composable
fun CardExample(titleRes: Int, bodyRes: Int, formula: @Composable() (ColumnScope.() -> Unit)) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
        modifier = Modifier.padding(top = 15.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            ExceptionTitle(title = stringResource(id = titleRes))
            ExceptionBody(body = stringResource(id = bodyRes))
            formula()
        }
    }
}

@Composable
fun CardFormula(content: @Composable() (RowScope.() -> Unit)) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
        shape = MaterialTheme.shapes.large
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            content()
        }
    }
}

@Composable
fun ExponenteCuadrado(
    baseOne: String,
    exponenOne: String,
    next: String,
    baseTwo: String,
    exponenTwo: String,
    fontSize: TextUnit = 25.sp
) {
    Row {
        Exponente(base = baseOne, exponente = exponenOne, modifier = Modifier, fontSize = fontSize)
        bodyLarge(text = next, modifier = Modifier, fontSize = fontSize)
        Exponente(base = baseTwo, exponente = exponenTwo, modifier = Modifier, fontSize = fontSize)
    }
}

@Composable
fun SpecialExponenteCuadrado(
    baseOne: String,
    exponenOne: String,
    baseNext: String,
    exponenteNext: String,
    other: Boolean = false,
    baseOther: String = "",
    exponenteOther: String = "",
    baseTwo: String,
    exponenTwo: String,
    fontSize: TextUnit = 25.sp
) {
    Row {
        Exponente(base = baseOne, exponente = exponenOne, modifier = Modifier, fontSize = fontSize)
        Exponente(base = baseNext, exponente = exponenteNext, modifier = Modifier, fontSize = fontSize)
        if(other) Exponente(base = baseOther, exponente = exponenteOther, modifier = Modifier, fontSize = fontSize)
        Exponente(base = baseTwo, exponente = exponenTwo, modifier = Modifier, fontSize = fontSize)
    }
}

@Composable
fun SpecialExponent(
    base: String,
    exponente: String,
    sndExponent: String,
    secondExpo: Boolean = false,
    otherB: String = "",
    otherE: String = ""
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        bodyLarge(text = "(", modifier = Modifier)
        Exponente(base = base, exponente = exponente, modifier = Modifier)
        if (secondExpo) Exponente(base = otherB, exponente = otherE, modifier = Modifier)
        Exponente(base = ")", exponente = sndExponent, modifier = Modifier)
    }
}

@Composable
fun DiferenciaCuadrados(baseOne: String, exponenteOne: String, baseTwo: String, exponenTwo: String) {
    Row {
        Exponente(base = baseOne, exponente = exponenteOne, modifier = Modifier)
        Exponente(base = baseTwo, exponente = exponenTwo, modifier = Modifier)
    }
}