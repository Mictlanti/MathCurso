package com.horizon.matemticascurso.views

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.headLineLargeHome
import kotlinx.coroutines.delay

@Composable
fun SplashScreenRoute(
    navController: NavController,
    cycleDuration: Int = 1000
) {

    val infiniteTransition = rememberInfiniteTransition("InfiniteLoaderTransition")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(animation =  tween(cycleDuration, easing = LinearEasing)),
        label = "Loader"
    )

    LaunchedEffect(key1 = Unit) {
        delay(3000)
        navController.popBackStack()
        navController.navigate(AppScreens.homeScreenRoute.route)
    }

    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 80.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            headLineLargeHome(title = stringResource(id = R.string.app_name))
            Box(modifier = Modifier.size(120.dp)) {
                CircleCanvas(
                    modifier = Modifier.matchParentSize(),
                    rotationX = 35f,
                    rotationY = -45f,
                    rotationZ = -90f + rotation,
                    borderColor = MaterialTheme.colorScheme.onBackground,
                    borderWidth = 3.dp
                )
                CircleCanvas(
                    modifier = Modifier.matchParentSize(),
                    rotationX = 50f,
                    rotationY = 10f,
                    rotationZ = rotation,
                    borderColor = MaterialTheme.colorScheme.onBackground,
                    borderWidth = 3.dp
                )
                CircleCanvas(
                    modifier = Modifier.matchParentSize(),
                    rotationX = 35f,
                    rotationY = -45f,
                    rotationZ = 90f + rotation,
                    borderColor = MaterialTheme.colorScheme.onBackground,
                    borderWidth = 3.dp
                )
            }
            SpaceH(size = 30.dp)
        }
    }
}

@Composable
fun CircleCanvas(
    modifier: Modifier,
    rotationX: Float,
    rotationY: Float,
    rotationZ: Float,
    borderColor: Color,
    borderWidth: Dp
) {
    Canvas(
        modifier.graphicsLayer {
            this.rotationX = rotationX
            this.rotationY = rotationY
            this.rotationZ = rotationZ
            cameraDistance = 12f * density
        }
    ) {
        val mainCircle = Path().apply {
            addOval(Rect(size.center, size.minDimension / 2))
        }

        val clipCenter = Offset(size.width / 2 - borderWidth.toPx(), size.height / 2)
        val clipCircle = Path().apply {
            addOval(Rect(clipCenter, size.minDimension / 2))
        }

        val path = Path() .apply {
            op(mainCircle, clipCircle, PathOperation.Difference)
        }

        drawPath(path, borderColor)
    }
}