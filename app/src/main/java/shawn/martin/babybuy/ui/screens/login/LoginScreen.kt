package shawn.martin.babybuy.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import shawn.martin.babybuy.R
import shawn.martin.babybuy.ui.components.PrimaryButton
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel
import shawn.martin.babybuy.util.Constants.SCREEN_HORIZONTAL_PADDING
import shawn.martin.babybuy.util.Constants.SCREEN_VERTICAL_PADDING

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    sharedViewModel: SharedViewModel,
    navigateToSignup: () -> Unit,
    navigateToHome: () -> Unit
) {
    Scaffold(
    ) { _ ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = SCREEN_HORIZONTAL_PADDING.dp,
                    vertical = SCREEN_VERTICAL_PADDING.dp
                ),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome,",
                    style = MaterialTheme.typography.h1
                )
                Text(
                    text = "happy to have you back!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            Column() {
                OutlinedTextField(value = "Email", onValueChange = {})
                Box(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = "Password", onValueChange = {})
                Box(modifier = Modifier.height(10.dp))
                Text(
                    text = "Forgot password?",
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            }

            PrimaryButton(
                onClick = navigateToHome,
                text = stringResource(id = R.string.log_in_button)
            )

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Don't have an account?")
                TextButton(onClick = { navigateToSignup() }) {
                    Text(
                        text = "Sign Up here.",
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                }

            }
        }
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    LoginScreen(sharedViewModel = SharedViewModel(), navigateToSignup = { }) {

    }
}