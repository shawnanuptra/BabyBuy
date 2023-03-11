package shawn.martin.babybuy.ui.screens

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import shawn.martin.babybuy.R
import shawn.martin.babybuy.data.AuthRepositoryImpl
import shawn.martin.babybuy.data.Resource
import shawn.martin.babybuy.ui.components.PrimaryButton
import shawn.martin.babybuy.ui.viewmodels.SharedViewModel
import shawn.martin.babybuy.util.Constants.SCREEN_HORIZONTAL_PADDING
import shawn.martin.babybuy.util.Constants.SCREEN_VERTICAL_PADDING

@Stable
data class StableWrapper<T>(val value: T)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    sharedViewModel: SharedViewModel,
    navigateToSignup: () -> Unit,
    navigateToHome: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val loginFlow = sharedViewModel.loginFlow.collectAsState()
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
                    text = "Welcome,",
                    style = MaterialTheme.typography.h1
                )
                Text(
                    text = "happy to have you back!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            Column() {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    singleLine = true,
                    label = { Text("Email") },
                    placeholder = { Text("example1@gmail.com") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                Box(modifier = Modifier.height(10.dp))
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
                Text(
                    text = "Forgot password?",
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            }

            PrimaryButton(
                onClick = {
                    sharedViewModel.logIn(email, password)

                },
                text = stringResource(id = R.string.log_in_button)
            )

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Don't have an account?")
                TextButton(onClick = { navigateToSignup() }) {
                    Text(
                        text = "Sign Up here.",
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                }

            }
        }
        loginFlow.value.let {
            when (it) {
                is Resource.Failure -> {
                    Log.d("test", "Code goers here")
                    Toast.makeText(LocalContext.current, it.exception.message, Toast.LENGTH_LONG)
                        .show()

                }
                Resource.Loading -> {
                    CircularProgressIndicator()
                }
                is Resource.Success -> {
                    LaunchedEffect(Unit) {
                        navigateToHome()

                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    LoginScreen(
        sharedViewModel = SharedViewModel(repository = AuthRepositoryImpl(FirebaseAuth.getInstance())),
        navigateToSignup = { }) {

    }
}