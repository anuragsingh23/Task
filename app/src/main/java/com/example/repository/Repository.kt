package com.example.repository

import com.example.task.data.network.RetrofitInstance
import com.example.task.model.Roles

class Repository {

    suspend fun getRoles() : Roles{
       return RetrofitInstance.api.getRoles()
    }
}