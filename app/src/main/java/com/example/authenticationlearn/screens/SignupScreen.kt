package com.example.authenticationlearn.screens


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.authenticationlearn.viewmodel.RegisterViewModel


@Composable
fun SignupScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val context= LocalContext.current
        val registerViewModel= hiltViewModel<RegisterViewModel>()

        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        var name by remember {
            mutableStateOf("")
        }
        var phone by remember {
            mutableStateOf("")
        }

        TextField(
            label = {Text(text = "Name")},
            value = name, onValueChange ={
                name=it
            })
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = {Text(text = "Phone")},
            value = phone, onValueChange ={
                phone=it
            })
        Spacer(modifier = Modifier.height(20.dp))
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
        Button(onClick = {
           try {
               registerViewModel.register(name, phone, email, password, context)
               Log.d("SignupScreen","I am here :->")
           }catch(e:Exception){
               Log.d("SignupScreen","Register :->"+e.message)
           }finally {
               Toast.makeText(context,"Added",Toast.LENGTH_SHORT).show()
           }
        },
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 60.dp)
        ) {
            Text(text = "Signup")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignupPreview(){
    SignupScreen()
}