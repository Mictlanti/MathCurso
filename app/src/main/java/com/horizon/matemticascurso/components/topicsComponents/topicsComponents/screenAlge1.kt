package com.horizon.matemticascurso.components.topicsComponents.topicsComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.views.components.CardSection

@Composable
fun ScreenAlge1(modifier: Modifier, navController: NavController) {

    val expandedStates = remember { mutableStateListOf(false, false, false, false, false, false) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        val listCardSection = listOf(
            R.string.name_sistemEcua1,
            R.string.name_sistemEcua2,
            R.string.name_desiLineales,
            R.string.name_leyExpo,
            R.string.name_producNota,
        )

        val destinations = listOf(
            listOf(AppScreens.sitemaEcua1, AppScreens.sistemEcua1Two, AppScreens.sistemEcua1Three),
            listOf(AppScreens.sistemaEcua2, AppScreens.sistemaEcua2Two, AppScreens.sistemaEcua2Three),
            listOf(AppScreens.desigualLineales, AppScreens.desigualLinealesTwo, AppScreens.desigualLinealesThree),
            listOf(AppScreens.leyExpoOne, AppScreens.leyExpoTwo, AppScreens.leyExpoThree),
            listOf(AppScreens.producNotaOne, AppScreens.producNotaTwo, AppScreens.producNotaThree)
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