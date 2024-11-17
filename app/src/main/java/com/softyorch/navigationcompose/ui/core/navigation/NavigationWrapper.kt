package com.softyorch.navigationcompose.ui.core.navigation

import androidx.compose.runtime.Composable
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
                navController.navigate(Home) {
                    popUpTo<Login> {
                        inclusive = true
                    }
                }
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
        composable<Detail> (
            deepLinks = listOf(navDeepLink { uriPattern = URI_DETAIL })
        ){ backStackEntry ->
            //val detail = backStackEntry.toRoute<Detail>()
            //val id = detail.id

            val id = backStackEntry.arguments?.getString(ID).orEmpty()
            DetailScreen(id = id) {
                navController.navigate(Home) {
                    popUpTo<Detail> { inclusive = true }
                }
            }
        }
        composable<UserDetail>(
            typeMap = mapOf(typeOf<UserDetailValues>() to genericNavType<UserDetailValues>())
        ) { backStackEntry ->
            val userDetail: UserDetail = backStackEntry.toRoute()
            UserDetailsScreen(userDetailValues = userDetail.values) {
                navController.navigateUp()
            }
        }
    }
}

const val ID = "id"
const val URI_BASE = "https://softyorch.com"
const val URI_HOME = "$URI_BASE/home"
const val URI_DETAIL = "$URI_BASE/detail/{$ID}"
