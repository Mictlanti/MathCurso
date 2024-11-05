package com.horizon.matemticascurso.views.main

import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.GoogleAuthProvider
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.data.firebase.AuthManager
import com.horizon.matemticascurso.data.firebase.AuthRes
import com.horizon.matemticascurso.views.components.headLineLargeHome
import com.horizon.matemticascurso.ui.theme.personForTitle
import kotlinx.coroutines.launch

@Composable
fun loginScreen(
    analytics: FirebaseAnalytics,
    navController: NavController,
    authManager: AuthManager
) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val googleSignInLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()) { result ->
        when(val account = authManager.handleSignInResult(GoogleSignIn.getSignedInAccountFromIntent(result.data))) {
            is AuthRes.Success -> {
                val credential = GoogleAuthProvider.getCredential(account?.data?.idToken, null)
                scope.launch {
                    val fireUser = authManager.signInWithGoogleCredential(credential)
                    if (fireUser != null) {
                        Toast.makeText(context, "Bienvenido", Toast.LENGTH_SHORT).show()
                        navController.navigate(AppScreens.homeScreenRoute.route)
                    }
                }
            }
            is AuthRes.Error -> {
                Toast.makeText(context, "Error: ${account.errorMessage}", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(context, "Error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }
    val listBtns = listOf("Continuar como invitado", "Continuar con Google")
    fun onClickBtnTwo() {
        authManager.signInWithGoogle(googleSignInLauncher)
    }
    val fillMaxSize = Modifier.fillMaxSize()
    val composition = rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.background_app))
    val progress by animateLottieCompositionAsState(
        composition = composition.value,
        iterations = LottieConstants.IterateForever
    )
    
    Box(modifier = fillMaxSize){
        LottieAnimation(
            modifier = fillMaxSize,
            composition = composition.value,
            progress = { progress },
            contentScale = ContentScale.FillBounds
        )
    }
    
    Column(
        modifier = fillMaxSize
            .padding(horizontal = 30.dp, vertical = 75.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(40.dp))
        headLineLargeHome(title = "Iniciar sesión en")
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Resuelve, aprende y domina las matemáticas a tu ritmo.",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(30.dp))
        listBtns.forEachIndexed { index, s ->
            btnLoading(
                onClickBtn = {
                when(index) {
                    0 -> scope.launch {
                        incognitoSignIn(authManager, context, navController)
                    }
                    1 -> onClickBtnTwo()
                }
            },
                color = when(index) {
                    0 -> MaterialTheme.colorScheme.scrim
                    1 -> MaterialTheme.colorScheme.onBackground
                    else -> MaterialTheme.colorScheme.onBackground
                },
                painter = when(index) {
                    0 -> painterResource(id = R.drawable.ic_anonymously)
                    1 -> painterResource(id = R.drawable.icon_google_account)
                    else -> painterResource(id = R.drawable.ic_error)
                },
                access = s,
                colorText = when(index) {
                    0 -> MaterialTheme.colorScheme.onBackground
                    1 -> MaterialTheme.colorScheme.background
                    else -> MaterialTheme.colorScheme.background
                }
            )
        }
    }
}

@Composable
fun loadingText(
    text: String,
    fontFamily: FontFamily = personForTitle,
    fontWeight: FontWeight = FontWeight.W700,
    fontSize: TextUnit = 18.sp,
    lineHeight: TextUnit = 42.sp,
    color: Color
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

@Composable
fun btnLoading(
    onClickBtn: () -> Unit,
    color: Color,
    painter: Painter,
    access: String,
    colorText: Color
) {
    Button(
        onClick = onClickBtn,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            loadingText(text = access, color = colorText)
        }
    }
}

private suspend fun incognitoSignIn(authManager: AuthManager, context: Context, navController: NavController) {
    when(val result = authManager.singInAnonymously()) {
        is AuthRes.Success-> {
            navController.navigate(AppScreens.homeScreenRoute.route)
        }
        is AuthRes.Error -> {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        }

        else -> {
            null
        }
    }
}

@Composable
fun ExitSessionView(
    showDialog: Boolean,
    exit: () -> Unit,
    onDismiss: () -> Unit
) {
    if(showDialog){
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = "Cerrar sesión") },
            text = { Text(text = "¿Desea cerrar sesión?") },
            confirmButton = {
                TextButton(onClick = exit) {
                    Text(
                        text = "Aceptar",
                        color = Color.Red
                    )
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
}