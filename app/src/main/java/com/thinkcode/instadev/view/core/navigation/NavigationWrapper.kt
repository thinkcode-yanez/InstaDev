package com.thinkcode.instadev.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thinkcode.instadev.view.auth.login.LoginScreen


@Composable
fun NavigationWrwapper() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable <Login>{
            LoginScreen()
        }
    }
}