package com.softyorch.navigationcompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navigateToHome: () -> Unit) {
    Column (modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = modifier.weight(1f))
        Text(text = "LOGIN SCREEN", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
        Spacer(modifier = modifier.weight(1f))
        Button(onClick = { navigateToHome() }) {
            Text(text = "Go To Home")
        }
        Spacer(modifier = modifier.weight(1f))
    }
}
