package shawn.martin.babybuy.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel

@Composable
fun LoginScreen(
    sharedViewModel: SharedViewModel,
    navigateToSignup: () -> Unit,
    navigateToHome: () -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        Text(text = "THIS IS Login SCREEN")
        Button(onClick = { navigateToSignup() }) {
            Text(text = "Go to Signup")
        }
        Button(onClick = { navigateToHome() }) {
            Text(text = "Go to Home")
        }
    }
}