package shawn.martin.babybuy.navigation.destination_composables

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import shawn.martin.babybuy.ui.screens.item.ItemScreen
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel
import shawn.martin.babybuy.util.Constants.ANIMATION_DURATION
import shawn.martin.babybuy.util.Constants.ITEM_SCREEN

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.itemComposable(
    sharedViewModel: SharedViewModel,
    navigateToHome: () -> Unit,
) {
    composable(
        route = ITEM_SCREEN,
//        enterTransition = {
//            slideIntoContainer(
//                AnimatedContentScope.SlideDirection.Left,
//                tween(ANIMATION_DURATION)
//            )
//        },
//        exitTransition = {
//            slideOutOfContainer(
//                AnimatedContentScope.SlideDirection.Right,
//                tween(ANIMATION_DURATION)
//            )
//        }

    ) { navBackStackEntry ->

        // DISPLAY UI SCREEN
        ItemScreen(
            sharedViewModel = sharedViewModel,
            navigateToHome = navigateToHome,
        )
    }
}