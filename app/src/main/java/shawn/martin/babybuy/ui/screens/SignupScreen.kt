package shawn.martin.babybuy.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel

@Composable
fun SignupScreen(
    sharedViewModel: SharedViewModel,
    navigateToLogin: () -> Unit,
) {
    Column(Modifier.fillMaxSize()) {
        Text(text = "THIS IS Signup SCREEN")
        Button(onClick = { navigateToLogin() }) {
            Text(text = "Go to Login")
        }
    }
}