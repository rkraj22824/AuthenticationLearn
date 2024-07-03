package com.example.authenticationlearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authenticationlearn.domain.repository.RegisterRepository
import com.example.authenticationlearn.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
):ViewModel(){
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _phone = MutableLiveData("")
    val phone: LiveData<String> = _phone

    fun usegetUserdetail(id:String)=viewModelScope.launch{
        userRepository.getUserdetail(id).collect{
            _name.value=it.name
            _phone.value=it.phone
        }
    }

}