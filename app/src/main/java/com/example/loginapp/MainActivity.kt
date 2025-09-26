package com.example.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.loginapp.screens.LoginScreen
import com.example.loginapp.screens.LoginScreenRoute
import com.example.loginapp.screens.RegisterScreen
import com.example.loginapp.screens.RegisterScreenRoute
import com.example.loginapp.ui.theme.LoginAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = false,
                                onClick = {navController.navigate(LoginScreenRoute){
                                    launchSingleTop = true
                                    //Grafo Splash Screen
                                    popUpTo(navController.graph.startDestinationId){
                                        saveState = true
                                    }
                                    restoreState = true
                                }},
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = "home"
                                    )
                                },
                                label = {
                                    Text(
                                        text = "Login"
                                    )
                                }
                            )

                            NavigationBarItem(
                                selected = false,
                                onClick = {navController.navigate(RegisterScreenRoute){
                                    launchSingleTop = true
                                    //Grafo Splash Screen
                                    popUpTo(navController.graph.startDestinationId){
                                        saveState = true
                                    }
                                    restoreState = true
                                }},
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "favorites"
                                    )
                                },
                                label = {
                                    Text(
                                        text = "Register"
                                    )
                                }
                            )
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = LoginScreenRoute
                    ){

                        composable<LoginScreenRoute>{
                            LoginScreen(
                                navController = navController,
                                innerPadding = innerPadding
                            )
                        }

                        composable<RegisterScreenRoute>{
                            RegisterScreen(
                                navController = navController,
                                innerPadding = innerPadding
                            )
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginAppTheme {
        Greeting("Android")
    }
}