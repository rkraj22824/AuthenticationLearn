package com.example.authenticationlearn.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.example.authenticationlearn.viewmodel.LoginViewModel
import com.example.authenticationlearn.viewmodel.RegisterViewModel
import com.example.authenticationlearn.viewmodel.UserViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth

@Composable
fun HomeScreen(

) {

    val userViewModel= hiltViewModel<UserViewModel>()
    val registerViewModel= hiltViewModel<RegisterViewModel>()


    userViewModel.usegetUserdetail(Firebase.auth.currentUser!!.uid)

    val name=userViewModel.name.asFlow().collectAsState(initial = "").value
    val phone=userViewModel.phone.asFlow().collectAsState(initial = "").value

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = name)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = phone)
        
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

        }) {
            Text(text = "Delete Account")
        }

    }
}
