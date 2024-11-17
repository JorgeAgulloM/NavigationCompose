package com.softyorch.navigationcompose.ui.screens

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.softyorch.navigationcompose.ui.core.navigation.URI_HOME

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navigateToHome: () -> Unit) {
    val context = LocalContext.current

    Column (modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = modifier.weight(1f))
        Text(text = "LOGIN SCREEN", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
        Spacer(modifier = modifier.weight(1f))
        Button(onClick = {
            //navigateToHome()
            val intent = Intent(Intent.ACTION_VIEW, URI_HOME.toUri())
            context.startActivity(intent)
        }) {
            Text(text = "Go To Home")
        }
        Spacer(modifier = modifier.weight(1f))
    }
}
