package shawn.martin.babybuy.ui.screens.item

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import shawn.martin.babybuy.ui.components.PrimaryButton
import shawn.martin.babybuy.ui.components.SecondaryButton
import shawn.martin.babybuy.ui.components.UploadMedia
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel
import shawn.martin.babybuy.util.Constants

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ItemScreen(
    sharedViewModel: SharedViewModel,
    navigateToHome: () -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .height(700.dp)
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = Constants.SCREEN_HORIZONTAL_PADDING.dp,
                    vertical = Constants.SCREEN_VERTICAL_PADDING.dp
                ),
            verticalArrangement = Arrangement.SpaceBetween


        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {

                Column {

                    Text(
                        text = "Name of Product",
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h5.fontSize
                    )
                    Divider(thickness = 3.dp, color = Color.Black)
                }
                Text(
                    text = "£33.01",
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h6.fontSize
                )
                OutlinedTextField(
                    value = TextFieldValue("Description.."),
                    onValueChange = {},
                    singleLine = false,
                    maxLines = 3,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(128.dp)
                        .border(2.dp, Color.Black),
                    label = { Text(text = "Description") }
                )
                UploadMedia(onClick = {})

            }


            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                PrimaryButton(onClick = navigateToHome, text = "Add Item")
                SecondaryButton(onClick = {}, text = "Cancel")
            }

        }

    }
}

@Composable
@Preview
fun ItemScreenPreview() {
    ItemScreen(sharedViewModel = SharedViewModel(), navigateToHome = {})
}