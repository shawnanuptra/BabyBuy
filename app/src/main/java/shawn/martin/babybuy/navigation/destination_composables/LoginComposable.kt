package shawn.martin.babybuy.navigation.destination_composables

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import shawn.martin.babybuy.ui.screens.LoginScreen
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel
import shawn.martin.babybuy.util.Constants.ANIMATION_DURATION
import shawn.martin.babybuy.util.Constants.LOGIN_SCREEN

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.loginComposable(
    sharedViewModel: SharedViewModel,
    navigateToSignup: () -> Unit,
    navigateToHome: () -> Unit
) {
    composable(
        route = LOGIN_SCREEN,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentScope.SlideDirection.Left,
                tween(ANIMATION_DURATION)
            )
        },
    ) { navBackStackEntry ->

        // DISPLAY UI SCREEN
        LoginScreen(
            sharedViewModel = sharedViewModel,
            navigateToSignup = navigateToSignup,
            navigateToHome = navigateToHome
        )
    }
}