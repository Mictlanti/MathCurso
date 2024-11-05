package com.horizon.matemticascurso.components.topicsComponents.examplesToExercise

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
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.bodySmall
import com.horizon.matemticascurso.vms.UserStateVM

@Composable
fun eToBasicOpeSession1() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp)
    ) {
        bodyMedium(
            text = stringResource(id = R.string.textExampleOne_one),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(7.dp))
        bodyMedium(text = stringResource(id = R.string.textExampleOne), modifier = Modifier)
        Image(
            painter = painterResource(id = R.drawable.img_example_bo),
            contentDescription = null
        )
        bodyMedium(text = stringResource(id = R.string.textExampleTwo), modifier = Modifier)
        bodyLarge(text = "4x + 2z = 4x + 2z", modifier = Modifier)
    }
}

@Composable
fun eToBasicOpeSession2() {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        bodyMedium(text = stringResource(id = R.string.eToBasicOpeSession2_one), modifier = Modifier)
        Box {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                bodyMedium(text = "b - c", modifier = Modifier)
                bodyMedium(text = "2b + 3c - 2d", modifier = Modifier)
                bodyMedium(text = "-b - c - 4d", modifier = Modifier)
                Divider(modifier = Modifier.fillMaxWidth())
                bodyMedium(text = "2b + c -6d", modifier = Modifier)
            }
        }
    }
}

@Composable
fun eToSimpliSession1() {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        bodyMedium(text = stringResource(id = R.string.eToSimpliSession1_one), modifier = Modifier)
        Box {
            Row {
                bodyMedium(text = "a", modifier = Modifier)
                bodySmall(text = "b", modifier = Modifier)
            }
        }
        bodyMedium(text = stringResource(id = R.string.eToSimpliSession1_two), modifier = Modifier)
        Image(
            painter = painterResource(id = R.drawable.ejem_simplitwo_one_one_dark),
            contentDescription = "Image",
        )
    }
}

@Composable
fun eToSimpliSession3() {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        bodyMedium(text = stringResource(id = R.string.eToSimpliSession1_one), modifier = Modifier)
        Box {
            Row {
                bodyMedium(text = "a", modifier = Modifier)
                bodySmall(text = "b", modifier = Modifier)
            }
        }
        bodyMedium(text = stringResource(id = R.string.eToSimpliSession1_two), modifier = Modifier)
        Image(
            painter = painterResource(id = R.drawable.ejem_simplimonopoli_four_dark),
            contentDescription = null
        )
    }
}

@Composable
fun eToMultiPoli() {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        val listText = listOf(
            stringResource(id = R.string.eToMultiPoli_one),
            stringResource(id = R.string.eToMultiPoli_two),
            stringResource(id = R.string.eToMultiPoli_three),
            stringResource(id = R.string.eToMultiPoli_four),
            stringResource(id = R.string.eToMultiPoli_five)
        )
        listText.forEach { s ->
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
            ) {
                bodyLarge(text = s, modifier = Modifier)
            }
        }
        Box {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.ejem_multipoli_three_dark),
                    contentDescription = "Image",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                bodyMedium(text = "First, Outer,Inner, Last", modifier = Modifier.align(Alignment.End))
            }
        }
    }
}

@Composable
fun eToSistemEcuaOneSession1(userStateVM: UserStateVM){
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_sistemecuaone_two_dark,
            painterL = R.drawable.ejem_sistemecuaone_two_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        bodyLarge(text = stringResource(id = R.string.Box2C1_two), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box2C1_three), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box2C1_four), modifier = Modifier)
    }
}