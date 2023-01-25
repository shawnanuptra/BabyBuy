package shawn.martin.babybuy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import shawn.martin.babybuy.navigation.SetUpNavigation
import shawn.martin.babybuy.ui.theme.BabyBuyTheme
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        //initialize SplashScreen
        installSplashScreen()
        setContent {
            BabyBuyTheme {
                navController = rememberAnimatedNavController()
                SetUpNavigation(navController = navController, sharedViewModel = sharedViewModel)

            }
        }
    }
}