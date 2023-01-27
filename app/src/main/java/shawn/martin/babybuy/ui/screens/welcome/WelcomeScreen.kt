package shawn.martin.babybuy.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import shawn.martin.babybuy.R
import shawn.martin.babybuy.ui.components.PrimaryButton
import shawn.martin.babybuy.ui.components.SecondaryButton
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel
import shawn.martin.babybuy.util.Constants.SCREEN_HORIZONTAL_PADDING

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WelcomeScreen(
    sharedViewModel: SharedViewModel,
    navigateToLogin: () -> Unit,
    navigateToSignup: () -> Unit,
) {
    Scaffold(
    ) { _ ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = SCREEN_HORIZONTAL_PADDING.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(painterResource(id = R.drawable.ic_logo), contentDescription = "BabyBuy Logo")


            Column() {

                PrimaryButton(
                    onClick = navigateToLogin,
                    text = stringResource(id = R.string.log_in_button)
                )
                Box(modifier = Modifier.height(15.dp))
                SecondaryButton(
                    onClick = navigateToSignup,
                    text = stringResource(id = R.string.sign_up_button)
                )
            }
        }
    }
}


@Composable
@Preview
fun WelcomeScreenPreview() {
//    WelcomeScreen(sharedViewModel = SharedViewModel(), navigateToLogin = { }) {
//    }
}