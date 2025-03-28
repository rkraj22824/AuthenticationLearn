package com.example.authenticationlearn.viewmodel


import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authenticationlearn.domain.repository.RegisterRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerRepository: RegisterRepository
):ViewModel(){
    private val _registerMessage = MutableLiveData("")
    val registerMessage: LiveData<String> = _registerMessage


    fun register(name:String,phone:String,email:String,password:String,context:Context)=viewModelScope.launch{
        Log.d("RegisterViewModel","I am here :->")
        registerRepository.register(name,phone, email, password,context).collect{
            _registerMessage.value = it
        }
    }

    fun delete(id:String)=viewModelScope.launch{
        registerRepository.delete(id)
    }

}