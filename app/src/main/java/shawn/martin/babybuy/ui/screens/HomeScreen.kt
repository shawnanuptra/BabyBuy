package shawn.martin.babybuy.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel

@Composable
fun HomeScreen(
    sharedViewModel: SharedViewModel,
    navigateToItem: () -> Unit,
    navigateToWelcome: () -> Unit,
) {
    Column(
        Modifier.fillMaxSize()
    ) {
        Text(text = "THIS IS HOME SCREEN")
        Button(onClick = { navigateToItem() }) {
            Text(text = "Go to Item")
        }
        Button(onClick = { navigateToWelcome() }) {
            Text(text = "Go to Welcome")
        }
    }

}