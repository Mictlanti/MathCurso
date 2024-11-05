@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.components.topicsComponents.topicsComponents.ScreenAlge1
import com.horizon.matemticascurso.components.topicsComponents.topicsComponents.ScreenAlge2
import com.horizon.matemticascurso.components.topicsComponents.topicsComponents.ScreenAlge3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectCard(
    modifier: Modifier = Modifier,
    sectionsNumber: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    topics: String
) {
    OutlinedCard(
        onClick = { onClick() },
        shape = MaterialTheme.shapes.extraLarge,
        elevation = CardDefaults.outlinedCardElevation(defaultElevation = 7.dp),
        colors = CardDefaults.outlinedCardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.size(200.dp)
    ) {
        Column(
            modifier = modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            headLineLargeHome(title = sectionsNumber, color = MaterialTheme.colorScheme.onBackground)
            Icon(
                painter = painterResource(id = R.drawable.ic_library_books),
                contentDescription = null,
                modifier = Modifier.size(95.dp),
                tint = MaterialTheme.colorScheme.background
            )
            forBodyorExercise(body = topics)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun horizontalScreen(
    pagerState: PagerState,
    navController: NavController,
    modifier: Modifier
) {
    val recicleModi = Modifier.fillMaxSize()
    HorizontalPager(
        state = pagerState,
        pageSpacing = 20.dp,
        modifier = modifier
    ) { page ->
        AnimatedVisibility(
            visible = page == pagerState.currentPage,
            enter = scaleIn(animationSpec = tween(1200)),
            exit = scaleOut(animationSpec = tween(1200))
        ) {
            when(page) {
                0 -> ScreenBases1(modifier = Modifier.fillMaxWidth(), navController)
                1 -> ScreenAlge1(modifier = recycleModifier, navController)
                2 -> ScreenAlge2(modifier = recicleModi, navController)
                3 -> ScreenAlge3(modifier = recicleModi, navController)
            }
        }
    }
}