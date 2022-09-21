package com.msg.presentation.ui.start

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.msg.presentation.ui.change_password.ChangePasswordScreen
import com.msg.presentation.ui.change_password.ConfirmEmailScreen
import com.msg.presentation.ui.confirm.ConfirmScreen
import com.msg.presentation.ui.login.LoginScreen
import com.msg.presentation.ui.registration.RegistrationActivity
import com.msg.presentation.ui.signup.SignUpScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartNavigation()
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun StartNavigation() {
        val navController = rememberAnimatedNavController()
        AnimatedNavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = "start"
        ) {
            composable(
                route = "start",
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None }) {
                StartScreen(
                    toLogin = { navController.navigate(route = "login") },
                    toSignUp = { navController.navigate(route = "signup") }
                )
            }
            composable(
                route = "login",
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None }) {
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
                    toSignUp = { navController.navigate(route = "signup") {
                        popUpTo("start")
                    } },
                    toPassword = { navController.navigate(route = "confirm_email") }
                )
            }
            composable(
                route = "signup",
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None }) {
                SignUpScreen(
                    back = { navController.popBackStack() },
                    toLogin = { navController.navigate(route = "login") {
                        popUpTo("start")
                    } },
                    toConfirm = { navController.navigate(route = "confirm") }
                )
            }
            composable(
                route = "confirm",
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None }) {
                ConfirmScreen(
                    back = { navController.popBackStack() },
                    toNext = {
                        startActivity(
                            Intent(
                                this@StartActivity,
                                RegistrationActivity::class.java
                            )
                        )
                    }
                )
            }
            composable(
                route = "confirm_email",
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None }) {
                ConfirmEmailScreen(
                    back = { navController.popBackStack() },
                    toNext = {
                        navController.navigate(route = "confirm_password") {
                            popUpTo(route = "login")
                        }
                    }
                )
            }
            composable(
                route = "confirm_password",
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None }) {
                ConfirmScreen(
                    back = { navController.popBackStack() },
                    toNext = {
                        navController.navigate(route = "change_password") {
                            popUpTo(route = "login")
                        }
                    }
                )
            }
            composable(
                route = "change_password",
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None }) {
                ChangePasswordScreen(
                    back = { navController.popBackStack() },
                    toLogin = {
                        navController.navigate(route = "login") {
                            popUpTo(route = "start")
                        }
                    }
                )
            }
        }
    }
}