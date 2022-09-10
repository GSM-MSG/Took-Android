package com.msg.presentation.ui.start

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.msg.presentation.ui.confirm.ConfirmScreen
import com.msg.presentation.ui.login.LoginScreen
import com.msg.presentation.ui.registration.RegistrationActivity
import com.msg.presentation.ui.signup.SignUpScreen

class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartNavigation()
        }
    }

    @Composable
    fun StartNavigation() {
        val navController = rememberNavController()
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = "start"
        ) {
            composable("start") {
                StartScreen(
                    toLogin = { navController.navigate("login") },
                    toSignUp = { navController.navigate("signup") }
                )
            }
            composable("login") {
                LoginScreen(
                    back = { navController.popBackStack() },
                    toMain = {
                        startActivity(
                            Intent(
                                this@StartActivity,
                                RegistrationActivity::class.java
                            )
                        )
                    },
                    toSignUp = { navController.navigate("signup") }
                )
            }
            composable("signup") {
                SignUpScreen(
                    back = { navController.popBackStack() },
                    toLogin = { navController.navigate("login") },
                    toConfirm = { navController.navigate("confirm") }
                )
            }
            composable("confirm") {
                ConfirmScreen()
            }
        }
    }
}