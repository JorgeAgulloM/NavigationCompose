package com.softyorch.navigationcompose.ui.screens

import androidx.compose.foundation.layout.Column
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
fun HomeScreen(modifier: Modifier = Modifier, navigateToDetail: (String) -> Unit) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = modifier.weight(1f))
        Text(text = "HOME SCREEN", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
        Spacer(modifier = modifier.weight(1f))
        Button(onClick = { navigateToDetail("1") }) {
            Text(text = "Go To Detail 1")
        }
        Spacer(modifier = modifier.height(16.dp))
        Button(onClick = { navigateToDetail("2") }) {
            Text(text = "Go To Detail 2")
        }
        Spacer(modifier = modifier.height(16.dp))
        Button(onClick = { navigateToDetail("3") }) {
            Text(text = "Go To Detail 3")
        }
        Spacer(modifier = modifier.weight(1f))
    }
}
