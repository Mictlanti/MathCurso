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

@Composable
fun ScreenAlge3(modifier: Modifier, navController: NavController) {

    val expandedStates = remember { mutableStateListOf(false, false, false, false, false, false) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        val listCardSection = listOf(
            R.string.name_opeRaiz,
            R.string.name_numIrra,
            R.string.name_sistemEcua3,
            R.string.name_desaPoli
        )

        val destinations = listOf(
            listOf(AppScreens.raices, AppScreens.raizTwo, AppScreens.raizTwo),
            listOf(AppScreens.numIrracionales, AppScreens.raizTwo, AppScreens.raizTwo),
            listOf(AppScreens.sistemaEcua3, AppScreens.raizTwo, AppScreens.raizTwo),
            listOf(AppScreens.desarrolloPoli, AppScreens.raizTwo, AppScreens.raizTwo)
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