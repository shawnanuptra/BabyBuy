package shawn.martin.babybuy.navigation.destination_composables

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import shawn.martin.babybuy.ui.screens.HomeScreen
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel
import shawn.martin.babybuy.util.Constants.ANIMATION_DURATION
import shawn.martin.babybuy.util.Constants.HOME_SCREEN


@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)
fun NavGraphBuilder.homeComposable(
    sharedViewModel: SharedViewModel,
    navigateToItem: () -> Unit,
    navigateToWelcome: () -> Unit,
) {
    composable(
        route = HOME_SCREEN,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentScope.SlideDirection.Left,
                tween(ANIMATION_DURATION)
            )
        }
    ) { navBackStackEntry ->

        // DISPLAY UI SCREEN
        HomeScreen(
            sharedViewModel = sharedViewModel,
            navigateToItem = navigateToItem,
            navigateToWelcome = navigateToWelcome
        )
    }
}