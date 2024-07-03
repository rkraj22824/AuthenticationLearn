package com.example.authenticationlearn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.authenticationlearn.screens.HomeScreen
import com.example.authenticationlearn.screens.LoginScreen
import com.example.authenticationlearn.screens.SignupScreen
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val firebaseUser=Firebase.auth.currentUser
    var destination=Screen.SignUpScreen.route

    if (firebaseUser!=null){
        destination=Screen.HomeScreen.route
    }
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = destination) {
        composable(route = Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(route=Screen.HomeScreen.route){
            HomeScreen()
        }
        composable(route=Screen.SignUpScreen.route){
            SignupScreen(navController = navController)
        }

    }

}