package shawn.martin.babybuy.navigation.destination_composables

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import shawn.martin.babybuy.ui.screens.SignupScreen
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel
import shawn.martin.babybuy.util.Constants.ANIMATION_DURATION
import shawn.martin.babybuy.util.Constants.SIGNUP_SCREEN

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.signupComposable(
    sharedViewModel: SharedViewModel,
    navigateToLogin: () -> Unit,
) {
    composable(
        route = SIGNUP_SCREEN,
        enterTransition = {
            when {
                (initialState.destination.route == "welcome") ->
                    slideIntoContainer(
                        AnimatedContentScope.SlideDirection.Down,
                        tween(ANIMATION_DURATION)
                    )
                (initialState.destination.route == "login") ->
                    slideIntoContainer(
                        AnimatedContentScope.SlideDirection.Left
                    )
                else -> null
            }
        },
        exitTransition = {
            when {
                (targetState.destination.route == "login") ->
                    slideOutOfContainer(
                        AnimatedContentScope.SlideDirection.Right,
                        tween(ANIMATION_DURATION)
                    )
                (targetState.destination.route == "welcome") ->
                    slideOutOfContainer(
                        AnimatedContentScope.SlideDirection.Up,
                        tween(ANIMATION_DURATION)
                    )
                else -> slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Down,
                    tween(ANIMATION_DURATION)
                )
            }
        }

    ) { navBackStackEntry ->

        // DISPLAY UI SCREEN
        SignupScreen(
            sharedViewModel = sharedViewModel,
            navigateToLogin = navigateToLogin,
        )
    }
}