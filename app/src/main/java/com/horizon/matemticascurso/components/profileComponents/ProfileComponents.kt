package com.horizon.matemticascurso.components.profileComponents

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.horizon.matemticascurso.components.homeComponents.ImageProfile
import com.horizon.matemticascurso.data.firebase.AuthManager
import com.horizon.matemticascurso.views.components.SpaceW
import com.horizon.matemticascurso.views.components.TextAbel
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.headLineMediumWidthModi
import com.horizon.matemticascurso.views.components.headLineSmallHome
import com.horizon.matemticascurso.vms.UserStateVM

@Composable
fun ProfileView(
    authManager: AuthManager,
    userStateVM: UserStateVM,
    onClick: () -> Unit
) {

    val uid = authManager.getCurrentUser()?.uid
    val user = authManager.getCurrentUser()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 25.dp, vertical = 15.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val modiImageProfile = Modifier
            .clip(CircleShape)
            .size(160.dp)
        ImageProfile(
            authManager = authManager,
            modifier = modiImageProfile
        )
        headLineMediumWidthModi(
            title = if (!user?.displayName.isNullOrEmpty()) "${user?.displayName}" else uid.toString(),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(15.dp))
        headLineSmallHome(title = "EXP: 7")
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            bodyMedium(text = "Cerrar sesión", modifier = Modifier)
        }
    }
}

@Composable
fun ThemeSwitch(
    isDarkMode: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onClick() }
            .background(if (isDarkMode) MaterialTheme.colorScheme.background else Color.LightGray)
            .border(BorderStroke(1.dp, MaterialTheme.colorScheme.outline))
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
            AnimatedVisibility(
                visible = isDarkMode,
                enter = fadeIn(animationSpec = tween(500)),
                exit = fadeOut(animationSpec = tween(500))
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextAbel("Dark", size = 18.sp)
                    SpaceW(size = 2.dp)
                    Icon(
                        imageVector = Icons.Default.DarkMode,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            AnimatedVisibility(
                visible = !isDarkMode,
                enter = fadeIn(animationSpec = tween(500)),
                exit = fadeOut(animationSpec = tween(500))
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextAbel("Light", size = 18.sp)
                    SpaceW(size = 2.dp)
                    Icon(
                        imageVector = Icons.Default.LightMode,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
    }
}