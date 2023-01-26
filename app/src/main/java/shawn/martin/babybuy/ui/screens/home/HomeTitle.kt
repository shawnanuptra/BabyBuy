package shawn.martin.babybuy.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import shawn.martin.babybuy.R

@Composable
fun ColumnScope.HomeTitle(weight: Float, navigateToWelcome: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .weight(weight),
        verticalArrangement = Arrangement.Center
    ) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = stringResource(id = R.string.home_title),
                style = MaterialTheme.typography.h1
            )

            //Icon to logout
            IconButton(onClick = { navigateToWelcome() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_logout_24),
                    contentDescription = "Log out button"
                )
            }
        }

        Divider(
            thickness = 3.dp,
            color = Color.Black,
            modifier = Modifier.padding(top = 2.dp)
        )

    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Preview
fun HomeTitlePreview() {
    Scaffold() {

            _ ->
        Column(Modifier.fillMaxSize()) {
            HomeTitle(weight = 1f, navigateToWelcome = {})
            Spacer(Modifier.weight(9f))
        }
    }
}
