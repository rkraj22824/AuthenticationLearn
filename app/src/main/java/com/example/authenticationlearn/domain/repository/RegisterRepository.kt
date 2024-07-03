package com.example.authenticationlearn.domain.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegisterRepository @Inject constructor(
    private val fAuth: FirebaseAuth,
    private val db:FirebaseFirestore
){
    fun register( name:String,phone:String,email:String,password:String,context:Context)=callbackFlow<String>{
        Log.d("RegisterRepository","I am here :->")
        fAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    val user= hashMapOf(
                        "name" to name,
                        "email" to email,
                        "phone" to phone
                    )
                    db.collection("users").document(fAuth.currentUser!!.uid).set(user)

                }
            }
        awaitClose{
            close()
        }
    }
    fun delete(id:String){
        db.collection("users").document(id)
            .delete()
            .addOnSuccessListener {
                Log.d("delete","Data Deleted")
            }
            .addOnFailureListener {  }
    }
}




