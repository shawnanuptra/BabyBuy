package shawn.martin.babybuy.ui.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import shawn.martin.babybuy.R
import shawn.martin.babybuy.data.Resource
import shawn.martin.babybuy.ui.components.PrimaryButton
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel
import shawn.martin.babybuy.util.Constants.SCREEN_HORIZONTAL_PADDING
import shawn.martin.babybuy.util.Constants.SCREEN_VERTICAL_PADDING

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignupScreen(
    sharedViewModel: SharedViewModel,
    navigateToLogin: () -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }
    var passworConfirmVisible by remember { mutableStateOf(false) }

    val signUpFlow = sharedViewModel.signUpFlow.collectAsState()

    Scaffold(
    ) { _ ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = SCREEN_HORIZONTAL_PADDING.dp,
                    vertical = SCREEN_VERTICAL_PADDING.dp
                ),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Hello there,",
                    style = MaterialTheme.typography.h1
                )
                Text(
                    text = "Excited to work with you!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal,
                    overflow = TextOverflow.Visible,
                    textAlign = TextAlign.Center
                )
            }

            // Fields
            Column() {

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    singleLine = true,
                    label = { Text("Email") },
                    placeholder = { Text("example1@gmail.com") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    visualTransformation = if (passwordVisible) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    singleLine = true,
                    label = { Text("Password") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType =
                        KeyboardType.Password
                    ),
                    trailingIcon = {
                        if (passwordVisible) {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(imageVector = Icons.Filled.Visibility, "Hide password")
                            }
                        } else {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(imageVector = Icons.Filled.VisibilityOff, "Show password")
                            }
                        }
                    }
                )
                Box(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    visualTransformation = if (passworConfirmVisible) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    singleLine = true,
                    label = { Text("Password") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType =
                        KeyboardType.Password
                    ),
                    trailingIcon = {
                        if (passworConfirmVisible) {
                            IconButton(onClick = {
                                passworConfirmVisible = !passworConfirmVisible
                            }) {
                                Icon(imageVector = Icons.Filled.Visibility, "Hide password")
                            }
                        } else {
                            IconButton(onClick = {
                                passworConfirmVisible = !passworConfirmVisible
                            }) {
                                Icon(imageVector = Icons.Filled.VisibilityOff, "Show password")
                            }
                        }
                    }
                )
                Box(modifier = Modifier.height(10.dp))
            }

            PrimaryButton(
                onClick = {
                    sharedViewModel.signUp(email, password)
                },
                text = stringResource(id = R.string.sign_up_button)
            )

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Already have an account?")
                TextButton(onClick = { navigateToLogin() }) {
                    Text(
                        text = "Log In here.",
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                }

            }
            signUpFlow.value.let {
                when (it) {
                    is Resource.Failure -> {
                        val context = LocalContext.current
                        Toast.makeText(context, it.exception.message, Toast.LENGTH_LONG).show()
                    }
                    Resource.Loading -> {
                        CircularProgressIndicator()
                    }
                    is Resource.Success -> {
                        LaunchedEffect(Unit) {
                            navigateToLogin()

                        }
                    }
                }
            }
        }
    }

}


@Composable
@Preview
fun SignupScreenPreview() {
//    SignupScreen(sharedViewModel = null, navigateToLogin = { })
}