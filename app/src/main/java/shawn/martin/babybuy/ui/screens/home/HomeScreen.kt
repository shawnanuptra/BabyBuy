package shawn.martin.babybuy.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import shawn.martin.babybuy.ui.components.ListItem
import shawn.martin.babybuy.ui.screens.home.HomeTitle
import shawn.martin.babybuy.ui.screens.item.ItemScreen
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel
import shawn.martin.babybuy.util.Constants.SCREEN_HORIZONTAL_PADDING
import shawn.martin.babybuy.util.ItemStatus

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    sharedViewModel: SharedViewModel,
    navigateToItem: () -> Unit,
    navigateToWelcome: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )
    val scope = rememberCoroutineScope()

    fun toggleModalSheet(scope: CoroutineScope, sheetState: ModalBottomSheetState) {
        scope.launch {
            if (sheetState.isVisible) sheetState.hide() else sheetState.show()
        }
    }



    Scaffold() { padding ->
        ModalBottomSheetLayout(
            modifier = Modifier.fillMaxSize(),

            sheetState = sheetState,
            sheetElevation = 8.dp,
            sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
            sheetContent = {
                ItemScreen(
                    sharedViewModel = sharedViewModel,
                    navigateToHome = {
                        toggleModalSheet(
                            scope,
                            sheetState
                        )
                    }
                )
            }
        ) {
            Scaffold(
                floatingActionButton = {
                    MyFAB(
                        onClicked = {
                            toggleModalSheet(
                                scope,
                                sheetState
                            )
                        }
                    )
                },
            ) { padding ->

                Column(modifier = Modifier.padding(horizontal = SCREEN_HORIZONTAL_PADDING.dp)) {
                    HomeTitle(
                        1f,
                        navigateToWelcome = navigateToWelcome,
                        sharedViewModel = sharedViewModel,
                    )
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(8f),
                        verticalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        items(5) {
                            ListItem(
                                sharedViewModel.currentUser?.uid ?: "not login",
                                52,
                                ItemStatus.PURCHASED
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }

            }
        }

    }


}


@Composable
fun MyFAB(onClicked: () -> Unit) {
    FloatingActionButton(onClick = { onClicked() }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "FAB")
    }
}

//
//@Composable
//fun BottomSheetContent() {
//    Surface(
//        modifier = Modifier.height(800.dp),
//        color = Color(0xff9c7ca5)
//    ) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "Modal Bottom Sheet", fontSize = 20.sp, modifier = Modifier.padding(10.dp),
//                color = Color.White, fontWeight = FontWeight.ExtraBold
//            )
//            Divider(modifier = Modifier.padding(5.dp), color = Color.White)
//            Text(
//                text = "Modal Bottom sheets present a set of choices while blocking interaction with " +
//                        "the rest of the screen. They are an alternative to inline menus and simple dialogs on mobile, " +
//                        "providing additional room for content, iconography, and actions.",
//                fontSize = 15.sp,
//                fontStyle = FontStyle.Italic,
//                color = Color.White,
//                modifier = Modifier.padding(10.dp)
//            )
//        }
//    }
//}

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun HomeScreenPreview() {
//    HomeScreen(sharedViewModel = SharedViewModel(), navigateToItem = {}, navigateToWelcome = {})
}