package com.example.task.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repository.Repository
import com.example.task.model.response.Role
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
) : ViewModel(){

    val myResponse : MutableLiveData<List<Role>> = MutableLiveData()

    init {
        getPost()
    }
     private  fun getPost() {
        viewModelScope.launch {
            val response = repository.getRoles()
            myResponse.value = response
        }
    }
}