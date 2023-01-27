package shawn.martin.babybuy.navigation

import androidx.navigation.NavController
import shawn.martin.babybuy.util.Constants.HOME_SCREEN
import shawn.martin.babybuy.util.Constants.ITEM_SCREEN
import shawn.martin.babybuy.util.Constants.LOGIN_SCREEN
import shawn.martin.babybuy.util.Constants.SIGNUP_SCREEN
import shawn.martin.babybuy.util.Constants.WELCOME_SCREEN

// Used to "map out" navigation of the navController
class Screens(navController: NavController) {

    val welcome = {
        navController.navigate(route = WELCOME_SCREEN) {
            popUpTo(WELCOME_SCREEN) { inclusive = true }
        }
    }
    val home = {
        navController.navigate(route = HOME_SCREEN) {
            popUpTo(LOGIN_SCREEN) { inclusive = true }
        }
    }
    val item = {
        navController.navigate(route = ITEM_SCREEN)
    }
    val login = {
        navController.navigate(route = LOGIN_SCREEN) {
            popUpTo(WELCOME_SCREEN) { inclusive = false }
        }
    }
    val signup = {
        navController.navigate(route = SIGNUP_SCREEN) {
            popUpTo(WELCOME_SCREEN) { inclusive = false }

        }
    }
}