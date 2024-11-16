package com.softyorch.navigationcompose.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.softyorch.navigationcompose.ui.screens.DetailScreen
import com.softyorch.navigationcompose.ui.screens.HomeScreen
import com.softyorch.navigationcompose.ui.screens.LoginScreen

@Composable
fun NavigationWrapper(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen {
                navController.navigate(Home) {
                    popUpTo<Login> {
                        inclusive = true
                    }
                }
            }
        }
        composable<Home> {
            HomeScreen { id -> navController.navigate(Detail(id = id)) }
        }
        composable<Detail> { backStackEntry ->
            val detail = backStackEntry.toRoute<Detail>()
            val id = detail.id
            DetailScreen(id = id) {
                navController.navigateUp()
            }
        }
    }
}
