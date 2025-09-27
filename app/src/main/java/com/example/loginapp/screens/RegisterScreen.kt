package com.example.loginapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun RegisterScreen(
    navController: NavController,
    innerPadding: PaddingValues
) {
    var firstName by remember { mutableStateOf("") }
    var lastName  by remember { mutableStateOf("") }
    var email     by remember { mutableStateOf("") }
    var password  by remember { mutableStateOf("") }
    var confirm   by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(innerPadding)
    ) {
        // ===== HEADER =====
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .background(Color.Black)
                .padding(horizontal = 20.dp, vertical = 16.dp)
                .padding(top = 20.dp)
        ) {
            Text(
                text = "←",
                color = Color.White,
                fontSize = 28.sp,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .clickable { navController.popBackStack() }
            )
            Text(
                text = "Sign Up",
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Light),
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }

        // ===== FORM =====
        Column(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-8).dp)
                .clip(RoundedCornerShape(topStart = 60.dp))
                .background(Color.White)
                .padding(horizontal = 30.dp, vertical = 40.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start
        ) {
            FieldCard("First name", firstName, { firstName = it }, "Vijay")
            Spacer(Modifier.height(20.dp))

            FieldCard("Last name", lastName, { lastName = it }, "Bhuva")
            Spacer(Modifier.height(20.dp))

            FieldCard("Email", email, { email = it }, "email@example.com")
            Spacer(Modifier.height(20.dp))

            FieldCard("Password", password, { password = it }, "••••••••", isPassword = true)
            Spacer(Modifier.height(20.dp))

            FieldCard("Confirm password", confirm, { confirm = it }, "••••••••", isPassword = true)
            Spacer(Modifier.height(20.dp))

            // Botón negro
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Text("Sign Up", color = Color.White, style = MaterialTheme.typography.bodyLarge)
            }

            Spacer(Modifier.height(18.dp))

            Text(
                text = "Already have any account? Sign In",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.popBackStack() },
                textAlign = TextAlign.Center,
                color = Color.Gray
            )


        }
    }
}

// === Campo compacto con sombra ===
@Composable
private fun FieldCard(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(16.dp),
                clip = false
            )
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Text(
            text = label,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
        Spacer(Modifier.height(6.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
                .padding(horizontal = 12.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            val vt =
                if (isPassword) PasswordVisualTransformation() else VisualTransformation.None

            if (value.isEmpty()) {
                Text(placeholder, color = Color(0xFFB9B9B9), fontSize = 15.sp)
            }

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                visualTransformation = vt,
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                ),
                cursorBrush = androidx.compose.ui.graphics.SolidColor(Color.Black),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RegisterPreview() {
    MaterialTheme {
        RegisterScreen(
            navController = rememberNavController(),
            innerPadding = PaddingValues(0.dp)
        )
    }
}
