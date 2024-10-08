package com.infomanix.newcheetah_v110

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.infomanix.newcheetah_v110.ui.theme.NewCheetah_v110Theme

class MainActivity : ComponentActivity() {
    private val newsAppViewModel: NewsAppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewCheetah_v110Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    NewsCheetahApp(newsAppViewModel)
                }
            }
        }
    }
}

@Composable
fun NewsCheetahApp(newsAppViewModel: NewsAppViewModel = viewModel()){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash",
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = 200)
            ) + fadeIn(animationSpec = tween(durationMillis = 200))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 200)
            ) + fadeOut(animationSpec = tween(durationMillis = 200))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 200)
            ) + fadeIn(animationSpec = tween(durationMillis = 200))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = 200)
            ) + fadeOut(animationSpec = tween(durationMillis = 200))
        }
    ){
        composable("splash") { SplashScreen(navController) }
        composable("home") { Home(navController,newsAppViewModel) }
        composable(
            route = "customgame/{lowerLim}/{upperLim}/{maxtrials}",
            arguments = listOf(
                navArgument("lowerLim") { type = NavType.StringType },
                navArgument("upperLim") { type = NavType.StringType },
                navArgument("maxtrials") { type = NavType.StringType }
            )
        ) {

        }
    }
}