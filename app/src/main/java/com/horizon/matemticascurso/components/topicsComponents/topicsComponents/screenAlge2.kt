package com.horizon.matemticascurso.components.topicsComponents.topicsComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.views.components.CardSection

/* @Composable
fun ScreenAlge2(modifier: Modifier, navController: NavController) {

    val expanded1 = remember { mutableStateOf(false) }
    val expanded2 = remember { mutableStateOf(false) }
    val expanded3 = remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        val listCardSection = listOf(
            stringResource(id = R.string.name_Facto1),
            stringResource(id = R.string.name_facto2),
            stringResource(id = R.string.name_facto3)
        )

        listCardSection.forEachIndexed { index, string ->
            CardSection(
                expanded = {
                    when(index){
                        0 -> expanded1.value = !expanded1.value
                        1 -> expanded2.value = !expanded2.value
                        2 -> expanded3.value = !expanded3.value
                    } },
                expandedConfirm = when(index){
                    0 -> expanded1.value
                    1 -> expanded2.value
                    2 -> expanded3.value
                    else -> expanded1.value
                },
                painter = painterResource(id =  R.drawable.ic_idea),
                topic = string,
                noTopics = when(index){
                    0 -> "5"
                    1 -> "5"
                    2 -> "5"
                    else -> "5"
                },
                navController = navController,
                destination1 = when(index) {
                    0 -> AppScreens.facto1One
                    1 -> AppScreens.facto2One
                    2 -> AppScreens.facto3One
                    else -> AppScreens.facto1One
                },
                destination2 = when(index) {
                    0 -> AppScreens.facto1Two
                    1 -> AppScreens.facto2Two
                    2 -> AppScreens.facto3Two
                    else -> AppScreens.facto1One
                },
                destination3 = when(index) {
                    0 -> AppScreens.facto1Three
                    1 -> AppScreens.facto2Three
                    2 -> AppScreens.facto3Three
                    else -> AppScreens.facto1One
                },
            )
        }
    }
} */

@Composable
fun ScreenAlge2(modifier: Modifier, navController: NavController) {

    val expandedStates = remember { mutableStateListOf(false, false, false, false, false, false) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        val listCardSection = listOf(
            R.string.name_Facto1,
            R.string.name_facto2,
            R.string.name_facto3
        )

        val destinations = listOf(
            listOf(AppScreens.facto1One, AppScreens.facto1Two, AppScreens.facto1Three),
            listOf(AppScreens.facto2One, AppScreens.facto2Two, AppScreens.facto2Three),
            listOf(AppScreens.facto3One, AppScreens.facto3Two, AppScreens.facto3Three)
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