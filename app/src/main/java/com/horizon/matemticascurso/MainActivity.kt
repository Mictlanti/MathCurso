package com.horizon.matemticascurso

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.logEvent
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import com.horizon.matemticascurso.data.dataStore.DataPreferences
import com.horizon.matemticascurso.data.firebase.AuthManager
import com.horizon.matemticascurso.ui.theme.AppTheme
import com.horizon.matemticascurso.views.BasesAlge1.sessionOne.GraficaRectaoneScreenRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionOne.PuntosPlanoOneScreenRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionOne.basicOperationRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionOne.multiPoliOneScreenRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionOne.simpli2OneScreenRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionOne.tranforScreenRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionThree.GraficaRectaThreeScreenRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionThree.PuntosPlanoThreeScreenRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionThree.multiPoliThreeScreenRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionThree.simpli2ThreeScreenRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionThree.simplificacionScreenRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionTwo.GraficaRectaTwoScreenRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionTwo.PuntosPlanoTwoScreenRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionTwo.basicOperationRouteTwo
import com.horizon.matemticascurso.views.BasesAlge1.sessionTwo.multiPoliTwoScreenRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionTwo.simpli2TwoScreenRoute
import com.horizon.matemticascurso.views.BasesAlge1.sessionTwo.transforEcuaTwoScreenRoute
import com.horizon.matemticascurso.views.BasesAlge2.EcuaLinealesScreenRoute
import com.horizon.matemticascurso.views.SplashScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.SistemEcua3ScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessioThree.Facto1ThreeScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessioThree.Facto2ThreeScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessioThree.Facto3ThreeScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessionOne.Facto1OneScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessionOne.Facto2OneScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessionOne.Facto3OneScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessionTwo.Facto1TwoScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessionTwo.Facto2TwoScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessionTwo.Facto3TwoScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionOne.DesigualLinealOneScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionOne.LeyExpoOneScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionOne.ProducNotaOneScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionOne.SistemEcua1OneScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionOne.SistemEcua2OneScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionThree.DesigualLinealThreeScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionThree.LeyExpoThreeScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionThree.ProducNotaThreeScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionThree.SistemEcua1ThreeScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionThree.SistemEcua2ThreeScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionTwo.DesigualLinealTwoScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionTwo.LeyExpoTwoScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionTwo.ProducNotaTwoScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionTwo.SistemEcua1TwoScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra1.sessionTwo.SistemEcua2TwoScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra3.sessionOne.DesaPolinoScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra3.sessionOne.NumIrraScreenRoute
import com.horizon.matemticascurso.views.algebra.algebra3.sessionOne.RaizRoute
import com.horizon.matemticascurso.views.algebra.algebra3.sessionTwo.raizTwoScreenRoute
import com.horizon.matemticascurso.views.favoriteView.FavoriteScreen
import com.horizon.matemticascurso.views.main.HomeScreeRoute
import com.horizon.matemticascurso.views.main.loginScreen
import com.horizon.matemticascurso.vms.FavoriteViewModel
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var analytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics = Firebase.analytics

        setContent {
            val context = LocalContext.current
            val userStateVM: UserStateVM = viewModel(
                factory = RealtimeManagerFactory(dataPref = DataPreferences(context))
            )
            val favoriteVM : FavoriteViewModel by viewModels()
            AppTheme(userStateVM = userStateVM) {
                navigation(analytics, context, userStateVM, favoriteVM)
            }
        }
    }
}

