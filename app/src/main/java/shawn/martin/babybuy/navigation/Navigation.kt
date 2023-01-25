package shawn.martin.babybuy.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import shawn.martin.babybuy.navigation.destination_composables.*
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel
import shawn.martin.babybuy.util.Constants.HOME_SCREEN
import shawn.martin.babybuy.util.Constants.WELCOME_SCREEN

// Function going to be called in MainActivity.kt
// Wraps the app with AnimatedNavigationController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SetUpNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController)
    }


    // NavHost, so all Composables can be animated
    AnimatedNavHost(navController = navController, startDestination = WELCOME_SCREEN) {
        homeComposable(
            sharedViewModel = sharedViewModel,
            navigateToItem = screen.item,
            navigateToWelcome = screen.welcome,
        )
        itemComposable(
            sharedViewModel = sharedViewModel,
            navigateToHome = screen.home
        )
        loginComposable(
            sharedViewModel = sharedViewModel,
            navigateToHome = screen.home,
            navigateToSignup = screen.signup
        )
        signupComposable(
            sharedViewModel = sharedViewModel,
            navigateToLogin = screen.login
        )
        welcomeComposable(
            sharedViewModel = sharedViewModel,
            navigateToLogin = screen.login,
            navigateToSignup = screen.signup
        )
    }

}
