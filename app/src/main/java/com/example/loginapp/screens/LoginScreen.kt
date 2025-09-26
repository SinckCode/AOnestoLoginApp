package com.example.loginapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun LoginScreen(
    navController : NavController,
    innerPadding : PaddingValues
){
    Column(){
        Text(text = "LoginScreen")
    }
}