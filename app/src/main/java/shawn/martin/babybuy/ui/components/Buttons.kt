package shawn.martin.babybuy.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    text: String
) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Text(text = text, fontSize = 18.sp)
    }
}

@Composable
fun SecondaryButton(
    onClick: () -> Unit,
    text: String
) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colors.primary)

    ) {
        Text(text = text, fontSize = 18.sp)
    }
}

