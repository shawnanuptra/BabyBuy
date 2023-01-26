package shawn.martin.babybuy.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import shawn.martin.babybuy.R

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


@Composable
fun UploadMedia(
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        border = BorderStroke(2.dp, color = Color.Black),


        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.upload_media_button),
                fontSize = 18.sp,
                color = Color.Black
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_upload_24),
                contentDescription = "Upload Media Icon",
                modifier = Modifier.background(Color.Transparent),
                tint = Color.Black
            )
        }
    }
}