@Composable
fun navigation(analytics: FirebaseAnalytics, context: Context, userStateVM: UserStateVM,favoriteVM : FavoriteViewModel) {

    val navController = rememberNavController()
    val auth: AuthManager = AuthManager(context)
    val user: FirebaseUser? = auth.getCurrentUser()
    val sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    val topicViewModel : TopicVM = viewModel()
    /*val realtimeDbManager: UserStateVM = viewModel(
        factory = RealtimeManagerFactory(database = RealtimeDbManager(auth), dataPref = DataPreferences(ctx), application)
    ) */

    NavHost(
        navController = navController,
        startDestination = if(user == null) AppScreens.loginScreen.route else AppScreens.splashScreenRoute.route
    ) {
        composable(route = AppScreens.splashScreenRoute.route) {
            SplashScreenRoute(navController)
        }
        composable(route = AppScreens.loginScreen.route) {
            loginScreen(analytics,navController, authManager = auth)
        }
        composable(route = AppScreens.homeScreenRoute.route) {
            HomeScreeRoute(navController, auth, userStateVM, sharedPreferences)
        }
        composable(route = AppScreens.favoriteScreen.route) {
            FavoriteScreen(favoriteVM, navController)
        }
        composable(route = AppScreens.basicOperation.route) {
            basicOperationRoute(navController, analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.basicOperationTwo.route) {
            basicOperationRouteTwo(navController, analytics, topicViewModel)
        }
        composable(route = AppScreens.simplificacionScreen.route) {
            simplificacionScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.transformEcua.route) {
            tranforScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.transformEcuaTwo.route) {
            transforEcuaTwoScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.leyExpoOne.route) {
            LeyExpoOneScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.leyExpoTwo.route) {
            LeyExpoTwoScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.leyExpoThree.route) {
            LeyExpoThreeScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.multiPoliOne.route) {
            multiPoliOneScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.multiPoliTwo.route) {
            multiPoliTwoScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.multiPoliThree.route) {
            multiPoliThreeScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.simpli2One.route) {
            simpli2OneScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.simpli2Two.route) {
            simpli2TwoScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.simpli2Three.route) {
            simpli2ThreeScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.ecuaLineales.route) {
            EcuaLinealesScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.puntosDePlanoOne.route) {
            PuntosPlanoOneScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.punPlanoTwo.route) {
            PuntosPlanoTwoScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.punPlaThree.route) {
            PuntosPlanoThreeScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.grafiRectaOne.route) {
            GraficaRectaoneScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.grafiRectaTwo.route) {
            GraficaRectaTwoScreenRoute(navController, analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.grafiRectaThree.route) {
            GraficaRectaThreeScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.sitemaEcua1.route) {
            SistemEcua1OneScreenRoute(navController, analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.sistemEcua1Two.route) {
            SistemEcua1TwoScreenRoute(navController, analytics = analytics, topicViewModel,userStateVM)
        }
        composable(route = AppScreens.sistemEcua1Three.route) {
            SistemEcua1ThreeScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.sistemaEcua2.route) {
            SistemEcua2OneScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.sistemaEcua2Two.route) {
            SistemEcua2TwoScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.sistemaEcua2Three.route) {
            SistemEcua2ThreeScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.desigualLineales.route) {
            DesigualLinealOneScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.desigualLinealesTwo.route) {
            DesigualLinealTwoScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.desigualLinealesThree.route) {
            DesigualLinealThreeScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.producNotaOne.route) {
            ProducNotaOneScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.producNotaTwo.route) {
            ProducNotaTwoScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.producNotaThree.route) {
            ProducNotaThreeScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.facto1One.route) {
            Facto1OneScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.facto1Two.route) {
            Facto1TwoScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.facto1Three.route) {
            Facto1ThreeScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.facto2One.route) {
            Facto2OneScreenRoute(navController, analytics = analytics, topicViewModel, userStateVM)
        }
        composable(route = AppScreens.facto2Two.route) {
            Facto2TwoScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.facto2Three.route) {
            Facto2ThreeScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.facto3One.route) {
            Facto3OneScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.facto3Two.route) {
            Facto3TwoScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.facto3Three.route) {
            Facto3ThreeScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.raices.route) {
            RaizRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.raizTwo.route) {
            raizTwoScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.numIrracionales.route) {
            NumIrraScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.sistemaEcua3.route) {
            SistemEcua3ScreenRoute(navController, analytics = analytics, topicViewModel)
        }
        composable(route = AppScreens.desarrolloPoli.route) {
            DesaPolinoScreenRoute(navController, analytics = analytics, topicViewModel)
        }
    }
}

@Composable
fun analyticsTrackScreen(name: String, analytics: FirebaseAnalytics) {
    DisposableEffect(Unit) {
        onDispose {
            analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
                param(FirebaseAnalytics.Param.SCREEN_NAME, name)
            }
        }
    }
}

class RealtimeManagerFactory(
    //private val database: RealtimeDbManager,
    private val dataPref: DataPreferences,
    //private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserStateVM::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserStateVM(dataPref) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}