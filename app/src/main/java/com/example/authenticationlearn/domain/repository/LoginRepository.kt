package com.example.authenticationlearn.domain.repository

import android.content.Context
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val fAuth: FirebaseAuth,
    private val db: FirebaseFirestore
){
    fun login(email:String,password:String)=
        callbackFlow<String>{
        Log.d("RegisterRepository","I am here :->")
        fAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {

                }
        awaitClose{
            close()
        }
    }
}