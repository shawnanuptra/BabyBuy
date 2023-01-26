package shawn.martin.babybuy.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import shawn.martin.babybuy.ui.theme.Shapes
import shawn.martin.babybuy.util.ItemStatus
import java.text.DecimalFormat

@Composable
fun ListItem(
    name: String,
    cost: Number,
    itemStatus: ItemStatus,
    //TODO: pass item properties to ItemScreen to be able to edit
) {
    Surface(
        modifier = Modifier

            .fillMaxWidth()
            .height(80.dp),
        shape = Shapes.small,
        contentColor = Color.Black,
        border = BorderStroke(1.dp, Color.Black)

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column(Modifier.weight(2f)) {
                Text(text = name, style = MaterialTheme.typography.h6)
                Text(text = "$itemStatus", style = MaterialTheme.typography.subtitle2)
            }
            Divider(
                modifier = Modifier
                    .fillMaxHeight(0.7f)
                    .width(2.dp),
                color = Color.Black
            )
            Text(
                text = "£50",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@Preview
fun ListItemPreview() {
    ListItem("Item Name", 54.30, ItemStatus.PURCHASED)
}