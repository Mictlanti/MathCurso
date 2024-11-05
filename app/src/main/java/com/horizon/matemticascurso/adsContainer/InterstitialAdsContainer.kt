package com.horizon.matemticascurso.adsContainer

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.vms.TopicVM

@Composable
fun intertitialAdsContainer(
    navController: NavController,
    destination: AppScreens,
    topicVM: TopicVM
) {
    var interstitialAd by remember { mutableStateOf<InterstitialAd?>(null) }
    val btnText = remember { mutableStateOf("Cargando...") }
    val btnEnabled = remember { mutableStateOf(false) }
    val context = LocalContext.current

    fun loadInterstitialAd() {
        InterstitialAd.load(
            context,
            "ca-app-pub-3940256099942544/1033173712",
            //ca-app-pub-5422732630069460/5586395170
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    interstitialAd = null
                    btnText.value = "Error al cargar anuncio"
                    btnEnabled.value = false
                }

                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    btnText.value = "Siguiente tema"
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


    Button(
        enabled = btnEnabled.value,
        onClick = {
            showInterstitialAd {
                Toast.makeText(context, "Interstitial Ad Shown!", Toast.LENGTH_SHORT).show()
                navController.navigate(destination.route)
                topicVM.resetAds()
            }
        },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = btnText.value)
    }
}


/*@Composable
fun intertitialAdsContainer(
    navController: NavController,
    destination: AppScreens
) {
    var interstitialAd by remember { mutableStateOf<InterstitialAd?>(null) }
    val btnText = remember { mutableStateOf("Cargando...") }
    val btnEnabled = remember { mutableStateOf(false) }
    val context = LocalContext.current

    fun loadInterstitialAd() {
        InterstitialAd.load(
            context,
            "ca-app-pub-3940256099942544/1033173712",
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    interstitialAd = null
                    btnText.value = "Error al cargar anuncio"
                    btnEnabled.value = false
                }

                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    btnText.value = "Siguiente tema"
                    btnEnabled.value = true
                }
            }
        )
    }

    fun showInterstitialAd(onAdDismissed: () -> Unit) {
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
            ad.show(context as Activity)
        } ?: run {
            Toast.makeText(context, "Anuncio no disponible", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(Unit) {
        loadInterstitialAd()
    }

    Button(
        enabled = btnEnabled.value,
        onClick = {
            showInterstitialAd {
                Toast.makeText(context, "Interstitial Ad Shown!", Toast.LENGTH_SHORT).show()
                navController.navigate(destination.route)
            }
        },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = btnText.value)
    }
}  */