package com.example.authenticationlearn.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authenticationlearn.domain.repository.LoginRepository
import com.example.authenticationlearn.domain.repository.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
): ViewModel(){
    private val _registerMessage = MutableLiveData("")
    val registerMessage: LiveData<String> = _registerMessage


    fun login(email:String,password:String)=viewModelScope.launch{
        Log.d("RegisterViewModel","I am here :->")
        loginRepository.login(email,password).collect{
            _registerMessage.value = it
        }
    }
}