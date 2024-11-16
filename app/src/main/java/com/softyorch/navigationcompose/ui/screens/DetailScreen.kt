package com.softyorch.navigationcompose.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(modifier: Modifier = Modifier, id: String, navigateToUp: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "LOGIN SCREEN $id", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navigateToUp() }) {
            Text(text = "Go To Back")
        }
    }
}