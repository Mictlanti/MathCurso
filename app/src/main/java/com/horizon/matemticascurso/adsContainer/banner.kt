package com.horizon.matemticascurso.adsContainer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun AdvertView() {

    val isIneditMode = LocalInspectionMode.current

    AndroidView(modifier = Modifier.fillMaxWidth(), factory = { context ->
        AdView(context).apply {
            setAdSize(AdSize.BANNER)
            adUnitId = "ca-app-pub-5422732630069460~7741589767"
            //ca-app-pub-5422732630069460/4483642046
            loadAd(AdRequest.Builder().build())
        }
    })
}