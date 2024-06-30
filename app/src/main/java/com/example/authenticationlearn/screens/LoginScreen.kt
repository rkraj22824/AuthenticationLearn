package com.example.authenticationlearn.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LoginScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }

        TextField(
            label = {Text(text = "Email")},
            value = email, onValueChange ={
                email=it
            })
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = {Text(text = "Password")},
            value = password, onValueChange ={
                password=it
            })
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {},
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.fillMaxWidth().height(40.dp).padding(horizontal = 60.dp)
        ) {
            Text(text = "Login")
        }
    }
}
