package com.horizon.matemticascurso.adsContainer

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.views.components.titleLarge

val listExit = listOf("¿Seguro quieres volver al inicio?", "Aún no te rindas", "¿Salir a pantalla principal?")

@Composable
fun selectLevelTopic(
    isOpen: Boolean,
    onDismissRequest: () -> Unit,
    navController: NavController,
    context: Context
) {
    if (isOpen) {
        AlertDialog(
            onDismissRequest = onDismissRequest,
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    titleLarge(text = listExit.random())
                }
            },
            confirmButton = {
                secondInterstitialAds(navController = navController, context = context)
            },
            dismissButton = {
                TextButton(onClick = onDismissRequest) {
                    Text(text = "Cancelar", color = Color.White)
                }
            }
        )
    }
}

@Composable
fun secondInterstitialAds(
    context: Context,
    navController: NavController,
) {

    var interstitialAd by remember { mutableStateOf<InterstitialAd?>(null) }
    val btnText = remember { mutableStateOf("Cargando...") }
    val btnEnabled = remember { mutableStateOf(false) }

    fun loadInterstitialAd() {
        InterstitialAd.load(
            context,
            "ca-app-pub-3940256099942544/1033173712",
            //ca-app-pub-5422732630069460/2209946854
                    AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    interstitialAd = null
                    btnText.value = "Error al cargar anuncio"
                    btnEnabled.value = false
                }

                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    btnText.value = "Ir a Home"
                    btnEnabled.value = true
                }
            }
        )
    }

    fun showInterstitialAd(onAdDismissed: () -> Unit) {
        val activity = context as? Activity
        if (activity == null) {
            Toast.makeText(context, "Activity context not available", Toast.LENGTH_SHORT).show()
            return
        }

        interstitialAd?.let { ad ->
            ad.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    interstitialAd = null
                    btnText.value = "Error al mostrar anuncio"
                    btnEnabled.value = false
                    loadInterstitialAd()
                }

                override fun onAdDismissedFullScreenContent() {
                    interstitialAd = null
                    loadInterstitialAd()
                    onAdDismissed()
                    btnText.value = "Cargando..."
                    btnEnabled.value = false
                }
            }
            ad.show(activity)
        } ?: run {
            Toast.makeText(context, "Anuncio no disponible", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(Unit) {
        loadInterstitialAd()
    }

    TextButton(
        enabled = btnEnabled.value,
        onClick = {
            showInterstitialAd {
                Toast.makeText(context, "Interstitial Ad Shown!", Toast.LENGTH_SHORT).show()
                navController.navigate(AppScreens.homeScreenRoute.route)
            }
        }
    ) {
        Text(
            text = btnText.value,
            color = when (btnEnabled.value) {
                true -> Color.Red
                false -> Color.Gray
            }
        )
    }
}