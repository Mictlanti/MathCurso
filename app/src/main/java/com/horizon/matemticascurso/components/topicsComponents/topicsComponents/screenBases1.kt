package com.horizon.matemticascurso.views.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.AppScreens

/* @Composable
fun ScreenBases1(modifier: Modifier, navController: NavController) {

    val expanded1 = remember { mutableStateOf(false) }
    val expanded2 = remember { mutableStateOf(false) }
    val expanded3 = remember { mutableStateOf(false) }
    val expanded4 = remember { mutableStateOf(false) }
    val expanded5 = remember { mutableStateOf(false) }
    val expanded6 = remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        val listCardSection = listOf(
            stringResource(id = R.string.simplificacion),
            stringResource(id = R.string.name_transfor),
            stringResource(id = R.string.name_simpli2),
            stringResource(id = R.string.name_multiPoli),
            stringResource(id = R.string.name_puntosPla),
            stringResource(id = R.string.name_grafiRecta)
        )

        listCardSection.forEachIndexed { index, string ->
            CardSection(
                expanded = {
                           when(index) {
                               0 -> expanded1.value = !expanded1.value
                               1 -> expanded2.value = !expanded2.value
                               2 -> expanded3.value = !expanded3.value
                               3 -> expanded4.value = !expanded4.value
                               4 -> expanded5.value = !expanded5.value
                               5 -> expanded6.value = !expanded6.value
                           }
                },
                expandedConfirm = when(index){
                    0 -> expanded1.value
                    1 -> expanded2.value
                    2 -> expanded3.value
                    3 -> expanded4.value
                    4 -> expanded5.value
                    5 -> expanded6.value
                    else -> expanded1.value
                },
                painter = painterResource(id =  R.drawable.ic_fisic),
                topic = string,
                navController = navController,
                destination1 = when(index) {
                    0 -> AppScreens.basicOperation
                    1 -> AppScreens.transformEcua
                    2 -> AppScreens.simpli2One
                    3 -> AppScreens.multiPoliOne
                    4 -> AppScreens.puntosDePlanoOne
                    5 -> AppScreens.grafiRectaOne
                    else -> AppScreens.basicOperation },
                destination2 = when(index) {
                    0 -> AppScreens.basicOperationTwo
                    1 -> AppScreens.transformEcuaTwo
                    2 -> AppScreens.simpli2Two
                    3 -> AppScreens.multiPoliTwo
                    4 -> AppScreens.punPlanoTwo
                    5 -> AppScreens.grafiRectaTwo
                    else -> AppScreens.basicOperation },
                destination3 = when(index) {
                    0 -> AppScreens.simplificacionScreen
                    1 -> AppScreens.transformEcuaTwo
                    2 -> AppScreens.simpli2Three
                    3 -> AppScreens.multiPoliThree
                    4 -> AppScreens.punPlaThree
                    5 -> AppScreens.grafiRectaThree
                    else -> AppScreens.basicOperation },
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardSection(
    expanded: () -> Unit,
    expandedConfirm: Boolean,
    painter: Painter,
    topic: String,
    navController: NavController,
    Session1: String =  stringResource(id = R.string.session1),
    destination1: AppScreens,
    Session2: String =  stringResource(id = R.string.session2),
    destination2: AppScreens,
    Session3: String =  stringResource(id = R.string.session3),
    destination3: AppScreens
) {
    Card(
        onClick = expanded,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
            .height(if (expandedConfirm) 350.dp else 67.dp)
            .padding(horizontal = 5.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 6.dp, vertical = 15.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box {
                    Row {
                        Icon(
                            painter = painter,
                            contentDescription = null,
                            modifier = Modifier.size(60.dp),
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                        SpaceW(size = 5.dp)
                        Column(modifier = Modifier.height(65.dp)) {
                            headLineMediumHomeWidthColor(textBtns = topic, color = MaterialTheme.colorScheme.onBackground)
                        }
                    }
                }
                Box {
                    if(expandedConfirm) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_drop_up),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .size(38.dp)
                                .padding(end = 5.dp)
                        )
                    }
                }
            }
            if(expandedConfirm){
                boxesForTopics(
                    navController,
                    destination = destination1,
                    Session = Session1
                )
                boxesForTopics(
                    navController,
                    destination = destination2,
                    Session = Session2
                )
                boxesForTopics(
                    navController,
                    destination = destination3,
                    Session = Session3
                )
            }
        }
    }
}

@Composable
fun boxesForTopics(
    navController: NavController,
    destination: AppScreens,
    Session: String
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate(destination.route) }
                .padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            headLineMediumWidthModi(
                title = Session,
                modifier = Modifier.padding(10.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Divider(
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
    }
} */
@Composable
fun ScreenBases1(modifier: Modifier, navController: NavController) {

    val expandedStates = remember { mutableStateListOf(false, false, false, false, false, false) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        val listCardSection = listOf(
            R.string.simplificacion,
            R.string.name_transfor,
            R.string.name_simpli2,
            R.string.name_multiPoli,
            R.string.name_puntosPla,
            R.string.name_grafiRecta
        )

        val destinations = listOf(
            listOf(AppScreens.basicOperation, AppScreens.basicOperationTwo, AppScreens.simplificacionScreen),
            listOf(AppScreens.transformEcua, AppScreens.transformEcuaTwo, AppScreens.transformEcuaTwo),
            listOf(AppScreens.simpli2One, AppScreens.simpli2Two, AppScreens.simpli2Three),
            listOf(AppScreens.multiPoliOne, AppScreens.multiPoliTwo, AppScreens.multiPoliThree),
            listOf(AppScreens.puntosDePlanoOne, AppScreens.punPlanoTwo, AppScreens.punPlaThree),
            listOf(AppScreens.grafiRectaOne, AppScreens.grafiRectaTwo, AppScreens.grafiRectaThree)
        )

        listCardSection.forEachIndexed { index, stringRes ->
            CardSection(
                expanded = { expandedStates[index] = !expandedStates[index] },
                expandedConfirm = expandedStates[index],
                painter = painterResource(id = R.drawable.ic_fisic),
                topic = stringResource(id = stringRes),
                navController = navController,
                destinations = destinations[index]
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardSection(
    expanded: () -> Unit,
    expandedConfirm: Boolean,
    painter: Painter,
    topic: String,
    navController: NavController,
    destinations: List<AppScreens>,
    sessions: List<String> = listOf(
        stringResource(id = R.string.session1),
        stringResource(id = R.string.session2),
        stringResource(id = R.string.session3)
    )
) {
    Card(
        onClick = expanded,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
            .height(if (expandedConfirm) 350.dp else 67.dp)
            .padding(horizontal = 5.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 6.dp, vertical = 15.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box {
                    Row {
                        Icon(
                            painter = painter,
                            contentDescription = null,
                            modifier = Modifier.size(60.dp),
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                        SpaceW(size = 5.dp)
                        Column(modifier = Modifier.height(65.dp)) {
                            headLineMediumHomeWidthColor(textBtns = topic, color = MaterialTheme.colorScheme.onBackground)
                        }
                    }
                }
                if (expandedConfirm) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_drop_up),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .size(38.dp)
                            .padding(end = 5.dp)
                    )
                }
            }
            if (expandedConfirm) {
                destinations.zip(sessions).forEach { (destination, session) ->
                    boxesForTopics(navController, destination, session)
                }
            }
        }
    }
}

@Composable
fun boxesForTopics(
    navController: NavController,
    destination: AppScreens,
    session: String
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate(destination.route) }
                .padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            headLineMediumWidthModi(
                title = session,
                modifier = Modifier.padding(10.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Divider(
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
    }
}