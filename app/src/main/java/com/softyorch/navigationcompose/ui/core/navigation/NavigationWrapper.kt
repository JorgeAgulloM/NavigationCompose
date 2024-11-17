package com.softyorch.navigationcompose.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import com.softyorch.navigationcompose.ui.core.navigation.type.genericNavType
import com.softyorch.navigationcompose.ui.model.UserDetailValues
import com.softyorch.navigationcompose.ui.screens.DetailScreen
import com.softyorch.navigationcompose.ui.screens.HomeScreen
import com.softyorch.navigationcompose.ui.screens.LoginScreen
import com.softyorch.navigationcompose.ui.screens.UserDetailsScreen
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen {
                navController.navigate(Home) { popUpTo(0) { inclusive = true } }
            }
        }

        composable<Home>(
            deepLinks = listOf(navDeepLink { uriPattern = URI_HOME })
        ) {
            HomeScreen(
                navigateToUserDetail = { values -> navController.navigate(UserDetail(values)) },
                navigateToDetail = { id -> navController.navigate(Detail(id = id)) }
            )
        }

        composable<Detail>(
            deepLinks = listOf(navDeepLink { uriPattern = URI_DETAIL })
        ) { backStackEntry ->
            val id = getIdFromNavigationOrDeepLink(backStackEntry)
            DetailScreen(
                id = id,
                navigateToUp = {
                    navController.navigate(Home) { popUpTo<Home> { inclusive = true } }
                }
            )
        }

        composable<UserDetail>(
            typeMap = mapOf(typeOf<UserDetailValues>() to genericNavType<UserDetailValues>())
        ) { backStackEntry ->
            val userDetail: UserDetail = backStackEntry.toRoute()
            UserDetailsScreen(
                userDetailValues = userDetail.values,
                navigateToUp = { navController.popBackStack() }
            )
        }
    }
}

@Composable
private fun getIdFromNavigationOrDeepLink(
    backStackEntry: NavBackStackEntry
): String = if (backStackEntry.arguments != null) {
    backStackEntry.arguments?.getString(ID).orEmpty()
} else {
    backStackEntry.toRoute<Detail>().id
}

const val ID = "id"
const val URI_BASE = "https://softyorch.com"
const val URI_HOME = "$URI_BASE/home"
const val URI_DETAIL = "$URI_BASE/detail/{$ID}"
