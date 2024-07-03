package com.example.authenticationlearn.navigation

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object LoginScreen: Screen("login_screen")
    object SignUpScreen : Screen("sign_screen")
}