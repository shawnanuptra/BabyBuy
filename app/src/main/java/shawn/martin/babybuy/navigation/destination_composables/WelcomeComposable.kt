package shawn.martin.babybuy.navigation.destination_composables

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import shawn.martin.babybuy.ui.screens.WelcomeScreen
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel
import shawn.martin.babybuy.util.Constants
import shawn.martin.babybuy.util.Constants.WELCOME_SCREEN

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.welcomeComposable(
    sharedViewModel: SharedViewModel,
    navigateToLogin: () -> Unit,
    navigateToSignup: () -> Unit,
) {
    composable(
        route = WELCOME_SCREEN,
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentScope.SlideDirection.Down,
                tween(Constants.ANIMATION_DURATION)
            )
        },

        ) { navBackStackEntry ->

        // DISPLAY UI SCREEN
        WelcomeScreen(
            sharedViewModel = sharedViewModel,
            navigateToLogin = navigateToLogin,
            navigateToSignup = navigateToSignup
        )
    }
}