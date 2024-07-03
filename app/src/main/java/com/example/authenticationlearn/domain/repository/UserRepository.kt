package com.example.authenticationlearn.domain.repository

import android.widget.Toast
import com.example.authenticationlearn.domain.model.UserDetailModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val db: FirebaseFirestore
){
    fun getUserdetail(
        id:String
    )= callbackFlow<UserDetailModel>{
        val refUser=db.collection("users").document(id)
        var name:String
        var phone:String
        refUser.get().addOnSuccessListener {
            if(it!=null){
                name= it.get("name") as String
                phone=it.get("phone") as String
                trySend(UserDetailModel(name,phone))
            }
        }.addOnFailureListener {

        }
        awaitClose{
            close()
        }
    }


}