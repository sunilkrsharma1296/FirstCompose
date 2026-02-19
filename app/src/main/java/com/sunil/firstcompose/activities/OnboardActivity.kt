package com.sunil.firstcompose.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class OnboardActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.systemBars) // 🔥 THIS FIXES OVERLAP
        ) {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination="registration"){
                composable(route="registration"){
                    RegistrationScreen{
                        navController.navigate("newMainScreen/${it}")
                    }
                }

                composable(route="login"){
                    LoginScreen()
                }

                composable("newMainScreen/{email}", arguments = listOf(
                    navArgument("email"){
                        type = NavType.StringType
                    }
                )){
                    val email = it.arguments?.getString("email")
                    Toast.makeText(this@OnboardActivity, email, Toast.LENGTH_SHORT).show()
                    NewMainScreen(email)
                }
            }

        }
    }

    @Composable
    fun RegistrationScreen(onClick: (email: String) -> Unit) {
        Text("Registration",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.clickable {
                onClick("sunil@gmail.com")
            }
        )
    }

    @Composable
    fun LoginScreen() {
        Text("Login", style = MaterialTheme.typography.headlineLarge)
    }

    @Composable
    fun NewMainScreen(email: String?) {
        Text("New Main Screen-> $email", style = MaterialTheme.typography.headlineLarge)
    }
}