package shawn.martin.babybuy.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel

@Composable
fun ItemScreen(
    sharedViewModel: SharedViewModel,
    navigateToHome: () -> Unit,
) {
    Column(Modifier.fillMaxSize()) {
        Text(text = "THIS IS ITEM SCREEN")
        Button(onClick = { navigateToHome() }) {
            Text(text = "Go to Home")
        }
    }
}