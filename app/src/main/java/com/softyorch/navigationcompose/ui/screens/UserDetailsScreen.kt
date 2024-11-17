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
import com.softyorch.navigationcompose.ui.model.UserDetailValues

@Composable
fun UserDetailsScreen(modifier: Modifier = Modifier, userDetailValues: UserDetailValues, navigateToUp: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = modifier.weight(1f))
        Text(text = "USER DETAILS SCREEN", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
        Spacer(modifier = modifier.weight(1f))
        Text(text = "User name: ${userDetailValues.name}", fontSize = 18.sp)
        Text(text = "User age: ${userDetailValues.age}", fontSize = 18.sp)
        Text(text = "User email: ${userDetailValues.email}", fontSize = 18.sp)
        Spacer(modifier = modifier.weight(1f))
        Button(onClick = { navigateToUp() }) {
            Text(text = "Go To Back")
        }
        Spacer(modifier = modifier.weight(1f))
    }
}
