package com.example.loginapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginScreen(
    navController : NavController,
    innerPadding : PaddingValues
){
    Column(
        modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Column(modifier = Modifier
            .weight(1f)) {
            Text(text = "Login Screen")
            Button(onClick = {navController.navigate(RegisterScreenRoute)}) { }
            Text(text = "hola")
        }

        Column(modifier = Modifier
            .weight(1f)) {
            Text(text = "Login Screen")
            Button(onClick = {navController.navigate(RegisterScreenRoute)}) { }
            Text(text = "hola")
        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen(
            navController = rememberNavController(),
            innerPadding = PaddingValues(0.dp)
        )
    }
}